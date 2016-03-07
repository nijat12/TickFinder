package com.tf.tickfinder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.tf.tickfinder.model.Feed;
import com.tf.tickfinder.model.FeedMessage;
import com.tf.tickfinder.model.MessageInfo;
import com.tf.tickfinder.model.Post;
import com.tf.tickfinder.model.PostSentiment;
import com.tf.tickfinder.model.Search;
import com.tf.tickfinder.model.Tag;
import com.tf.tickfinder.service.FeedFacade;
import com.tf.tickfinder.service.PostFacade;
import com.tf.tickfinder.service.PostSentimentFacade;
import com.tf.tickfinder.service.SearchFacade;
import com.tf.tickfinder.service.TagFacade;

public class FacebookPostSearcher {

	public static void main(String[] args) {
		new FacebookPostSearcher().search();
	}

	public void search() {
		Tag tag = new TagFacade().find(1);
		if (tag.getTags().length() > 0) {
			String[] csv = tag.getTags().split(",");

			for (String value : csv) {
				System.out.println("Searching " + value);
				Search search = new SearchFacade().find(value);

				if (search != null) {

					for (MessageInfo data : search.getData()) {
						Feed feed = new FeedFacade().find(data.getId());

						for (FeedMessage message : feed.getData()) {
							String url = "http://www.facebook.com/" + message.getId();
							PostSentiment sentiment = new PostSentimentFacade().findByUrl(url);

							try {
								if (sentiment != null) {
									Post post = buildPost(data, message, sentiment);
									new PostFacade().create(post);
									System.out.println("Added post");
								}
							}
							catch (NullPointerException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}

	private Post buildPost(MessageInfo data, FeedMessage message, PostSentiment sentiment) {
		Post post = new Post();

		if (sentiment.getDocSentiment().getType().equals("negative")) {
			post.setPolarity(-1);
		}
		else if (sentiment.getDocSentiment().getType().equals("neutral")) {
			post.setPolarity(0);
		}
		else {
			post.setPolarity(1);
		}
		post.setScore(sentiment.getDocSentiment().getScore());
		post.setSource(sentiment.getUrl());
		post.setContent(message.getMessage());
		post.setUser(data.getName());
		post.setCreatedTime(message.getCreatedTime());
		post.setPicture(message.getPicture());
		return post;
	}

	public static String getJson(String fileName) {
		String json = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));

			String line = "";
			while ((line = reader.readLine()) != null) {
				json += line;
			}
			reader.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}
}
