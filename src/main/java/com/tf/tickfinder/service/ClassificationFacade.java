package com.tf.tickfinder.service;

import java.net.MalformedURLException;
import java.net.URL;

import com.tf.tickfinder.model.Classification;

public class ClassificationFacade extends ExternalAbstractFacade<Classification> {

	public ClassificationFacade() {
		super(Classification.class);
	}

	@Override
	protected String getAddress() {
		return ResourceAddress.SINGLE_QUERY_URL;
	}

	public Classification query(String text) {
		try {
			Classification c = find(new URL(getAddress() + text));
			return c;
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
