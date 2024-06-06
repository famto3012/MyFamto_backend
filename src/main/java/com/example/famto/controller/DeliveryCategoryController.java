package com.example.famto.controller;

import com.example.famto.entity.DeliveryCategory;
import com.example.famto.exception.ResourceNotFoundException;
import com.example.famto.repository.DeliveryCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/delivery-category")

public class DeliveryCategoryController {

    @Autowired
    private DeliveryCategoryRepository deliveryCategoryRepository;

    // get all logins
    @GetMapping
    public List<DeliveryCategory> getAllDeliveryCategory() {
        return this.deliveryCategoryRepository.findAll();

    }

    // get delivery category by id
    @GetMapping("/{deliveryId}")
    public DeliveryCategory getDeliveryCategoryById(@PathVariable(value = "deliveryId") long deliveryId) {
        return this.deliveryCategoryRepository.findById(deliveryId).orElseThrow(() ->
                new ResourceNotFoundException("Delivery category not found with deliveryId :" + deliveryId));
    }

    // create delivery category
    @PostMapping
    public DeliveryCategory createDeliveryCategory(@RequestBody DeliveryCategory deliveyCategory) {
        return this.deliveryCategoryRepository.save(deliveyCategory);
    }

    // update delivery category
    @PutMapping("/{deliveryId}")
    public DeliveryCategory updateDeliveryCategory(
            @RequestBody DeliveryCategory deliveryCategory,
            @PathVariable("deliveryId") long deliveryId) {
        DeliveryCategory existingCategory = this.deliveryCategoryRepository.findById(deliveryId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Delivery Category not found with deliveryId :" + deliveryId));
        if (deliveryCategory.getDeliveryName() != null) {
            existingCategory.setDeliveryName(deliveryCategory.getDeliveryName());
        }
        if (deliveryCategory.getImage() != null) {
            existingCategory.setImage(deliveryCategory.getImage());
        }
        return this.deliveryCategoryRepository.save(existingCategory);
    }

    // delete delivery category by id
    @DeleteMapping("/{deliveryId}")
    public ResponseEntity<DeliveryCategory> deleteDeliveryCategory(@PathVariable("deliveryId") long deliveryId) {
        DeliveryCategory existingCategory = this.deliveryCategoryRepository.findById(deliveryId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Delivery User not found with deliveryId :" + deliveryId));
        this.deliveryCategoryRepository.delete(existingCategory);
        return ResponseEntity.ok().build();
    }

}

