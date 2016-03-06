package com.tf.tickfinder.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Search {
	private List<MessageInfo> data;

	public List<MessageInfo> getData() {
		return data;
	}

	public void setData(List<MessageInfo> data) {
		this.data = data;
	}

}
