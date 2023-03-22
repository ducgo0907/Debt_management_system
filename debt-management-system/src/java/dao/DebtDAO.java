/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import model.Debt;

/**
 *
 * @author bang
 */
public interface DebtDAO {

    public void create(int debtorId, boolean isDebt, double money, String note, Date startDate, Timestamp createdAt, Timestamp updatedAt, int createdBy) throws Exception;

    public List<Debt> getAllDebt(String debtorID) throws Exception;
    public Debt getDebtById(int debtId) throws Exception;

    public List<Debt> getDebtBySearch( String note, int type,
            float debtFrom, float debtTo, String addFrom, String addTo, String createFrom, String createTo, int debtorId) throws Exception;
}
