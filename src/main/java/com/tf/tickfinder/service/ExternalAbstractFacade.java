package com.tf.tickfinder.service;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class ExternalAbstractFacade<T> {
	private Class<T> entityClass;
	private ObjectMapper mapper;

	public ExternalAbstractFacade(Class<T> entityClass) {
		this.entityClass = entityClass;
		mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	/**
	 * Find entity by an identifier.
	 * 
	 * @param id
	 * @return
	 */
	public T find(Serializable id) {
		try {
			T t = (T) find(new URL(getAddress() + "/" + id));
			return t;
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected abstract String getAddress();

	protected T find(URL url) {
		try {
			if (url != null) {
				return mapper.readValue(url, entityClass);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected ObjectMapper getMapper() {
		return mapper;
	}

}
