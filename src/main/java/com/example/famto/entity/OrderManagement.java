package com.example.famto.entity;


import com.example.famto.enums.OrderStatus;
import converter.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_data")
public class OrderManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;

    @Convert(converter = CustomerConvertorClass.class)
    @Column(columnDefinition = "json", name = "customerData")
    private CustomerData customerData;

    @Convert(converter = DeliveryAgentConvertorClass.class)
    @Column(columnDefinition = "json", name = "deliveryAgent")
    private DeliveryPersonRegistration deliveryAgent;

    @Convert(converter = AddressModel.class)
    @Column(columnDefinition = "json", name = "pickupAddress")
    private AddressModel pickupAddress;

    @Convert(converter = AddressModel.class)
    @Column(columnDefinition = "json", name = "deliveryAddress")
    private AddressModel deliveryAddress;

    @Convert(converter = RestaurantDataConvertorClass.class)
    @Column(columnDefinition = "json", name = "restaurantDetails")
    private RestaurantData restaurantDetails;

    @Convert(converter = ProductDataConvertorClass.class)
    @Column(columnDefinition = "json", name = "productsDetails")
    private List<ProductsData> productsData = new ArrayList<>();

    @Convert(converter = InvoiceConvertorClass.class)
    @Column(columnDefinition = "json", name = "invoice")
    private InvoiceModel invoice;


    @Column(name = "customerId")
    private int customerId;

    @Column(name = "deliveryMethod")
    private String deliveryMethod;

    @Column(name = "pickupName")
    private String pickupName;

    @Column(name = "pickupPhone")
    private String pickupPhone;

    @Column(name = "pickupEmail")
    private String pickupEmail;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @Column(name = "pickUpInstructions")
    private String pickUpInstructions;

    @Column(name = "deliveryOption")
    private String deliveryOption;

    @Column(name = "deliveryName")
    private String deliveryName;

    @Column(name = "deliveryPhone")
    private String deliveryPhone;

    @Column(name = "deliveryEmail")
    private String deliveryEmail;

    @Column(name = "deliveryInstructions")
    private String deliveryInstructions;

    @Column(name = "deliveryTime")
    private String deliveryTime;

    @Column(name = "suggestions")
    private String suggestions;

    @Column(name = "paymentMode")
    private String paymentMode;

    @Column(name = "paymentStatus")
    private String paymentStatus;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "orderPreparationTime")
    private String orderPreparationTime;

    @Column(name = "deviceType")
    private String deviceType;

    @Column(name = "orderTime")
    private Date orderTime;

    @Column(name = "scheduledDeliveryTime")
    private Date scheduledDeliveryTime;

    @Column(name = "home")
    private String home;

    @Column(name = "office")
    private String office;

    @Column(name = "others")
    private String others;

    @Column(name = "RestaurantInstructions")
    private String RestaurantInstructions;

    @Column(name = "tips")
    private Double tips;

    @Column(name = "deliveryCharges")
    private Double deliveryCharges;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "SubTotal")
    private Double SubTotal;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public CustomerData getCustomerData() {
        return customerData;
    }

    public void setCustomerData(CustomerData customerData) {
        this.customerData = customerData;
    }

    public DeliveryPersonRegistration getDeliveryAgent() {
        return deliveryAgent;
    }

    public void setDeliveryAgent(DeliveryPersonRegistration deliveryAgent) {
        this.deliveryAgent = deliveryAgent;
    }

    public AddressModel getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(AddressModel pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public AddressModel getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(AddressModel deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public RestaurantData getRestaurantDetails() {
        return restaurantDetails;
    }

    public void setRestaurantDetails(RestaurantData restaurantDetails) {
        this.restaurantDetails = restaurantDetails;
    }

    public List<ProductsData> getProductsData() {
        return productsData;
    }

    public void setProductsData(List<ProductsData> productsData) {
        this.productsData = productsData;
    }

    public InvoiceModel getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceModel invoice) {
        this.invoice = invoice;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getPickupName() {
        return pickupName;
    }

    public void setPickupName(String pickupName) {
        this.pickupName = pickupName;
    }

    public String getPickupPhone() {
        return pickupPhone;
    }

    public void setPickupPhone(String pickupPhone) {
        this.pickupPhone = pickupPhone;
    }

    public String getPickupEmail() {
        return pickupEmail;
    }

    public void setPickupEmail(String pickupEmail) {
        this.pickupEmail = pickupEmail;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPickUpInstructions() {
        return pickUpInstructions;
    }

    public void setPickUpInstructions(String pickUpInstructions) {
        this.pickUpInstructions = pickUpInstructions;
    }

    public String getDeliveryOption() {
        return deliveryOption;
    }

    public void setDeliveryOption(String deliveryOption) {
        this.deliveryOption = deliveryOption;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public String getDeliveryPhone() {
        return deliveryPhone;
    }

    public void setDeliveryPhone(String deliveryPhone) {
        this.deliveryPhone = deliveryPhone;
    }

    public String getDeliveryEmail() {
        return deliveryEmail;
    }

    public void setDeliveryEmail(String deliveryEmail) {
        this.deliveryEmail = deliveryEmail;
    }

    public String getDeliveryInstructions() {
        return deliveryInstructions;
    }

    public void setDeliveryInstructions(String deliveryInstructions) {
        this.deliveryInstructions = deliveryInstructions;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getOrderPreparationTime() {
        return orderPreparationTime;
    }

    public void setOrderPreparationTime(String orderPreparationTime) {
        this.orderPreparationTime = orderPreparationTime;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getScheduledDeliveryTime() {
        return scheduledDeliveryTime;
    }

    public void setScheduledDeliveryTime(Date scheduledDeliveryTime) {
        this.scheduledDeliveryTime = scheduledDeliveryTime;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public String getRestaurantInstructions() {
        return RestaurantInstructions;
    }

    public void setRestaurantInstructions(String restaurantInstructions) {
        RestaurantInstructions = restaurantInstructions;
    }

    public Double getTips() {
        return tips;
    }

    public void setTips(Double tips) {
        this.tips = tips;
    }

    public Double getDeliveryCharges() {
        return deliveryCharges;
    }

    public void setDeliveryCharges(Double deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(Double subTotal) {
        SubTotal = subTotal;
    }


}
