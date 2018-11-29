package com.target.service;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.target.config.InitLoader;
import com.target.response.FilterResponse;

@Service
public class WordFilterServiceImpl implements WordFilterservice {

	@Override
	public FilterResponse filter(String input) {
		FilterResponse response = new FilterResponse();
		Set<String> badwords = null;

		String textToProcess = input;
		try {
			textToProcess = replaceDots(input);
			textToProcess = replaceLeetspeak(textToProcess);
			textToProcess = convertToLowerCase(textToProcess);
			String[] inputArr = getInputTextArr(textToProcess);
			badwords = checkBadwords(inputArr);
			if (badwords.size() != 0) {
				response.setBadwords(badwords);
				response.setOffensive(true);
			} else {
				response.setOffensive(false);
			}
			response.setStatus(HttpStatus.OK);
			response.setText(input);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	private String[] getInputTextArr(String text) {
		return text.split("\\s");
	}

	private String replaceLeetspeak(String text) {
		for (Entry<String, String> entry : InitLoader.leetspeak.entrySet()) {
			text = text.replaceAll(entry.getKey(), entry.getValue());
		}
		return text;
	}

	private String replaceDots(String text) {
		return text.replaceAll("\\.", "");
	}

	private String convertToLowerCase(String text) {
		return text.toLowerCase();
	}

	private Set<String> checkBadwords(String[] inputArr) {
		Set<String> badwordsList = new HashSet<>();
		char[] chararr = null;
		for (String word : inputArr) {
			if (InitLoader.badword.contains(word)) {
				badwordsList.add(word);
				continue;
			}
			chararr = word.toCharArray();
			StringBuilder sb = new StringBuilder();
			for (char c : chararr) {
				sb.append(c);
				if (sb.length() > 2) {
					if (InitLoader.badword.contains(sb.toString())) {
						badwordsList.add(sb.toString());
					}
				}
			}
		}
		return badwordsList;
	}

}
