package com.tf.tickfinder;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.ResponseList;

public class FacebookTest {

	public static void main(String[] args) {
		Facebook facebook = new FacebookFactory().getInstance();
		facebook.setOAuthAppId("809179489193614", "b38afd91febb18c834fe00d837b5443b");
		// facebook.setOAuthPermissions();
		try {
			ResponseList<Post> results = facebook.searchPosts("watermelon");
			System.out.println(results.get(0));
		}
		catch (FacebookException e) {
			e.printStackTrace();
		}
	}
}
