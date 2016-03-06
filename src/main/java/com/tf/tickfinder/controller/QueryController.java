package com.tf.tickfinder.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tf.tickfinder.service.PostSentimentFacade;
import com.tf.tickfinder.web.Response;

@RestController
public class QueryController {

	@RequestMapping(path = "api/classify", params = "url", method = RequestMethod.GET)
	public Response getClassificationByURL(@RequestParam String url) {
		return new Response(new PostSentimentFacade().findByUrl(url));
	}

}
