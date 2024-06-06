package com.example.famto.controller;


import com.example.famto.entity.OrderItem;
import com.example.famto.entity.OrderManagement;
import com.example.famto.enums.OrderStatus;
import com.example.famto.exception.ResourceNotFoundException;
import com.example.famto.repository.OrderManagementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/order-management")


public class OrderManagementController {

    @Autowired
    private OrderManagementRepo orderManagementRepo;

    // get all products
    @GetMapping
    public List<OrderManagement> getAllOrders() {
        return this.orderManagementRepo.findAll();

    }

    // get Order by id
    @GetMapping("/{orderId}")
    public OrderManagement getOrderById(@PathVariable(value = "orderId") int orderId) {
        return this.orderManagementRepo.findById(orderId).
                orElseThrow(() -> new ResourceNotFoundException("Order not found with orderId"));
    }


    // create Order
    @PostMapping

    public OrderManagement createOrder(@RequestBody OrderManagement orderManagement) {
        orderManagement.setCustomerId(orderManagement.getCustomerData().getCustomerId());
        return this.orderManagementRepo.save(orderManagement);

    }


    @GetMapping("/{orderId}/items")
    public ResponseEntity<List<OrderItem>> getOrderItems(@PathVariable Integer orderId) {
        OrderManagement order = orderManagementRepo.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with orderId: " + orderId));
        List<OrderItem> orderItems = order.getOrderItems();
        return new ResponseEntity<>(orderItems, HttpStatus.OK);
    }


