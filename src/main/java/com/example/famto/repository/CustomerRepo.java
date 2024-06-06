package com.example.famto.repository;

import com.example.famto.entity.CustomerData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface CustomerRepo extends JpaRepository<CustomerData, Integer> {

    @Query("SELECT p FROM CustomerData p WHERE " +

            "p.name LIKE CONCAT('%',:query, '%')")
    List<CustomerData> searchCustomers(String query);
}
