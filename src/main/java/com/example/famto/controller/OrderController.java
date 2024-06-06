package com.example.famto.controller;

import com.example.famto.entity.Order;
import com.example.famto.exception.ResourceNotFoundException;
import com.example.famto.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")

public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    // get all orders
    @GetMapping
    public List<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    // get order by id
    @GetMapping("/{newId}")
    public Order getOrderById(@PathVariable(value = "newId") Integer newId) {
        return this.orderRepository.findById(newId).orElseThrow(() -> new ResourceNotFoundException("Order not found with newId :" + newId));
    }

    // create order
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return this.orderRepository.save(order);
    }

    // update order status
    @PutMapping("/{newId}")
    public Order updateOrder(@RequestBody Order order, @PathVariable("newId") Integer orderId) {

        Order existingOrder = this.orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with newId :" + orderId));
        if (order.getStatus() != null) {
            existingOrder.setStatus(order.getStatus());
        }
        if (order.getDeliveryPerson() != null) {
            existingOrder.setDeliveryPerson(order.getDeliveryPerson());
        }

        if (order.getDeliveryPersonNumber() != null) {
            existingOrder.setDeliveryPersonNumber(order.getDeliveryPersonNumber());
        }
        if (order.getDeliveryCharge() != null) {
            existingOrder.setDeliveryCharge(order.getDeliveryCharge());
            ;
        }
        if (order.getDeliveryType() != null) {
            existingOrder.setDeliveryType(order.getDeliveryType());
        }
        if (order.getDropLocation() != null) {
            existingOrder.setDropLocation(order.getDropLocation());
        }
        if (order.getEnroute() != null) {
            existingOrder.setEnroute(order.getEnroute());
        }
        if (order.getName() != null) {
            existingOrder.setName(order.getName());
        }
        if (order.getOrderDetails() != null) {
            existingOrder.setOrderDetails(order.getOrderDetails());
        }

        if (order.getOrderId() != null) {
            existingOrder.setOrderId(order.getOrderId());
        }

        if (order.getPhoneNumber() != null) {
            existingOrder.setPhoneNumber(order.getPhoneNumber());
        }
        if (order.getPickupLocation() != null) {
            existingOrder.setPickupLocation(order.getPickupLocation());
        }
        if (order.getVehicleType() != null) {
            existingOrder.setVehicleType(order.getVehicleType());
        }
        return this.orderRepository.save(existingOrder);
    }


    // Search orders by name
    @GetMapping("/searchByName/{name}")
    public ResponseEntity<List<Order>> searchOrdersByName(@PathVariable String name) {
        List<Order> orders = orderRepository.findByNameContaining(name);
        if (orders.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(orders);
    }


    // delete order by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Order> deleteLogin(@PathVariable("id") int id) {
        Order existingOrder = this.orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + id));
        this.orderRepository.delete(existingOrder);
        return ResponseEntity.ok().build();
    }

}

