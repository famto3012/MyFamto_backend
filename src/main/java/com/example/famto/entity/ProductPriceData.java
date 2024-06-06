package com.example.famto.entity;

import javax.persistence.Embeddable;

@Embeddable
public class ProductPriceData {

    private String name;
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQuantity() {
        // TODO Auto-generated method stub
        return null;
    }


}
