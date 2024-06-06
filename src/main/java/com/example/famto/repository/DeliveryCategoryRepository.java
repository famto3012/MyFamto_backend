package com.example.famto.repository;

import com.example.famto.entity.DeliveryCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface DeliveryCategoryRepository extends JpaRepository<DeliveryCategory, Long> {


}