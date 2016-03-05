package com.tf.tickfinder.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tf.tickfinder.model.Post;
import com.tf.tickfinder.service.PostFacade;
import com.tf.tickfinder.web.Response;

@RestController
public class PostController {

	@RequestMapping(path = "/api/post", method = RequestMethod.GET)
	public List<Post> getAllPosts() {
		return new PostFacade().findAll();
	}

	@RequestMapping(path = "/api/post/{id}", method = RequestMethod.GET)
	public Post getPost(@PathVariable long id) {
		return new PostFacade().find(id);
	}

	@RequestMapping(path = "api/post/{id}", method = RequestMethod.DELETE)
	public Response deletePost(@PathVariable long id) {
		return new PostFacade().delete(id);
	}

}
