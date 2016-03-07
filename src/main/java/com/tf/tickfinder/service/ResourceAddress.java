package com.tf.tickfinder.service;

public class ResourceAddress {

	public static final String SINGLE_QUERY_URL = "http://www.sentiment140.com/api/classify?appid=tickfinderapp@gmail.com&text=";

	public static final String BULK_QUERY_URL = "http://www.sentiment140.com/api/bulkClassifyJson?appid=tickfinderapp@gmail.com";

	public static final String URL_QUERY_URL = "http://gateway-a.watsonplatform.net/calls/url/URLGetTextSentiment?apikey=7fedf6f0bdb2a635cb07dbc3ef67670be3828dc2&outputMode=json&url=";

	public static final String TEXT_QUERY_URL = "http://gateway-a.watsonplatform.net/calls/url/TextGetTextSentiment?apikey=8704052997ec18c590fad39d45418214176ae415&outputMode=json&text=";
	
	private ResourceAddress() {

	}

}
