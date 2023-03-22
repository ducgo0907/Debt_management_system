/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import context.DBContext;
import dao.UserDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import utils.EmailSender;

/**
 *
 * @author bang
 */
public class UserDAOImpl extends DBContext implements UserDAO {

    @Override
    public User login(String email, String password) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT *\n"
                    + "FROM [user]\n"
                    + "WHERE [email] = ? and [password] = ?";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new User(resultSet.getInt("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name"),
                        resultSet.getDate("birth_date"),
                        resultSet.getString("address"),
                        resultSet.getInt("gender_id"),
                        resultSet.getString("phone_number"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("updated_at"),
                        resultSet.getBoolean("is_active"),
                        resultSet.getString("activation_code"));
            }
        } catch (SQLException e) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
        return null;
    }

    @Override
    public void saveAccount(String email, String password, String fullName, int genderId, Timestamp createdAt, Timestamp updatedAt, boolean isActive, String activationCode) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String query = "insert into [user] (email, password, full_name, gender_id, created_at, updated_at, is_active, activation_code)\n"
                    + "values (?, ?, ?, ?, ?, ?, ?, ?)";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, fullName);
            preparedStatement.setInt(4, genderId);
            preparedStatement.setTimestamp(5, createdAt);
            preparedStatement.setTimestamp(6, updatedAt);
            if (isActive) {
                preparedStatement.setInt(7, 1);
            } else {
                preparedStatement.setInt(7, 0);
            }
            preparedStatement.setString(8, activationCode);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    @Override
    public boolean activateUser(String activationCode) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement updateStatement = null;
        PreparedStatement removeStatement = null;
        try {
            String query = "SELECT * FROM [user] WHERE activation_code = ?";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, activationCode);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Activation code is valid, activate the account
                int userId = resultSet.getInt("id");
                String email = resultSet.getString("email");

                String updateQuery = "UPDATE [user] SET is_active = 1 WHERE id = ?";
                updateStatement = connection.prepareStatement(updateQuery);
                updateStatement.setInt(1, userId);
                updateStatement.executeUpdate();

                // remove activation code
                String removeQuery = "update [user]\n"
                        + "set activation_code = null\n"
                        + "where id = ?";
                removeStatement = connection.prepareStatement(removeQuery);
                removeStatement.setInt(1, userId);
                removeStatement.executeUpdate();

                // Send the activation success email
                String subject = "Tài khoản của bạn đã được kích hoạt";
                String body = "Congratulations! Tài khoản " + email + " đã được kích hoạt.\n\n"
                        + "Best regards,\n"
                        + "Debt Management System";;
                EmailSender sender = new EmailSender();
                new Thread(() -> {
                    try {
                        sender.sendEmail(email, subject, body);
                    } catch (Exception ex) {
                        Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }).start();

                return true;

            } else {
                // Activation code is invalid
                return false;
            }

        } catch (SQLException e) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            closePreparedStatement(removeStatement);
            closePreparedStatement(updateStatement);
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    @Override
    public boolean isEmailExisted(String email) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT *\n"
                    + "FROM [user]\n"
                    + "WHERE [email] = ?";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
        return false;
    }

    @Override
    public void updateProfile(String fullname, String gender, String birthday,
            String phonenumber, String address, String updateat, int id) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String query = "update [user]\n"
                    + "set [full_name] =?,\n"
                    + "[gender_id]=?,\n"
                    + "birth_date = ?,\n"
                    + "phone_number = ?,\n"
                    + "[address] =?,\n"
                    + "[updated_at]=?\n"
                    + "where id = ?";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, fullname);
            preparedStatement.setString(2, gender);
            preparedStatement.setString(3, birthday);
            preparedStatement.setString(4, phonenumber);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, updateat);
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    @Override
    public User getProfile(int id) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT *\n"
                    + "FROM [user]\n"
                    + "WHERE [id] = ?";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new User(resultSet.getInt("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name"),
                        resultSet.getDate("birth_date"),
                        resultSet.getString("address"),
                        resultSet.getInt("gender_id"),
                        resultSet.getString("phone_number"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("updated_at"),
                        resultSet.getBoolean("is_active"),
                        resultSet.getString("activation_code"));
            }
        } catch (SQLException e) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
        return null;
    }

    public void updatePasswordById(int id, String newPassword) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String query = "update [user]\n"
                    + "set [password] =?\n"
                    + "where id = ?";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newPassword);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    public User getProfileByEmail(String email) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT *\n"
                    + "FROM [user]\n"
                    + "WHERE [email] = ?";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new User(resultSet.getInt("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name"),
                        resultSet.getDate("birth_date"),
                        resultSet.getString("address"),
                        resultSet.getInt("gender_id"),
                        resultSet.getString("phone_number"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("updated_at"),
                        resultSet.getBoolean("is_active"),
                        resultSet.getString("activation_code"));
            }
        } catch (SQLException e) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
        return null;
    }

    @Override
    public void resetPassword(String email, String newPassword) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String query = "update [user]\n"
                    + "set [password] =?\n"
                    + "where [email] = ?";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

}
