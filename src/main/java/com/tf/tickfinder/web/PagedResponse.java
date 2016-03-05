package com.tf.tickfinder.web;

public class PagedResponse extends Response {
	private long total;
	private long count;
	private String prevPage;
	private String nextPage;

	public PagedResponse(Object data) {
		super(data);
		setNextPage("");
		setPrevPage("");
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public void setNextPage(String nextPage) {
		this.nextPage = nextPage;
	}

	public String getNextPage() {
		return nextPage;
	}

	public void setPrevPage(String prevPage) {
		this.prevPage = prevPage;
	}

	public String getPrevPage() {
		return prevPage;
	}

}
