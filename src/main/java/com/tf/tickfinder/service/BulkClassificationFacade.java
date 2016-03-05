package com.tf.tickfinder.service;

import java.net.MalformedURLException;
import java.net.URL;

import com.tf.tickfinder.model.BulkClassification;

public class BulkClassificationFacade extends ExternalAbstractFacade<BulkClassification> {

	public BulkClassificationFacade() {
		super(BulkClassification.class);
	}

	@Override
	protected String getAddress() {
		return ResourceAddress.BULK_QUERY_URL;
	}

	public BulkClassification query(String data) {
		try {
			BulkClassification c = find(new URL(getAddress() + data));
			return c;
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
