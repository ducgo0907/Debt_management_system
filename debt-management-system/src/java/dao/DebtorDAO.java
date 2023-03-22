/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.sql.Timestamp;
import java.util.List;
import model.Debtor;

/**
 *
 * @author ngoqu
 */
public interface DebtorDAO {

    public void add(String fullName, String address, String mobilePhone,
            String email, int genderId, int userId, float totalDebt, Timestamp createdDate, Timestamp updatedDate) throws Exception;

    public List<Debtor> getAllDebtorByUserId(int userId) throws Exception;

    public List<Debtor> getLimitDebtorByUserId(int userId, int page) throws Exception;

    public int getAmountOfDebtor(int userId) throws Exception;

    public int getAmountOfDebtorBySearch(int userId, String fullName, String address, String mobilePhone,
            String email, int genderId, float debtFrom, float debtTo) throws Exception;

    public List<Debtor> getDebtorBySearch(String fullName, String address, String mobilePhone,
            String email, int genderId, float debtFrom, float debtTo, int userId, int page) throws Exception;

    public Debtor getDebtorById(int debtorId) throws Exception;

    public void updateTotalDebtOfDebtor(double money, Timestamp updatedAt, int debtorId) throws Exception;
    public void updateDebtor(String fullName, String address, String phone, String email, int id) throws Exception;
}
