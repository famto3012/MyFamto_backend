package com.example.famto.entity;

import javax.persistence.*;


@Entity
@Table(name = "logins")

public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long loginId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    public Login() {

    }

    public Login(String phoneNumber, String name, String address) {
        super();
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.address = address;
    }

    public long getLoginId() {
        return loginId;
    }

    public void setLoginId(long loginId) {
        this.loginId = loginId;
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

    public void setAddress(String address) {
        this.address = address;
    }


}
