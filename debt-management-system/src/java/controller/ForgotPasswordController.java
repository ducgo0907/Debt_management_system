/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import utils.EmailSender;
import utils.Helper;
import utils.MD5Hashing;

/**
 *
 * @author bang
 */
public class ForgotPasswordController extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ForgotPasswordController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ForgotPasswordController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        processRequest(request, response);
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
        String email = request.getParameter("email").trim();
        UserDAO userDAO = new UserDAOImpl();
        HttpSession session = request.getSession();

        try {
            if (userDAO.isEmailExisted(email)) {
                User user = userDAO.getProfileByEmail(email);
                boolean isActiveUser = user.isIsActive();
                if (isActiveUser) {
                    // Generate a secure random token for resetting the password
                    SecureRandom random = new SecureRandom();
                    byte[] bytes = new byte[20];
                    random.nextBytes(bytes);
                    String token = Base64.getUrlEncoder().encodeToString(bytes);
                    // Save the token in a session variable for later use
                    session.setAttribute("resetToken", token);
                    session.setAttribute("resetEmail", email);
                    // reset password
                    String newPassword = Helper.generateRandomPassword(12);
                    String newPasswordMD5 = MD5Hashing.getMD5(newPassword);
                    userDAO.resetPassword(email, newPasswordMD5);
                    // Send an email to reset password
                    String subject = "Mật khẩu của bạn đã được reset";
                    String body = "Xin chào,\n\n"
                            + "Bạn đã reset mật khẩu tại hệ thống Debt Management System thành công.\n\n"
                            + "Mật khẩu của bạn là: " + newPassword + "\n\n"
                            + "Bạn có thể sử dụng mật khẩu trên để đăng nhập hoặc nhấn vào link dưới đây để thay đổi mật khẩu cho tài khoản của bạn:\n\n"
                            + request.getRequestURL().toString().replace("forgot-password", "reset-password.jsp?token=" + token)
                            + "\n\nBest regards,\n"
                            + "Debt Management System";
                    EmailSender sender = new EmailSender();
                    new Thread(() -> {
                        try {
                            sender.sendEmail(email, subject, body);
                        } catch (Exception ex) {
                            Logger.getLogger(ForgotPasswordController.class.getName()).log(Level.SEVERE, null, ex);
                            request.setAttribute("error", ex);
                        }
                    }).start();
                    // Show a success message to the user
                    request.setAttribute("successMessage", "Link reset mật khẩu đã được gửi vào email của bạn.");
                    request.getRequestDispatcher("forgot-password.jsp").forward(request, response);
                } else {
                    request.setAttribute("errorMessage", "Bạn cần kích hoạt tài khoản trước khi thực hiện chức năng này!");
                    request.getRequestDispatcher("forgot-password.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("errorMessage", "Email chưa được đăng ký trong hệ thống!");
                request.getRequestDispatcher("forgot-password.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(ForgotPasswordController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("error", ex);
            request.getRequestDispatcher("error.jsp").forward(request, response);
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
