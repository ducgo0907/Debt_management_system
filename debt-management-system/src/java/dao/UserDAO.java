/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Timestamp;
import model.User;

/**
 *
 * @author bang
 */
public interface UserDAO {

    public User login(String email, String password) throws Exception;

    public void saveAccount(String email, String password, String fullName,
            int genderId, Timestamp createdAt, Timestamp updatedAt, boolean isActive, String activationCode) throws Exception;

    public boolean activateUser(String activationCode) throws Exception;

    public boolean isEmailExisted(String email) throws Exception;

    public User getProfile(int id) throws Exception;

    public void updateProfile(String fullname, String gender, String birthday,
            String phonenumber, String address, String updateat, int id) throws Exception;

    public void updatePasswordById(int id, String newPassword) throws Exception;

    public User getProfileByEmail(String email) throws Exception;

    public void resetPassword(String email, String password) throws Exception;

}
