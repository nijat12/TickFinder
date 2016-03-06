package com.tf.tickfinder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tf.tickfinder.model.Feed;
import com.tf.tickfinder.model.FeedMessage;
import com.tf.tickfinder.model.MessageInfo;
import com.tf.tickfinder.model.Post;
import com.tf.tickfinder.model.PostSentiment;
import com.tf.tickfinder.model.Search;
import com.tf.tickfinder.service.FeedFacade;
import com.tf.tickfinder.service.PostFacade;
import com.tf.tickfinder.service.PostSentimentFacade;

public class FacebookTest {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		Search search = null;
		try {
			search = mapper.readValue(getJson("search_data.json"), Search.class);
		}
		catch (JsonParseException e1) {
			e1.printStackTrace();
		}
		catch (JsonMappingException e1) {
			e1.printStackTrace();
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}

		if (search == null) {
			System.exit(1);
		}
		for (MessageInfo data : search.getData()) {
			Feed feed = new FeedFacade().find(data.getId());

			for (FeedMessage message : feed.getData()) {
				String url = "http://www.facebook.com/" + message.getId();
				PostSentiment sentiment = new PostSentimentFacade().findByUrl(url);

				try {
					if (!sentiment.getDocSentiment().getType().equals("positive")) {
						Post post = new Post();

						if (sentiment.getDocSentiment().getType().equals("negative")) {
							post.setPolarity(-1);
						}
						else {
							post.setPolarity(0);
						}
						post.setScore(sentiment.getDocSentiment().getScore());
						post.setSource(sentiment.getUrl());
						post.setContent(message.getMessage());
						post.setUser(data.getName());
						post.setCreatedTime(message.getCreatedTime());
						new PostFacade().create(post);
						System.out.println("Added post");
					}
				}
				catch (NullPointerException e) {
					e.printStackTrace();
				}
				System.out.println("FeedMessage done");
			}
		}
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
