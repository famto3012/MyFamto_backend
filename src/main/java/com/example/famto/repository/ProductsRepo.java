package com.example.famto.repository;

import com.example.famto.entity.ProductsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface ProductsRepo extends JpaRepository<ProductsData, Integer> {

    @Query("SELECT u FROM ProductsData u WHERE u.restaurantId = ?1")
    List<ProductsData> findRestaurantProducts(int restaurantId);

    @Query("SELECT u FROM ProductsData u WHERE u.restaurantId = ?1 and u.category = ?2")
    List<ProductsData> findUserByRestaurantAndCategory(int restaurantId, String category);

    @Query("SELECT u FROM ProductsData u WHERE u.restaurantId = ?1 and u.category = ?2 and u.productId = ?3")
    ProductsData findUserByRestaurantAndCategoryAndProductId(int restaurantId, String category, int productId);

    // Method to search products by product name containing the provided query (case-insensitive)
    List<ProductsData> findByProductNameContainingIgnoreCase(String productName);
}