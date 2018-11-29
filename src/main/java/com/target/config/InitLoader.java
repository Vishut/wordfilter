package com.target.config;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

/*
 * 
 */
@Component
public class InitLoader {

	public static HashSet<String> badword = new HashSet<>();
	public static HashMap<String, String> leetspeak = new HashMap<>();

	@PostConstruct
	private void init() {
		loadBadWords();
		loadLeetspeakChars();
	}

	/*
	 * load from file or from database or any other source, here we are loading from
	 * txt file
	 */
	private void loadBadWords() {
		try (Stream<String> stream = Files
				.lines(Paths.get(getClass().getClassLoader().getResource("badwords.txt").toURI()))) {
			badword = (HashSet<String>) stream.map(String::toLowerCase).collect(Collectors.toSet());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * load from file or from database or any other source, here we are loading from
	 * txt file
	 */
	private void loadLeetspeakChars() {
		try (Stream<String> stream = Files
				.lines(Paths.get(getClass().getClassLoader().getResource("leetspeak.txt").toURI()))) {
			stream.filter(line -> line.contains(":"))
					.forEach(line -> leetspeak.putIfAbsent(line.split(":")[0], line.split(":")[1]));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
