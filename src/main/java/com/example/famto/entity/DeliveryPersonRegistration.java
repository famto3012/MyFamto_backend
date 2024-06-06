package com.example.famto.entity;

import com.example.famto.enums.ApprovalStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.geo.Point;

import javax.persistence.*;
import java.util.List;


@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "delivey_person_registration")

public class DeliveryPersonRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long deliveryUserId;

    @OneToOne(mappedBy = "deliveryPerson", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Wallet wallet;

    @OneToMany(mappedBy = "deliveryPerson")
    @JsonManagedReference
    private List<VehicleDetails> vehicles;

    @Column(name = "approval_status")
    @Enumerated(EnumType.STRING)
    private ApprovalStatus approvalStatus;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String userName;

    @Column(name = "password", unique = true)
    private String password;

    @Column(name = "team")
    private String team;

    @Column(name = "role")
    private String role;

    @Column(name = "type")
    private String type;

    @Column(name = "geofence")
    private String geofence;

    @Column(name = "transport_type")
    private String transportType;

    @Column(name = "transport_description")
    private String transportDescription;

    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "color")
    private String color;

    @Column(name = "address")
    private String address;

    @Column(name = "pan")
    private String pan;

    @Column(name = "photo")
    private String photo;

    @Column(name = "aadhaar")
    private String aadhaar;

    @Column(name = "aadhar_front_photo")
    private String aadharFrontPhotoUrl;

    @Column(name = "aadhar_back_photo")
    private String aadharBackPhotoUrl;

    @Column(name = "driving_license")
    private String drivingLicense;

    @Column(name = "license_front_photo")
    private String licenseFrontPhotoUrl;

    @Column(name = "license_back_photo")
    private String licenseBackPhotoUrl;

    @Column(name = "availability")
    private Boolean availability;

    @Column(columnDefinition = "geometry")
    private Point geometry;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "status")
    private String status;

    @Column(name = "vehicle_registration")
    private String vehicleRegistration;

    @Column(name = "emergency_contact")
    private String emergencyContact;

    @Column(name = "payment_email")
    private String paymentEmail;

    @Column(name = "bank_account_holder_name")
    private String bankAccountHolderName;

    @Column(name = "bank_account_number")
    private String bankAccountNumber;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "branch")
    private String branch;

    @Column(name = "ifsc_code")
    private String ifscCode;

    @Column(name = "upi_id")
    private String upiId;


    /**
     * @param deliveryUserId
     * @param wallet
     * @param vehicles
     * @param approvalStatus
     * @param phoneNumber
     * @param name
     * @param firstName
     * @param lastName
     * @param email
     * @param userName
     * @param password
     * @param team
     * @param role
     * @param type
     * @param geofence
     * @param transportType
     * @param transportDescription
     * @param licensePlate
     * @param color
     * @param address
     * @param pan
     * @param photo
     * @param aadhaar
     * @param aadharFrontPhotoUrl
     * @param aadharBackPhotoUrl
     * @param drivingLicense
     * @param licenseFrontPhotoUrl
     * @param licenseBackPhotoUrl
     * @param availability
     * @param geometry
     * @param latitude
     * @param longitude
     * @param status
     * @param vehicleRegistration
     * @param emergencyContact
     * @param paymentEmail
     * @param bankAccountHolderName
     * @param bankAccountNumber
     * @param bankName
     * @param branch
     * @param ifscCode
     * @param upiId
     */
    public DeliveryPersonRegistration(long deliveryUserId, Wallet wallet, List<VehicleDetails> vehicles,
                                      ApprovalStatus approvalStatus, String phoneNumber, String name, String firstName, String lastName,
                                      String email, String userName, String password, String team, String role, String type, String geofence,
                                      String transportType, String transportDescription, String licensePlate, String color, String address,
                                      String pan, String photo, String aadhaar, String aadharFrontPhotoUrl, String aadharBackPhotoUrl,
                                      String drivingLicense, String licenseFrontPhotoUrl, String licenseBackPhotoUrl, Boolean availability,
                                      Point geometry, Double latitude, Double longitude, String status, String vehicleRegistration,
                                      String emergencyContact, String paymentEmail, String bankAccountHolderName, String bankAccountNumber,
                                      String bankName, String branch, String ifscCode, String upiId) {
        super();
        this.deliveryUserId = deliveryUserId;
        this.wallet = wallet;
        this.vehicles = vehicles;
        this.approvalStatus = approvalStatus;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.team = team;
        this.role = role;
        this.type = type;
        this.geofence = geofence;
        this.transportType = transportType;
        this.transportDescription = transportDescription;
        this.licensePlate = licensePlate;
        this.color = color;
        this.address = address;
        this.pan = pan;
        this.photo = photo;
        this.aadhaar = aadhaar;
        this.aadharFrontPhotoUrl = aadharFrontPhotoUrl;
        this.aadharBackPhotoUrl = aadharBackPhotoUrl;
        this.drivingLicense = drivingLicense;
        this.licenseFrontPhotoUrl = licenseFrontPhotoUrl;
        this.licenseBackPhotoUrl = licenseBackPhotoUrl;
        this.availability = availability;
        this.geometry = geometry;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = status;
        this.vehicleRegistration = vehicleRegistration;
        this.emergencyContact = emergencyContact;
        this.paymentEmail = paymentEmail;
        this.bankAccountHolderName = bankAccountHolderName;
        this.bankAccountNumber = bankAccountNumber;
        this.bankName = bankName;
        this.branch = branch;
        this.ifscCode = ifscCode;
        this.upiId = upiId;
    }

    public DeliveryPersonRegistration() {
        super();
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public String getPaymentEmail() {
        return paymentEmail;
    }

    public void setPaymentEmail(String paymentEmail) {
        this.paymentEmail = paymentEmail;
    }

    public String getBankAccountHolderName() {
        return bankAccountHolderName;
    }

    public void setBankAccountHolderName(String bankAccountHolderName) {
        this.bankAccountHolderName = bankAccountHolderName;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }

    public ApprovalStatus getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(ApprovalStatus approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public List<VehicleDetails> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleDetails> vehicles) {
        this.vehicles = vehicles;
    }

    public String getAadharFrontPhotoUrl() {
        return aadharFrontPhotoUrl;
    }

    public void setAadharFrontPhotoUrl(String aadharFrontPhotoUrl) {
        this.aadharFrontPhotoUrl = aadharFrontPhotoUrl;
    }

    public String getAadharBackPhotoUrl() {
        return aadharBackPhotoUrl;
    }

    public void setAadharBackPhotoUrl(String aadharBackPhotoUrl) {
        this.aadharBackPhotoUrl = aadharBackPhotoUrl;
    }

    public String getLicenseFrontPhotoUrl() {
        return licenseFrontPhotoUrl;
    }

    public void setLicenseFrontPhotoUrl(String licenseFrontPhotoUrl) {
        this.licenseFrontPhotoUrl = licenseFrontPhotoUrl;
    }

    public String getLicenseBackPhotoUrl() {
        return licenseBackPhotoUrl;
    }

    public void setLicenseBackPhotoUrl(String licenseBackPhotoUrl) {
        this.licenseBackPhotoUrl = licenseBackPhotoUrl;
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
//	@Convert(converter = RestaurantTagsModel.class)
//	@Column(name = "tags")
//	private List<String> tags = new ArrayList<>();
////	
//	public List<String> getTags() {
//		return tags;
//	}
//	public void setTags(List<String> tags) {
//		this.tags = tags;
//	}

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Point getGeometry() {
        return geometry;
    }

    public void setGeometry(Point geometry) {
        this.geometry = geometry;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public long getDeliveryUserId() {
        return deliveryUserId;
    }

    public void setDeliveryUserId(long deliveryUserId) {
        this.deliveryUserId = deliveryUserId;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAadhaar() {
        return aadhaar;
    }

    public void setAadhaar(String aadhaar) {
        this.aadhaar = aadhaar;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGeofence() {
        return geofence;
    }

    public void setGeofence(String geofence) {
        this.geofence = geofence;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public String getTransportDescription() {
        return transportDescription;
    }

    public void setTransportDescription(String transportDescription) {
        this.transportDescription = transportDescription;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public String getVehicleRegistration() {
        return vehicleRegistration;
    }

    public void setVehicleRegistration(String vehicleRegistration) {
        this.vehicleRegistration = vehicleRegistration;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
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

    public String getAddress() {
        return address;
    }
    // Constructor taking a String argument for the 'name' field
//    public DeliveryPersonRegistration(String name) {
//        this.name = name;
//    }

    public void setAddress(String address) {
        this.address = address;
    }


}