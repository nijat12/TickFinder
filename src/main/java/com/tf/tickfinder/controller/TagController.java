package com.tf.tickfinder.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tf.tickfinder.model.Tag;
import com.tf.tickfinder.service.TagFacade;
import com.tf.tickfinder.web.Response;

@RestController
public class TagController {

	@RequestMapping(path = { "/api/tag", "/api/tag/{id}" }, method = RequestMethod.OPTIONS)
	public javax.ws.rs.core.Response getOptions() {
		return javax.ws.rs.core.Response.ok().header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS").header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}

	@RequestMapping(path = "/api/tag", method = RequestMethod.GET)
	public List<Tag> getAllTags() {
		return new TagFacade().findAll();
	}

	@RequestMapping(path = "/api/tag", method = RequestMethod.POST)
	public Response addTag(@RequestBody String body) {
		try {
			Tag tag = new ObjectMapper().readValue(body, Tag.class);
			new TagFacade().update(tag);
			return new Response("OK");
		}
		catch (JsonParseException e) {
			e.printStackTrace();
		}
		catch (JsonMappingException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return new Response(null);
	}

}
