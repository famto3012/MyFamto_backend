package com.example.famto.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.ArrayList;
import java.util.List;

//import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@Embeddable
public class OrderDetails {

    @Embedded
    protected List<TaskDetails> taskDetails = new ArrayList<>();

    protected String instructions;
    protected String tip;
    protected double deliveryCharges;
    protected double discount;
    protected String paymentType;
    protected double subTotal;


    public List<TaskDetails> getTaskDetails() {
        return taskDetails;
    }

    public void setTaskDetails(List<TaskDetails> taskDetails) {
        this.taskDetails = taskDetails;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public double getDeliveryCharges() {
        return deliveryCharges;
    }

    public void setDeliveryCharges(double deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }


}