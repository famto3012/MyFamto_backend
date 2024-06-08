package com.example.famto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.famto.entity.RestaurantFeedback;
import com.example.famto.services.RestaurantFeedbackService;



@RestController
@RequestMapping("/api/feedback")

public class RestaurantFeedbackController {

	@Autowired
	RestaurantFeedbackService feedbackservice;
	
	@PostMapping("/add/{userId}/{restaurantId}")
	public RestaurantFeedback addRating(@RequestBody RestaurantFeedback feedback ,@PathVariable Long userId, @PathVariable Long restaurantId)
	{
		return feedbackservice.addRating(feedback, userId, restaurantId);
	}
	
	@GetMapping("/{id}")
	public List<RestaurantFeedback> listFeedback(@PathVariable Long id)
	{
		return feedbackservice.listFeedback(id);
	}
}

