package com.tf.tickfinder.service;

import java.net.MalformedURLException;
import java.net.URL;

import com.tf.tickfinder.model.PostSentiment;

public class PostSentimentFacade extends ExternalAbstractFacade<PostSentiment> {

	public PostSentimentFacade() {
		super(PostSentiment.class);
	}

	@Override
	protected String getAddress() {
		return ResourceAddress.QUERY_URL;
	}

	public PostSentiment find(String targetUrl) {
		try {
			PostSentiment sentiment = find(new URL(getAddress() + targetUrl));
			return sentiment;
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
