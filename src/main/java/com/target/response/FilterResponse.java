package com.target.response;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import org.springframework.http.HttpStatus;

public class FilterResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7398650756839233910L;
	private Boolean isOffensive;
	private String text;
	private Set<String> badwords = Collections.emptySet();
	private HttpStatus status;

	public Boolean isOffensive() {
		return isOffensive;
	}

	public void setOffensive(Boolean isOffensive) {
		this.isOffensive = isOffensive;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Set<String> getBadwords() {
		return badwords;
	}

	public void setBadwords(Set<String> badwords) {
		this.badwords = badwords;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
