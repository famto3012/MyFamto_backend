package com.example.famto.entity;

import javax.persistence.*;


@Entity
@Table(name = "test")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long deliveryId;
    @Column(name = "delivery_type")
    private String deliveryName;


    public Test(long deliveryId, String deliveryName) {
        super();
        this.deliveryId = deliveryId;
        this.deliveryName = deliveryName;
    }


    public Test() {

    }

    public long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

}


