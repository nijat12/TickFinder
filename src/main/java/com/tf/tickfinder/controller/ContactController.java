package com.tf.tickfinder.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tf.tickfinder.model.Contact;
import com.tf.tickfinder.service.ContactFacade;
import com.tf.tickfinder.web.Response;

@RestController
public class ContactController {

	@RequestMapping(path = { "/api/contact", "/api/contact/{id}" }, method = RequestMethod.OPTIONS)
	public javax.ws.rs.core.Response getOptions() {
		return javax.ws.rs.core.Response.ok().header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS").header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}

	@RequestMapping(path = "/api/contact", method = RequestMethod.GET)
	public List<Contact> getAllContacts() {
		return new ContactFacade().findAll();
	}

	@RequestMapping(path = "/api/contact/{id}", method = RequestMethod.GET)
	public Contact getContact(@PathVariable long id) {
		return new ContactFacade().find(id);
	}

	@RequestMapping(path = "api/contact", method = RequestMethod.POST)
	public Contact addContact() {
		return new ContactFacade().create(new Contact());
	}

	@RequestMapping(path = "/api/contact/{id}", method = RequestMethod.POST)
	public Response addContact(@RequestBody String body) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Contact contact = mapper.readValue(body, Contact.class);
			return new Response(new ContactFacade().update(contact));
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

	@RequestMapping(path = "/api/contact/delete/{id}", method = RequestMethod.POST)
	public Response deleteContact(@PathVariable long id) {
		return new ContactFacade().delete(id);
	}

}
