package com.tf.tickfinder.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FeedMessage {
	private String message;
	private String id;
	@JsonProperty(value = "created_time")
	private String createdTime;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

}
