package com.example.famto.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private OrderManagement order;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unit")
    private String unit;

    @Column(name = "item_type")
    private String itemType;

    @Column(name = "height")
    private double height;

    @Column(name = "length")
    private double length;

    @Column(name = "width")
    private double width;

    @Column(name = "extraWeight")
    private double extraWeight;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderManagement getOrder() {
        return order;
    }

    public void setOrder(OrderManagement order) {
        this.order = order;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getExtraWeight() {
        return extraWeight;
    }

    public void setExtraWeight(double extraWeight) {
        this.extraWeight = extraWeight;
    }

    public Object getItemId() {
        // TODO Auto-generated method stub
        return null;
    }


}
