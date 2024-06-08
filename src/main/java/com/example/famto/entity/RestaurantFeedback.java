package com.example.famto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "feedback")

public class RestaurantFeedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name= "ratings")
	private int ratings;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "user")
	private Long userId;
	
    @Column(name = "restaurant")
	private Long restaurantId;
}

	