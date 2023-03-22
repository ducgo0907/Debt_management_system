/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
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
import utils.EmailSender;
import utils.MD5Hashing;

/**
 *
 * @author bang
 */
public class ResetPasswordController extends HttpServlet {

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
            out.println("<title>Servlet ResetPasswordController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ResetPasswordController at " + request.getContextPath() + "</h1>");
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
        String token = request.getParameter("token");
        HttpSession session = request.getSession();
        String resetToken = (String) session.getAttribute("resetToken");
        String resetEmail = (String) session.getAttribute("resetEmail");

        String password = request.getParameter("password").trim();
        String rePassword = request.getParameter("rePassword").trim();

        UserDAO userDAO = new UserDAOImpl();
        if (resetToken == null || resetEmail == null) {   
            request.setAttribute("errorMessage", "Bạn đã thực hiện thay đổi mật khẩu hoặc link thay đổi không còn hợp lệ!\nXin vui lòng thử lại!");
            request.getRequestDispatcher("forgot-password.jsp").forward(request, response);
        } else if (!resetToken.equals(token)) {
            request.setAttribute("errorMessage", "Link reset không hợp lệ.");
            request.getRequestDispatcher("forgot-password.jsp").forward(request, response);
        } else if (password.isEmpty() || rePassword.isEmpty()) {
            request.setAttribute("message", "Các trường thông tin k được để trống");
            request.getRequestDispatcher("reset-password.jsp?token=" + token).forward(request, response);
        } else if (password.length() < 6 || password.length() > 55) {
            request.setAttribute("message", "Mật khẩu phải chứa ít nhất 6 kí tự và không vượt quá 55 kí tự!");
            request.getRequestDispatcher("reset-password.jsp?token=" + token).forward(request, response);
        } else if (!password.equals(rePassword)) {
            request.setAttribute("message", "Mật khẩu không giống nhau.");
            request.getRequestDispatcher("reset-password.jsp?token=" + token).forward(request, response);
        } else {
            try {
                // Update the password in the database
                String passwordMD5 = MD5Hashing.getMD5(password);
                userDAO.resetPassword(resetEmail, passwordMD5);
                request.setAttribute("successMessage", "Mật khẩu của bạn đã được thay đổi thành công.");
                // Send the activation success email
                String subject = "Mật khẩu của bạn đã được thay đổi";
                String body = "Mật khẩu của tài khoản " + resetEmail + " vừa được thay đổi. \n"
                        + "Nếu bạn không phải người thực hiện, hãy vào phần quên mật khẩu để đổi lại mật khẩu hoặc báo với chúng tôi tại địa chỉ nguyenht65.temp@gmail.com\n\n"
                        + "Best regards,\n"
                        + "Debt Management System";
                EmailSender sender = new EmailSender();
                new Thread(() -> {
                    try {
                        sender.sendEmail(resetEmail, subject, body);
                        // remove attribute of token and email
                        session.removeAttribute("resetToken");
                        session.removeAttribute("resetEmail");
                    } catch (Exception ex) {
                        Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }).start();

                request.getRequestDispatcher("login.jsp").forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(ResetPasswordController.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("error", ex);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
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
