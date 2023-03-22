package dao.impl;

import context.DBContext;
import dao.DebtorDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Debtor;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ngoqu
 */
public class DebtorDAOImpl extends DBContext implements DebtorDAO {

    @Override
    public void add(String fullName, String address, String mobilePhone,
            String email, int genderId, int userId, float totalDebt, Timestamp createdDate, Timestamp updatedDate) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String query = "INSERT INTO [dbo].[debtor]\n"
                    + "           ([full_name]\n"
                    + "           ,[address]\n"
                    + "           ,[mobile_phone]\n"
                    + "           ,[email]\n"
                    + "           ,[gender_id]\n"
                    + "           ,[total_debt]\n"
                    + "           ,[created_at]\n"
                    + "           ,[updated_at]"
                    + "           ,[user_id])\n"
                    + "     VALUES\n"
                    + "           (?, ?, ? ,? ,? ,? ,? ,?, ?)";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, mobilePhone);
            preparedStatement.setString(4, email);
            preparedStatement.setInt(5, genderId);
            preparedStatement.setFloat(6, totalDebt);
            preparedStatement.setTimestamp(7, createdDate);
            preparedStatement.setTimestamp(8, updatedDate);
            preparedStatement.setInt(9, userId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(DebtorDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }

    }

    @Override
    public List<Debtor> getAllDebtorByUserId(int userId) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Debtor> listDebtor = new ArrayList<>();
        try {
            String query = "SELECT *\n"
                    + "FROM [debtor]\n"
                    + "WHERE [user_id] = ?";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listDebtor.add(new Debtor(resultSet.getInt("id"),
                        resultSet.getString("full_name"),
                        resultSet.getString("address"),
                        resultSet.getString("mobile_phone"),
                        resultSet.getString("email"),
                        resultSet.getInt("gender_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getFloat("total_debt"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("updated_at")));
            }
        } catch (SQLException e) {
            Logger.getLogger(DebtorDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
        return listDebtor;
    }

    @Override
    public List<Debtor> getLimitDebtorByUserId(int userId, int page) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Debtor> listDebtor = new ArrayList<>();
        try {
            String query = "SELECT * FROM Debtor \n"
                    + "WHERE user_id = ? \n"
                    + "ORDER BY id OFFSET ? \n"
                    + "ROWS FETCH NEXT ? ROWS ONLY;";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, (page - 1) * 5);
            preparedStatement.setInt(3, 5);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listDebtor.add(new Debtor(resultSet.getInt("id"),
                        resultSet.getString("full_name"),
                        resultSet.getString("address"),
                        resultSet.getString("mobile_phone"),
                        resultSet.getString("email"),
                        resultSet.getInt("gender_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getFloat("total_debt"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("updated_at")));
            }
        } catch (SQLException e) {
            Logger.getLogger(DebtorDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
        return listDebtor;
    }

    @Override
    public List<Debtor> getDebtorBySearch(String fullName, String address,
            String mobilePhone, String email, int genderId,
            float debtFrom, float debtTo, int userId, int page) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Debtor> listDebtor = new ArrayList<>();
        try {
            String query = "SELECT *\n"
                    + "FROM [debtor]\n"
                    + "WHERE user_id = ? AND full_name like ?"
                    + " AND address like ? AND mobile_phone like ?"
                    + " AND email like ? AND gender_id like ? AND total_debt between ? and ?"
                    + " ORDER BY id OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY;";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, "%" + fullName + "%");
            preparedStatement.setString(3, "%" + address + "%");
            preparedStatement.setString(4, "%" + mobilePhone + "%");
            preparedStatement.setString(5, "%" + email + "%");
            if (genderId == -1) {
                preparedStatement.setString(6, "%%");
            } else {
                preparedStatement.setString(6, "%" + genderId + "%");
            }
            preparedStatement.setFloat(7, debtFrom);
            preparedStatement.setFloat(8, debtTo);
            preparedStatement.setInt(9, (page - 1) * 5);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listDebtor.add(new Debtor(resultSet.getInt("id"),
                        resultSet.getString("full_name"),
                        resultSet.getString("address"),
                        resultSet.getString("mobile_phone"),
                        resultSet.getString("email"),
                        resultSet.getInt("gender_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getFloat("total_debt"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("updated_at")));
            }
        } catch (SQLException e) {
            Logger.getLogger(DebtorDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
        return listDebtor;
    }

    @Override
    public Debtor getDebtorById(int debtorId) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT *\n"
                    + "FROM [debtor]\n"
                    + "WHERE [id] = ?";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, debtorId);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Debtor(resultSet.getInt("id"),
                        resultSet.getString("full_name"),
                        resultSet.getString("address"),
                        resultSet.getString("mobile_phone"),
                        resultSet.getString("email"),
                        resultSet.getInt("gender_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getFloat("total_debt"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("updated_at"));
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

    @Override
    public void updateTotalDebtOfDebtor(double money, Timestamp updatedAt, int debtorId) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String query = "update [debtor]\n"
                    + "set [total_debt] = ?, [updated_at] = ?\n"
                    + "where id = ?";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, money);
            preparedStatement.setTimestamp(2, updatedAt);
            preparedStatement.setInt(3, debtorId);

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(DebtorDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    @Override
    public void updateDebtor(String fullName, String address, String phone, String email, int id) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String query = "update [debtor] set full_name = ?, address = ?, mobile_phone = ?, email = ? where id = ?";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            connection = getConnection();
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, email);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(DebtorDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    @Override
    public int getAmountOfDebtor(int userId) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT COUNT(*) as amount FROM Debtor where user_id = ?;";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("amount");
            }
        } catch (SQLException e) {
            Logger.getLogger(DebtorDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
        return 0;
    }

    @Override
    public int getAmountOfDebtorBySearch(
            int userId,
            String fullName,
            String address,
            String mobilePhone,
            String email,
            int genderId,
            float debtFrom,
            float debtTo) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT COUNT(*) as amount\n"
                    + "FROM [debtor]\n"
                    + "WHERE user_id = ? AND full_name like ?"
                    + " AND address like ? AND mobile_phone like ?"
                    + " AND email like ? AND gender_id like ? AND total_debt between ? and ?";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, "%" + fullName + "%");
            preparedStatement.setString(3, "%" + address + "%");
            preparedStatement.setString(4, "%" + mobilePhone + "%");
            preparedStatement.setString(5, "%" + email + "%");
            if (genderId == -1) {
                preparedStatement.setString(6, "%%");
            } else {
                preparedStatement.setString(6, "%" + genderId + "%");
            }
            preparedStatement.setFloat(7, debtFrom);
            preparedStatement.setFloat(8, debtTo);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("amount");
            }
        } catch (SQLException e) {
            Logger.getLogger(DebtorDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
        return 0;
    }

}
