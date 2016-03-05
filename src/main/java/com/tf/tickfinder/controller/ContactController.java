package com.tf.tickfinder.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tf.tickfinder.model.Contact;
import com.tf.tickfinder.service.ContactFacade;
import com.tf.tickfinder.web.Response;

@RestController
public class ContactController {

	@RequestMapping(path = "/api/contact", method = RequestMethod.GET)
	public List<Contact> getAllContacts() {
		return new ContactFacade().findAll();
	}

	@RequestMapping(path = "/api/contact/{id}", method = RequestMethod.GET)
	public Contact getContact(@PathVariable long id) {
		return new ContactFacade().find(id);
	}

	@RequestMapping(path = "api/contact", method = RequestMethod.POST)
	public Contact addContact(@RequestParam(name = "name", defaultValue = "") String name, @RequestParam(name = "email", defaultValue = "") String email, @RequestParam(name = "phone", defaultValue = "") String phone, @RequestParam(name = "level", defaultValue = "0") int level) {
		Contact contact = new Contact();
		contact.setName(name);
		contact.setEmail(email);
		contact.setPhone(phone);
		contact.setLevel(level);
		return new ContactFacade().create(new Contact());
	}

	@RequestMapping(path = "/api/contact/{id}", method = RequestMethod.POST)
	public Response addContact(@PathVariable long id, @RequestParam(name = "name", defaultValue = "") String name, @RequestParam(name = "email", defaultValue = "") String email, @RequestParam(name = "phone", defaultValue = "") String phone, @RequestParam(name = "level", defaultValue = "0") int level) {
		Contact contact = new Contact();
		contact.setId(id);
		contact.setName(name);
		contact.setEmail(email);
		contact.setPhone(phone);
		contact.setLevel(level);
		return new ContactFacade().update(contact);
	}

	@RequestMapping(path = "/api/contact/delete/{id}", method = RequestMethod.POST)
	public Response deleteContact(@PathVariable long id) {
		return new ContactFacade().delete(id);
	}

}
