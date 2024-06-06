package com.example.famto.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products_data")
public class ProductsData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    @Column(name = "restaurant_name")
    private String restaurantName;

    @Column(name = "restaurant_id")
    private Integer restaurantId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_image")
    private String productImageUrl;

    @Column(name = "short_desc")
    private String shortDescription;

    @Column(name = "long_desc")
    private String longDescription;

    @Column(name = "price")
    private Double price;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "inventory_status")
    private Boolean inventoryStatus;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "alert")
    private Integer alert;

    @Column(name = "prep_time")
    private Integer prepartionTime;

    @Column(name = "category")
    private String category;

    @Column(name = "category_desc")
    private String categoryDesc;

    @Column(name = "min_order_qty")
    private Integer minOrderQty;

    @Column(name = "max_qty_per_order")
    private Integer maxQtyPerOrder;

    @Column(name = "sku")
    private Integer sku;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "add_on_name")
    private String addOnName;

    @Column(name = "add_on_selection_type")
    private String addOnSelectionType;

    @Column(name = "is_veg")
    private boolean isVeg;

    @Column(name = "is_non_veg")
    private boolean isNonVeg;

    @Column(name = "is_both")
    private boolean isBoth;

    @Convert(converter = ProductTagsModel.class)
    @Column(columnDefinition = "json", name = "tags")
    private List<ProductTagsModel> tags = new ArrayList<>();

    @Convert(converter = OftenBoughtTogetherModel.class)
    @Column(columnDefinition = "json", name = "oftenBoughtTogether")
    private List<OftenBoughtTogetherModel> oftenBoughtTogether = new ArrayList<>();

    @Convert(converter = AddOnsList.class)
    @Column(columnDefinition = "json", name = "addOnsList")
    private List<AddOnsList> addOnsList = new ArrayList<>();

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getInventoryStatus() {
        return inventoryStatus;
    }

    public void setInventoryStatus(Boolean inventoryStatus) {
        this.inventoryStatus = inventoryStatus;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getAlert() {
        return alert;
    }

    public void setAlert(Integer alert) {
        this.alert = alert;
    }

    public Integer getPrepartionTime() {
        return prepartionTime;
    }

    public void setPrepartionTime(Integer prepartionTime) {
        this.prepartionTime = prepartionTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public Integer getMinOrderQty() {
        return minOrderQty;
    }

    public void setMinOrderQty(Integer minOrderQty) {
        this.minOrderQty = minOrderQty;
    }

    public Integer getMaxQtyPerOrder() {
        return maxQtyPerOrder;
    }

    public void setMaxQtyPerOrder(Integer maxQtyPerOrder) {
        this.maxQtyPerOrder = maxQtyPerOrder;
    }

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getAddOnName() {
        return addOnName;
    }

    public void setAddOnName(String addOnName) {
        this.addOnName = addOnName;
    }

    public String getAddOnSelectionType() {
        return addOnSelectionType;
    }

    public void setAddOnSelectionType(String addOnSelectionType) {
        this.addOnSelectionType = addOnSelectionType;
    }

    public List<ProductTagsModel> getTags() {
        return tags;
    }

    public void setTags(List<ProductTagsModel> tags) {
        this.tags = tags;
    }

    public List<OftenBoughtTogetherModel> getOftenBoughtTogether() {
        return oftenBoughtTogether;
    }

    public void setOftenBoughtTogether(List<OftenBoughtTogetherModel> oftenBoughtTogether) {
        this.oftenBoughtTogether = oftenBoughtTogether;
    }

    public List<AddOnsList> getAddOnsList() {
        return addOnsList;
    }

    public void setAddOnsList(List<AddOnsList> addOnsList) {
        this.addOnsList = addOnsList;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public boolean isVeg() {
        return isVeg;
    }

    public void setVeg(boolean isVeg) {
        this.isVeg = isVeg;
    }

    public boolean isNonVeg() {
        return isNonVeg;
    }

    public void setNonVeg(boolean isNonVeg) {
        this.isNonVeg = isNonVeg;
    }

    public boolean isBoth() {
        return isBoth;
    }

    public void setBoth(boolean isBoth) {
        this.isBoth = isBoth;
    }


}



