package com.example.reserva.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "book")
public class Reserva {

    @Id
    private String id;
    private String name;
    private String lastname;
    private int age;
    private String phoneNumber;
    private Date startDate;
    private Date endDate;
    private String houseId;
    private String discountCode;

    public Reserva() { }

    public Reserva(String id, String name, String lastname, int age, String phoneNumber, Date startDate,
                   Date endDate, String houseId, String discountCode) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.houseId = houseId;
        this.discountCode = discountCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }
}
