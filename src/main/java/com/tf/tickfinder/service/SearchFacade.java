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

	public Search find() {
		try {
			Search search = find(new URL(getAddress()));
			return search;
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
