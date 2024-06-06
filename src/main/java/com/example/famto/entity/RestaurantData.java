package com.example.famto.entity;

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
@Table(name = "restaurant_data")
public class RestaurantData {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long restaurantId;
    @Column(name = "restaurant_name")
    private String restaurantName;

    @ManyToOne
    @JoinColumn(name = "user_id") // Assuming the column in the restaurant_data table is named "user_id"
    private User user;

    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "city")
    private String city;
    @Column(name = "display_address")
    private String displayAddress;
    @Column(name = "contact_name")
    private String contactName;
    @Column(name = "description")
    private String description;
    @Column(name = "slug")
    private String slug;
    @Column(name = "logo_url")
    private String logoUrl;
    @Column(name = "banner_url")
    private String bannerUrl;
    @Column(name = "bg_color")
    private String bgColour;
    @Column(name = "rating_bar_color")
    private String ratingBarColor;
    @Column(name = "location")
    private String location;
    @Column(name = "serving_area")
    private String servingArea;
    @Column(name = "commission_type")
    private String commissionType;
    @Column(name = "rating")
    private Double rating;
    @Column(name = "service_status")
    private Boolean serviceStatus;
    @Column(name = "sponsorship")
    private Boolean sponsorship;
    @Column(name = "commission_value")
    private Double commissionValue;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "registration_approved", columnDefinition = "boolean default false")
    private boolean registrationApproved;
    @Column(name = "status")
    private String status;
    @Column(name = "geo_fence")
    private String geoFence;
    @Column(name = "pan_card_number")
    private String panCardNumber;
    @Lob
    @Column(name = "pan_card_photo")
    private byte[] panCardPhoto;
    @Column(name = "gstin_number")
    private String gstinNumber;
    @Lob
    @Column(name = "gstin_photo")
    private byte[] gstinPhoto;
    @Column(name = "fssai_number")
    private String fssaiNumber;
    @Lob
    @Column(name = "fssai_photo")
    private byte[] fssaiPhoto;
    @Column(name = "aadhaar_number")
    private String aadhaarNumber;
    @Lob
    @Column(name = "aadhaar_photo")
    private byte[] aadhaarPhoto;
    @Column(name = "business_category")
    private String businessCategory; // Business category dropdown
    @Column(name = "food_type_veg")
    private boolean foodTypeVeg; // Veg radio button
    @Column(name = "food_type_non_veg")
    private boolean foodTypeNonVeg; // Non-veg radio button
    @Column(name = "food_type_both")
    private boolean foodTypeBoth; // Both radio button
    @Column(name = "order_type_on_demand")
    private boolean orderTypeOnDemand; // On-demand radio button
    @Column(name = "order_type_scheduled")
    private boolean orderTypeScheduled; // Scheduled radio button
    @Column(name = "order_type_both")
    private boolean orderTypeBoth; // Both radio button
    @Column(name = "time")
    private String time;
    @Column(name = "no_serving")
    private String noServing;
    @Column(name = "serving_radius")
    private String servingRadius;
    @Column(name = "date")
    private Date date;
    @Column(name = "start_time")
    private String startTime;
    @Column(name = "end_time")
    private String endTime;
    @Column(name = "day")
    private String day;
    @Column(name = "open_all_day")
    private boolean openAllDay;
    @Column(name = "closed_all_day")
    private boolean closedAllDay;
    @Column(name = "specific_time")
    private boolean specificTime;
    @Column(name = "name")
    private String name;
    @Column(name = "image_url")
    private String ImageUrl;
    @Column(name = "amount")
    private String amount;
    @Column(name = "duration")
    private String duration;
    @Column(name = "tax_id")
    private String taxId;
    @Column(name = "Renewal")
    private String Renewal;
    @Column(name = "reason_for_blocking")
    private String reasonForBlocking;
    @Convert(converter = RestaurantTagsModel.class)
    @Column(name = "tags", nullable = true)
    private List<String> tags = new ArrayList<>();
    @Column(name = "tag")
    private String tag;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }



    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDisplayAddress() {
        return displayAddress;
    }

    public void setDisplayAddress(String displayAddress) {
        this.displayAddress = displayAddress;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getBgColour() {
        return bgColour;
    }

    public void setBgColour(String bgColour) {
        this.bgColour = bgColour;
    }

    public String getRatingBarColor() {
        return ratingBarColor;
    }

    public void setRatingBarColor(String ratingBarColor) {
        this.ratingBarColor = ratingBarColor;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getServingArea() {
        return servingArea;
    }

    public void setServingArea(String servingArea) {
        this.servingArea = servingArea;
    }

    public String getCommissionType() {
        return commissionType;
    }

    public void setCommissionType(String commissionType) {
        this.commissionType = commissionType;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Boolean getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(Boolean serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public Boolean getSponsorship() {
        return sponsorship;
    }

    public void setSponsorship(Boolean sponsorship) {
        this.sponsorship = sponsorship;
    }

    public Double getCommissionValue() {
        return commissionValue;
    }

    public void setCommissionValue(Double commissionValue) {
        this.commissionValue = commissionValue;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public boolean isRegistrationApproved() {
        return registrationApproved;
    }

    public void setRegistrationApproved(boolean registrationApproved) {
        this.registrationApproved = registrationApproved;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGeoFence() {
        return geoFence;
    }

    public void setGeoFence(String geoFence) {
        this.geoFence = geoFence;
    }

    public String getPanCardNumber() {
        return panCardNumber;
    }

    public void setPanCardNumber(String panCardNumber) {
        this.panCardNumber = panCardNumber;
    }

    public byte[] getPanCardPhoto() {
        return panCardPhoto;
    }

    public void setPanCardPhoto(byte[] panCardPhoto) {
        this.panCardPhoto = panCardPhoto;
    }

    public String getGstinNumber() {
        return gstinNumber;
    }

    public void setGstinNumber(String gstinNumber) {
        this.gstinNumber = gstinNumber;
    }

    public byte[] getGstinPhoto() {
        return gstinPhoto;
    }

    public void setGstinPhoto(byte[] gstinPhoto) {
        this.gstinPhoto = gstinPhoto;
    }

    public String getFssaiNumber() {
        return fssaiNumber;
    }

    public void setFssaiNumber(String fssaiNumber) {
        this.fssaiNumber = fssaiNumber;
    }

    public byte[] getFssaiPhoto() {
        return fssaiPhoto;
    }

    public void setFssaiPhoto(byte[] fssaiPhoto) {
        this.fssaiPhoto = fssaiPhoto;
    }

    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

    public byte[] getAadhaarPhoto() {
        return aadhaarPhoto;
    }

    public void setAadhaarPhoto(byte[] aadhaarPhoto) {
        this.aadhaarPhoto = aadhaarPhoto;
    }

    public String getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }

    public boolean isFoodTypeVeg() {
        return foodTypeVeg;
    }

    public void setFoodTypeVeg(boolean foodTypeVeg) {
        this.foodTypeVeg = foodTypeVeg;
    }

    public boolean isFoodTypeNonVeg() {
        return foodTypeNonVeg;
    }

    public void setFoodTypeNonVeg(boolean foodTypeNonVeg) {
        this.foodTypeNonVeg = foodTypeNonVeg;
    }

    public boolean isFoodTypeBoth() {
        return foodTypeBoth;
    }

    public void setFoodTypeBoth(boolean foodTypeBoth) {
        this.foodTypeBoth = foodTypeBoth;
    }

    public boolean isOrderTypeOnDemand() {
        return orderTypeOnDemand;
    }

    public void setOrderTypeOnDemand(boolean orderTypeOnDemand) {
        this.orderTypeOnDemand = orderTypeOnDemand;
    }

    public boolean isOrderTypeScheduled() {
        return orderTypeScheduled;
    }

    public void setOrderTypeScheduled(boolean orderTypeScheduled) {
        this.orderTypeScheduled = orderTypeScheduled;
    }

    public boolean isOrderTypeBoth() {
        return orderTypeBoth;
    }

    public void setOrderTypeBoth(boolean orderTypeBoth) {
        this.orderTypeBoth = orderTypeBoth;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNoServing() {
        return noServing;
    }

    public void setNoServing(String noServing) {
        this.noServing = noServing;
    }

    public String getServingRadius() {
        return servingRadius;
    }

    public void setServingRadius(String servingRadius) {
        this.servingRadius = servingRadius;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public boolean isOpenAllDay() {
        return openAllDay;
    }

    public void setOpenAllDay(boolean openAllDay) {
        this.openAllDay = openAllDay;
    }

    public boolean isClosedAllDay() {
        return closedAllDay;
    }

    public void setClosedAllDay(boolean closedAllDay) {
        this.closedAllDay = closedAllDay;
    }

    public boolean isSpecificTime() {
        return specificTime;
    }

    public void setSpecificTime(boolean specificTime) {
        this.specificTime = specificTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getRenewal() {
        return Renewal;
    }

    public void setRenewal(String renewal) {
        Renewal = renewal;
    }

    public String getReasonForBlocking() {
        return reasonForBlocking;
    }

    public void setReasonForBlocking(String reasonForBlocking) {
        this.reasonForBlocking = reasonForBlocking;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public boolean hasRating() {
        return this.rating != null;
    }


}

