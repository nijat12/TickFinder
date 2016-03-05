package com.tf.tickfinder.model;

public class PostSentiment {
	private String url;
	private DocSentiment docSentiment;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public DocSentiment getDocSentiment() {
		return docSentiment;
	}

	public void setDocSentiment(DocSentiment docSentiment) {
		this.docSentiment = docSentiment;
	}

}
