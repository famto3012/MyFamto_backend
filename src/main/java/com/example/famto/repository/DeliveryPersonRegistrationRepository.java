package com.example.famto.repository;

import com.example.famto.enums.ApprovalStatus;
import com.example.famto.entity.DeliveryPersonRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

;

@Repository

public interface DeliveryPersonRegistrationRepository extends JpaRepository<DeliveryPersonRegistration, Long> {

    public final static String GET_DELIVERY_PERSON_DATA = "SELECT d FROM DeliveryPersonRegistration d WHERE phoneNumber = :phoneNumber";


    @Query(GET_DELIVERY_PERSON_DATA)
    List<DeliveryPersonRegistration> getDeliveryPersonDetails(
            @Param("phoneNumber") String phoneNumber);

    @Query("SELECT u FROM DeliveryPersonRegistration u WHERE u.status = ?1 and u.phoneNumber = ?2")
    DeliveryPersonRegistration findUserByStatusAndPhoneNumber(String status, String phoneNumber);

    List<DeliveryPersonRegistration> findByApprovalStatus(ApprovalStatus approvalStatus);


}