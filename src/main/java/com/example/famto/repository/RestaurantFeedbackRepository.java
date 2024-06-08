package com.example.famto.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.famto.entity.RestaurantFeedback;
import java.util.List;


public interface RestaurantFeedbackRepository extends JpaRepository<RestaurantFeedback, Long>{

	List<RestaurantFeedback> findByRestaurantId(Long id);
}
