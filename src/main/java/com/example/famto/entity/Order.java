package com.example.famto.entity;

import converter.ItemConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter

@Table(name = "orders")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int newId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "delivery_type")
    private String deliveryType;

    @Column(name = "vehicle_type")
    private String vehicleType;

    @Column(name = "pickup_location")
    private String pickupLocation;  //address, or pin from map or type address and get map response (type ahead)

    @Column(name = "enroute")
    private String enroute;

    @Column(name = "drop_location")
    private String dropLocation; // pin it from map or search from map

    @Column(name = "delivery_charge")
    private Double deliveryCharge; // distance x Cost/Km -- refer folder

    @Column(name = "order_id")
    private String orderId;
    @Convert(converter = ItemConverter.class)
    @Column(columnDefinition = "json", name = "order_details")
    private List<OrderDetails> orderDetails = new ArrayList<>();
    @Column(name = "status")
    private String status;
    @Column(name = "delivery_person")
    private String deliveryPerson;
    @Column(name = "delivery_person_number")
    private String deliveryPersonNumber;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createdAt;  // Auto order cancellation after x min // subject to discussion


    public Order() {


    }

//	private OrderDetails orderDetails;

    public Order(int newId, String phoneNumber, String name, String deliveryType, String vehicleType, String pickupLocation,
                 String enroute, String dropLocation, Double deliveryCharge, String orderId, String status,
                 List<OrderDetails> orderDetails) {
        super();
        this.newId = newId;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.deliveryType = deliveryType;
        this.vehicleType = vehicleType;
        this.pickupLocation = pickupLocation;
        this.enroute = enroute;
        this.dropLocation = dropLocation;
        this.deliveryCharge = deliveryCharge;
        this.orderId = orderId;
        this.status = status;
        this.orderDetails = orderDetails;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getDeliveryPersonNumber() {
        return deliveryPersonNumber;
    }


    //
	
	/*	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;   */

    public void setDeliveryPersonNumber(String deliveryPersonNumber) {
        this.deliveryPersonNumber = deliveryPersonNumber;
    }

    public String getDeliveryPerson() {
        return deliveryPerson;
    }

    public void setDeliveryPerson(String deliveryPerson) {
        this.deliveryPerson = deliveryPerson;
    }

    @PrePersist
    private void onCreate() {

        createdAt = new Date();
    }

    public int getNewId() {
        return newId;
    }

    public void setNewId(int newId) {
        this.newId = newId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getEnroute() {
        return enroute;
    }

    public void setEnroute(String enroute) {
        this.enroute = enroute;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public Double getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(Double deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


}