    @PostMapping("/{orderId}/items")
    public ResponseEntity<OrderManagement> addItemToOrder(@PathVariable Integer orderId, @RequestBody OrderItem orderItem) {
        OrderManagement order = orderManagementRepo.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with orderId: " + orderId));
        orderItem.setOrder(order);
        String itemType = orderItem.getItemType();
        orderItem.setItemType(itemType);
        order.getOrderItems().add(orderItem);
        orderManagementRepo.save(order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @DeleteMapping("/{orderId}/items/{itemId}")
    public ResponseEntity<OrderManagement> deleteOrderItem(@PathVariable Integer orderId, @PathVariable Integer itemId) {
        // Get the order by orderId
        OrderManagement order = orderManagementRepo.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with orderId: " + orderId));

        // Find the order item by itemId
        OrderItem orderItemToDelete = order.getOrderItems().stream()
                .filter(item -> item.getItemId().equals(itemId))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Order item not found with itemId: " + itemId));

        // Remove the order item from the order
        order.getOrderItems().remove(orderItemToDelete);

        // Save the updated order
        orderManagementRepo.save(order);

        // Return the updated order
        return new ResponseEntity<>(order, HttpStatus.OK);
    }


    // update Order data
    @PutMapping("/{orderId}")
    public OrderManagement updateLogin(@RequestBody OrderManagement orderManagement, @PathVariable("orderId") int orderId) {
        OrderManagement existingOrder = this.orderManagementRepo.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with orderId"));

        if (orderManagement.getCustomerData() != null) {
            existingOrder.setCustomerData(orderManagement.getCustomerData());
        }


        existingOrder.setCustomerId(orderManagement.getCustomerId());


        if (orderManagement.getDeliveryMethod() != null) {
            existingOrder.setDeliveryMethod(orderManagement.getDeliveryMethod());
        }

        if (orderManagement.getDeliveryAgent() != null) {
            existingOrder.setDeliveryAgent(orderManagement.getDeliveryAgent());
        }

        if (orderManagement.getPickupAddress() != null) {
            existingOrder.setPickupAddress(orderManagement.getPickupAddress());
        }

        if (orderManagement.getPickupName() != null) {
            existingOrder.setPickupName(orderManagement.getPickupName());
        }

        if (orderManagement.getPickupPhone() != null) {
            existingOrder.setPickupPhone(orderManagement.getPickupPhone());
        }

        if (orderManagement.getPickupEmail() != null) {
            existingOrder.setPickupEmail(orderManagement.getPickupEmail());
        }

        if (orderManagement.getOrderStatus() != null) {
            existingOrder.setOrderStatus(orderManagement.getOrderStatus());
        }
        if (orderManagement.getPickUpInstructions() != null) {
            existingOrder.setPickUpInstructions(orderManagement.getPickUpInstructions());
        }

        if (orderManagement.getDeliveryAddress() != null) {
            existingOrder.setDeliveryAddress(orderManagement.getDeliveryAddress());
        }

        if (orderManagement.getDeliveryOption() != null) {
            existingOrder.setDeliveryOption(orderManagement.getDeliveryOption());
        }
        if (orderManagement.getDeliveryName() != null) {
            existingOrder.setDeliveryName(orderManagement.getDeliveryName());
        }
        if (orderManagement.getDeliveryPhone() != null) {
            existingOrder.setDeliveryPhone(orderManagement.getDeliveryPhone());
        }
        if (orderManagement.getDeliveryEmail() != null) {
            existingOrder.setDeliveryEmail(orderManagement.getDeliveryEmail());
        }
        if (orderManagement.getDeliveryInstructions() != null) {
            existingOrder.setDeliveryInstructions(orderManagement.getDeliveryInstructions());
        }
        if (orderManagement.getDeliveryTime() != null) {
            existingOrder.setDeliveryTime(orderManagement.getDeliveryTime());
        }

        if (orderManagement.getRestaurantDetails() != null) {
            existingOrder.setRestaurantDetails(orderManagement.getRestaurantDetails());
        }

        if (orderManagement.getProductsData() != null) {
            existingOrder.setProductsData(orderManagement.getProductsData());
        }

        if (orderManagement.getSuggestions() != null) {
            existingOrder.setSuggestions(orderManagement.getSuggestions());
        }

        if (orderManagement.getInvoice() != null) {
            existingOrder.setInvoice(orderManagement.getInvoice());
        }

        if (orderManagement.getPaymentMode() != null) {
            existingOrder.setPaymentMode(orderManagement.getPaymentMode());
        }
        if (orderManagement.getPaymentStatus() != null) {
            existingOrder.setPaymentStatus(orderManagement.getPaymentStatus());
        }
        if (orderManagement.getRating() != null) {
            existingOrder.setRating(orderManagement.getRating());
        }
        if (orderManagement.getOrderPreparationTime() != null) {
            existingOrder.setOrderPreparationTime(orderManagement.getOrderPreparationTime());
        }
        if (orderManagement.getDeviceType() != null) {
            existingOrder.setDeviceType(orderManagement.getDeviceType());
        }
        if (orderManagement.getOrderTime() != null) {
            existingOrder.setOrderTime(orderManagement.getOrderTime());
        }
        if (orderManagement.getScheduledDeliveryTime() != null) {
            existingOrder.setScheduledDeliveryTime(orderManagement.getScheduledDeliveryTime());
        }
        if (orderManagement.getHome() != null) {
            existingOrder.setHome(orderManagement.getHome());
        }
        if (orderManagement.getOthers() != null) {
            existingOrder.setOthers(orderManagement.getOthers());
        }
        if (orderManagement.getOffice() != null) {
            existingOrder.setOffice(orderManagement.getOffice());
        }
        if (orderManagement.getPickUpInstructions() != null) {
            existingOrder.setPickUpInstructions(orderManagement.getPickUpInstructions());
        }
        if (orderManagement.getTips() != null) {
            existingOrder.setTips(orderManagement.getTips());
        }
        if (orderManagement.getDeliveryCharges() != null) {
            existingOrder.setDeliveryCharges(orderManagement.getDeliveryCharges());
        }
        if (orderManagement.getDiscount() != null) {
            existingOrder.setDiscount(orderManagement.getDiscount());
        }
        if (orderManagement.getSubTotal() != null) {
            existingOrder.setSubTotal(orderManagement.getSubTotal());
        }


        return this.orderManagementRepo.save(existingOrder);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<OrderManagement> deleteOrdert(@PathVariable("orderId") int orderId) {
        OrderManagement existingOrder = this.orderManagementRepo.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id :" + orderId));
        this.orderManagementRepo.delete(existingOrder);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/{orderId}/status")
    public ResponseEntity<OrderManagement> updateOrderStatus(@PathVariable int orderId, @RequestParam OrderStatus status) {
        OrderManagement existingOrder = this.orderManagementRepo.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with orderId: " + orderId));

        existingOrder.setOrderStatus(status);

        return ResponseEntity.ok(this.orderManagementRepo.save(existingOrder));
    }

    // GetMapping to retrieve all possible order status options
    @GetMapping("/order-status-options")
    public ResponseEntity<OrderStatus[]> getOrderStatusOptions() {
        return ResponseEntity.ok(OrderStatus.values());
    }

    @GetMapping("/customer-order-data/{customerId}")
    public List<OrderManagement> getCustomerOrders(@PathVariable int customerId) {
        return orderManagementRepo.findByCustomerId(customerId);
    }

}