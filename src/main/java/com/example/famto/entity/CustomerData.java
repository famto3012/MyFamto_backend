package com.example.famto.entity;

import converter.AddressConvertorClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer_data")
public class CustomerData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "city")
    protected String city;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "password")
    private String password;
    @Column(name = "total_wallet_balance")
    private Double totalWalletBalance;
    @Convert(converter = AddressConvertorClass.class)
    @Column(columnDefinition = "json", name = "address")
    private List<AddressModel> address = new ArrayList<>();


    @Convert(converter = VersionsModel.class)
    @Column(columnDefinition = "json", name = "versions")
    private List<VersionsModel> versions = new ArrayList<>();

    @Convert(converter = TagsModel.class)
    @Column(columnDefinition = "json", name = "tags")
    private List<TagsModel> tags = new ArrayList<>();

    @Column(name = "lastUsedPlatform")
    private String lastUsedPlatform;

    @Column(name = "wallet_balance")
    private Double walletBalance;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date registerAt;  // Auto order cancellation after x min // subject to discussion

    @Column(name = "codStatus")
    private Boolean codStatus;

    @Column(name = "payLaterStatus")
    private Boolean payLaterStatus;

    @Column(name = "referralCode")
    private String referralCode;

    @Column(name = "rateAndReview")
    private Double rateAndReview;

    @Column(name = "locality")
    private String locality;

    @Column(name = "landMark")
    private String landMark;

    @Column(name = "houseNo")
    private String houseNo;

    @Column(name = "is_blocked")
    private Boolean blocked;

    @Column(name = "amount")
    private Boolean amount;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Double getTotalWalletBalance() {
        return totalWalletBalance;
    }

    public void setTotalWalletBalance(Double totalWalletBalance) {
        this.totalWalletBalance = totalWalletBalance;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getLandMark() {
        return landMark;
    }

    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public Boolean getAmount() {
        return amount;
    }

    public void setAmount(Boolean amount) {
        this.amount = amount;
    }

    public List<AddressModel> getAddress() {
        return address;
    }

    public void setAddress(List<AddressModel> address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastUsedPlatform() {
        return lastUsedPlatform;
    }

    public void setLastUsedPlatform(String lastUsedPlatform) {
        this.lastUsedPlatform = lastUsedPlatform;
    }

    public Boolean getCodStatus() {
        return codStatus;
    }

    public void setCodStatus(Boolean codStatus) {
        this.codStatus = codStatus;
    }

    public Boolean getPayLaterStatus() {
        return payLaterStatus;
    }

    public void setPayLaterStatus(Boolean payLaterStatus) {
        this.payLaterStatus = payLaterStatus;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public Double getRateAndReview() {
        return rateAndReview;
    }

    public void setRateAndReview(Double rateAndReview) {
        this.rateAndReview = rateAndReview;
    }

    public List<VersionsModel> getVersions() {
        return versions;
    }

    public void setVersions(List<VersionsModel> versions) {
        this.versions = versions;
    }

    public List<TagsModel> getTags() {
        return tags;
    }

    public void setTags(List<TagsModel> tags) {
        this.tags = tags;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(Double walletBalance) {
        this.walletBalance = walletBalance;
    }

    public Date getRegisterAt() {
        return registerAt;
    }

    public void setRegisterAt(Date registerAt) {
        this.registerAt = registerAt;
    }

    @PrePersist
    private void onCreate() {
        registerAt = new Date();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}



