package com.example.famto.repository;

import com.example.famto.entity.VehicleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleDetailsRepository extends JpaRepository<VehicleDetails, Long> {
    List<VehicleDetails> findByDeliveryPersonDeliveryUserId(long deliveryUserId);
}
