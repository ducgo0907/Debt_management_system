/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import context.DBContext;
import dao.DebtDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Debt;

/**
 *
 * @author bang
 */
public class DebtDAOImpl extends DBContext implements DebtDAO {

    @Override
    public void create(int debtorId, boolean isDebt, double money, String note, Date startDate, Timestamp createdAt, Timestamp updatedAt, int createdBy) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
//        PreparedStatement updateDebtorStatement = null;
        try {
            String query = "insert into [debt] (debtor_id, is_debt, money, note, start_date, created_at, updated_at, created_by)\n"
                    + "values (?, ?, ?, ?, ?, ?, ?, ?)";
            connection = getConnection();
            connection.setAutoCommit(false); // start transaction

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, debtorId);
            if (isDebt) {
                preparedStatement.setInt(2, 1);
            } else {
                preparedStatement.setInt(2, 0);
            }
            preparedStatement.setDouble(3, money);
            preparedStatement.setString(4, note);
            preparedStatement.setDate(5, startDate);
            preparedStatement.setTimestamp(6, createdAt);
            preparedStatement.setTimestamp(7, updatedAt);
            preparedStatement.setInt(8, createdBy);
            preparedStatement.executeUpdate();

//            // update debtor's total debt amount in debtor table
//            String updateDebtorQuery = "UPDATE debtor SET total_debt = total_debt ";
//            if (isDebt) {
//                updateDebtorQuery += "+ ?";
//            } else {
//                updateDebtorQuery += "- ?";
//            }
//            updateDebtorQuery += " WHERE id = ?";
//            updateDebtorStatement = connection.prepareStatement(updateDebtorQuery);
//            updateDebtorStatement.setDouble(1, money);
//            updateDebtorStatement.setInt(2, debtorId);
//            updateDebtorStatement.executeUpdate();
            connection.commit(); // commit transaction
        } catch (SQLException e) {
            connection.rollback(); // rollback transaction
            Logger.getLogger(DebtDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            // reset auto-commit and release database resources
//            closePreparedStatement(updateDebtorStatement);
            closePreparedStatement(preparedStatement);
            connection.setAutoCommit(true); // reset auto-commit mode
            closeConnection(connection);
        }
    }

    @Override
    public List<Debt> getAllDebt(String debtorID) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Debt> listDebt = new ArrayList<>();
        try {
            String query = "SELECT *\n"
                    + "FROM [debt]\n"
                    + "WHERE [debtor_id] = ?";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, debtorID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listDebt.add(new Debt(resultSet.getInt("id"),
                        resultSet.getInt("debtor_id"),
                        resultSet.getBoolean("is_debt"),
                        resultSet.getDouble("money"),
                        resultSet.getString("note"),
                        resultSet.getDate("start_date"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("updated_at"),
                        resultSet.getInt("created_by")));
            }

        } catch (SQLException e) {
            Logger.getLogger(DebtDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
            closeConnection(connection);

        }
        return listDebt;
    }

    @Override
    public List<Debt> getDebtBySearch( String note, int type, float debtFrom, float debtTo, String addFrom, String addTo, String createFrom, String createTo, int debtorId) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Debt> listDebt = new ArrayList<>();
        try {
            String query = "SELECT * from debt\n"
                    + "where debtor_id = ?\n"
                  
                    + "AND is_debt= ?\n"
                    + "AND [money] between  ? and ?\n"
                    + "AND note = ?\n"
                    + "AND [start_date] between ? and ?\n"
                    + "AND [created_at] between ? and ?";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, debtorId);
            preparedStatement.setInt(2, type);
            preparedStatement.setFloat(3, debtFrom);
            preparedStatement.setFloat(4, debtTo);
            preparedStatement.setString(5, "%" + note + "%");
            preparedStatement.setString(6, addFrom);
            preparedStatement.setString(7, addTo);
            preparedStatement.setString(8, createFrom);
            preparedStatement.setString(9, createTo);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listDebt.add(new Debt(resultSet.getInt("id"),
                        resultSet.getInt("debtor_id"),
                        resultSet.getBoolean("is_debt"),
                        resultSet.getDouble("money"),
                        resultSet.getString("note"),
                        resultSet.getDate("start_date"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("updated_at"),
                        resultSet.getInt("created_by")));
            }
        } catch (SQLException e) {
            Logger.getLogger(DebtorDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
        return listDebt;
    }

    @Override
    public Debt getDebtById(int debtId) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT *\n"
                    + "FROM [debt]\n"
                    + "WHERE [id] = ?";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, debtId);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Debt(resultSet.getInt("id"),
                        resultSet.getInt("debtor_id"),
                        resultSet.getBoolean("is_debt"),
                        resultSet.getDouble("money"),
                        resultSet.getString("note"),
                        resultSet.getDate("start_date"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("updated_at"),
                        resultSet.getInt("created_by"));

            }
        } catch (SQLException e) {
            Logger.getLogger(DebtorDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
        return null;
    }

}
