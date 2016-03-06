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
		return ResourceAddress.URL_QUERY_URL;
	}

	public PostSentiment findByText(String text) {
		try {
			PostSentiment sentiment = find(new URL(ResourceAddress.TEXT_QUERY_URL + text));
			return sentiment;
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public PostSentiment findByUrl(String targetUrl) {
		try {
			PostSentiment sentiment = find(new URL(ResourceAddress.URL_QUERY_URL + targetUrl));
			return sentiment;
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
