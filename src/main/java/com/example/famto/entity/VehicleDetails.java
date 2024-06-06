package com.example.famto.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "vehicle_details")
public class VehicleDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_user_id")
    @JsonBackReference
    private DeliveryPersonRegistration deliveryPerson;

    private String vehicleModel;
    private String vehicleType; // You may replace this with an enum if it's a predefined set of options

    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "rc_front_photo")
    private String rcFrontPhotoUrl;

    @Column(name = "rc_back_photo")
    private String rcBackPhotoUrl;

    /**
     *
     */
    public VehicleDetails() {
        super();
    }

    /**
     * @param id
     * @param deliveryPerson
     * @param vehicleModel
     * @param vehicleType
     * @param licensePlate
     * @param rcFrontPhotoUrl
     * @param rcBackPhotoUrl
     */
    public VehicleDetails(Long id, DeliveryPersonRegistration deliveryPerson, String vehicleModel, String vehicleType,
                          String licensePlate, String rcFrontPhotoUrl, String rcBackPhotoUrl) {
        super();
        this.id = id;
        this.deliveryPerson = deliveryPerson;
        this.vehicleModel = vehicleModel;
        this.vehicleType = vehicleType;
        this.licensePlate = licensePlate;
        this.rcFrontPhotoUrl = rcFrontPhotoUrl;
        this.rcBackPhotoUrl = rcBackPhotoUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DeliveryPersonRegistration getDeliveryPerson() {
        return deliveryPerson;
    }

    public void setDeliveryPerson(DeliveryPersonRegistration deliveryPerson) {
        this.deliveryPerson = deliveryPerson;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getRcFrontPhotoUrl() {
        return rcFrontPhotoUrl;
    }

    public void setRcFrontPhotoUrl(String rcFrontPhotoUrl) {
        this.rcFrontPhotoUrl = rcFrontPhotoUrl;
    }

    public String getRcBackPhotoUrl() {
        return rcBackPhotoUrl;
    }

    public void setRcBackPhotoUrl(String rcBackPhotoUrl) {
        this.rcBackPhotoUrl = rcBackPhotoUrl;
    }


}



