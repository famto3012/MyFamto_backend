package com.example.famto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.famto.entity.RestaurantFeedback;
import com.example.famto.repository.RestaurantFeedbackRepository;

import lombok.Data;

@Service
@Data

public class RestaurantFeedbackService {

	@Autowired
	RestaurantFeedbackRepository feedbackrepository;
	
	public RestaurantFeedback addRating(RestaurantFeedback feedback, Long userId, Long restaurantId)
	{
		feedback.setUserId(userId);
		feedback.setRestaurantId(restaurantId);
		return feedbackrepository.save(feedback);
	}
	
	public List<RestaurantFeedback> listFeedback(Long id)
	{
		List<RestaurantFeedback> feedback = feedbackrepository.findByRestaurantId(id);
		return feedback;
	}
}
