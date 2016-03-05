package com.tf.tickfinder.web;

import java.util.List;

public class Response {
	private int status;
	private Object data;

	public Response(Object data) {
		this.data = data;
		status = getCode(data);
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	private int getCode(Object data) {
		if (data instanceof List) {

			@SuppressWarnings("rawtypes")
			List d = (List) data;
			if (d.size() == 0) {
				return 404;
			}
		}

		return data == null ? 404 : 200;
	}

}
