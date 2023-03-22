/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author bang
 */
public class Debt {

    private int id;
    private int debtorId;
    private boolean isDebt;
    private double money;
    private String note;
    private Date startDate;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private int createdBy;

    public Debt() {
    }

    public Debt(int id, int debtorId, boolean isDebt, double money, String note, Date startDate, Timestamp createdAt, Timestamp updatedAt, int createdBy) {
        this.id = id;
        this.debtorId = debtorId;
        this.isDebt = isDebt;
        this.money = money;
        this.note = note;
        this.startDate = startDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDebtorId() {
        return debtorId;
    }

    public void setDebtorId(int debtorId) {
        this.debtorId = debtorId;
    }

    public boolean isIsDebt() {
        return isDebt;
    }

    public void setIsDebt(boolean isDebt) {
        this.isDebt = isDebt;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "{" + "\"id\" : \"" + id + "\", \"debtorId\" : \"" + debtorId + "\" , \"isDebt\" : \"" + isDebt 
                + "\", \"money\" : \"" + money + "\", \"note\" : \"" + note + "\", \"startDate\" : \"" 
                + startDate + "\", \"createdAt\" : \"" + createdAt + "\", \"updatedAt\": \"" + updatedAt + "\", \"createdBy\": \"" + createdBy + "\"}";
    }

}
