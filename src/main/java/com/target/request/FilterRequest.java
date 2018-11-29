package com.target.request;

import org.springframework.stereotype.Component;

@Component
public class FilterRequest {

	private String comment;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
