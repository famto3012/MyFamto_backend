package com.example.famto.repository;

import com.example.famto.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface OrderRepository extends JpaRepository<Order, Integer> {
    // Custom method to search orders by name
    List<Order> findByNameContaining(String name);

}