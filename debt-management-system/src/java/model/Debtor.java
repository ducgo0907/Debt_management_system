/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author ngoqu
 */
public class Debtor {

    private int id;
    private String fullName;
    private String address;
    private String mobilePhone;
    private String email;
    private int genderId;
    private int userId;
    private double totalDebt;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Debtor() {
    }

    public Debtor(int id, String fullName, String address, String mobilePhone, String email, int genderId, int userId, double totalDebt, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.genderId = genderId;
        this.userId = userId;
        this.totalDebt = totalDebt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGenderId() {
        return genderId;
    }

    public void setGenderId(int genderId) {
        this.genderId = genderId;
    }

    public double getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(double totalDebt) {
        this.totalDebt = totalDebt;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "{" + "\"id\" : \"" + id + "\", \"fullName\" : \"" + fullName + "\" , \"address\" : \"" + address 
                + "\", \"mobilePhone\" : \"" + mobilePhone + "\", \"email\" : \"" + email + "\", \"genderId\" : \"" 
                + genderId + "\", \"userId\" : " + userId + ", \"totalDebt\" : " + totalDebt 
                + ", \"createdAt\" : \"" + createdAt + "\", \"updatedAt\": \"" + updatedAt + "\"}";
    }

    
}
