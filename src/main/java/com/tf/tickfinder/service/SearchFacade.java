package com.tf.tickfinder.service;

import java.net.MalformedURLException;
import java.net.URL;

import com.tf.tickfinder.FacebookQuery;
import com.tf.tickfinder.model.Search;

public class SearchFacade extends ExternalAbstractFacade<Search> {

	public SearchFacade() {
		super(Search.class);
	}

	@Override
	protected String getAddress() {
		return FacebookQuery.SEARCH_QUERY + FacebookQuery.ACCESS_TOKEN;
	}

	public Search find(String query) {
		try {
			String address = FacebookQuery.BASE_URL + "/search?q=" + query + "&type=page&access_token=" + FacebookQuery.ACCESS_TOKEN;
			address = address.replace(" ", "");
			return find(new URL(address));
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
