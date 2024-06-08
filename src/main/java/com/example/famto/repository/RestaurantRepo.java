package com.example.famto.repository;

import com.example.famto.entity.RestaurantData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface RestaurantRepo extends JpaRepository<RestaurantData, Long> {
    @Query("SELECT p FROM RestaurantData p WHERE " +

            "p.restaurantName LIKE CONCAT('%',:query, '%')")
    List<RestaurantData> searchRestaurants(String query);

    List<RestaurantData> findByReasonForBlockingIsNull();

    Optional<RestaurantData> findByUserId(Long userId);



}
