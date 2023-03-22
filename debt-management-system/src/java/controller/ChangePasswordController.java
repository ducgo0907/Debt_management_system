/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import utils.MD5Hashing;

/**
 *
 * @author ADMIN
 */
public class ChangePasswordController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HttpSession session = request.getSession();
            UserDAO userDAO = new UserDAOImpl();
            User currentUser = (User) session.getAttribute("user");
            int id = currentUser.getId();
            User getInfor = userDAO.getProfile(id);
            request.setAttribute("infor", getInfor);
            request.getRequestDispatcher("change-password.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ChangePasswordController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //get parameter
        String oldPassword = request.getParameter("oldPassword").toString().trim();
        String newPassword = request.getParameter("newPassword").toString().trim();
        String confirmPassword = request.getParameter("confirmPassword").toString().trim();
        UserDAO uD = new UserDAOImpl();
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            User userFromDB = uD.getProfile(user.getId());

            String oldPasswordInMD5 = MD5Hashing.getMD5(oldPassword);
            UserDAO userDAO = new UserDAOImpl();
            User getInfor = userDAO.getProfile(user.getId());
            request.setAttribute("infor", getInfor);

            if (!oldPasswordInMD5.equals(userFromDB.getPassword())) {
                //tra ve loi neu mat khau cung cap khong dung voi mat khau trong DB
                request.setAttribute("errorMessage", "Mật khẩu hiện tại không đúng.");
                request.getRequestDispatcher("change-password.jsp").forward(request, response);
                return;
            }

            if (newPassword.length() < 6 || newPassword.length() > 55) {
                request.setAttribute("errorMessage", "Mật khẩu phải chứa ít nhất 6 kí tự và nhiều nhất 55 kí tự.");
                request.getRequestDispatcher("change-password.jsp").forward(request, response);
                return;
            }

            // kiem tra mk moi va xac nhan mk moi co trung nhau ko
            if (!newPassword.equals(confirmPassword)) {
                request.setAttribute("errorMessage", "Mật khẩu xác nhận không khớp.");
                request.getRequestDispatcher("change-password.jsp").forward(request, response);
                return;
            }

            // convert new password to MD5
            String hashedNewPassword = MD5Hashing.getMD5(newPassword);

            //cap nhat lai mat khau moi vao DB
            uD.updatePasswordById(userFromDB.getId(), hashedNewPassword);
            //them doan update mk moi vao DB

            // delete reset password session
            if (session.getAttribute("resetToken") != null || session.getAttribute("resetEmail") != null) {
                session.removeAttribute("resetToken");
                session.removeAttribute("resetEmail");
            }

            request.setAttribute("successMessage", "Đổi mật khẩu thành công.");
            request.getRequestDispatcher("change-password.jsp").forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(ChangePasswordController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
