package com.tf.tickfinder.service;

import java.net.MalformedURLException;
import java.net.URL;

import com.tf.tickfinder.FacebookQuery;
import com.tf.tickfinder.model.Feed;

public class FeedFacade extends ExternalAbstractFacade<Feed> {

	public FeedFacade() {
		super(Feed.class);
	}

	@Override
	protected String getAddress() {
		return FacebookQuery.BASE_URL;
	}

	public Feed find(String feedId) {
		try {
			Feed feed = find(new URL(getAddress() + "/" + feedId + "/feed?access_token=" + FacebookQuery.ACCESS_TOKEN));
			return feed;
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
