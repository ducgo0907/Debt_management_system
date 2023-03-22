/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.EmailSender;
import utils.MD5Hashing;

/**
 *
 * @author bang
 */
public class RegisterController extends HttpServlet {

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
            out.println("<title>Servlet RegisterController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterController at " + request.getContextPath() + "</h1>");
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
        try {
            request.setCharacterEncoding("UTF-8");
            String fullName = request.getParameter("name").trim();
            String email = request.getParameter("email").trim();
            String password = request.getParameter("password").trim();
            String rePassword = request.getParameter("rePassword").trim();
            String activationCode = UUID.randomUUID().toString();
            if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || rePassword.isEmpty()) {
                request.setAttribute("message", "Vui lòng nhập đủ các thông tin!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } else if (fullName.length() < 2 || fullName.length() > 100) {
                request.setAttribute("message", "Họ tên phải chứa ít nhất 2 kí tự và không vượt quá 100 kí tự!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } else if (password.length() < 6 || password.length() > 55) {
                request.setAttribute("message", "Mật khẩu phải chứa ít nhất 6 kí tự và không vượt quá 55 kí tự!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } else if (!password.equals(rePassword)) {
                request.setAttribute("message", "Mật khẩu nhập lại không khớp!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } else {
                UserDAO userDAO = new UserDAOImpl();
                if (userDAO.isEmailExisted(email)) {
                    request.setAttribute("message", "Email đã tồn tại!");
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                } else {
                    // get current date
                    Timestamp currentDateTime = Timestamp.valueOf(LocalDateTime.now());
                    // convert password to MD5
                    String passwordMD5 = MD5Hashing.getMD5(password);
                    // saveAccount
                    userDAO.saveAccount(email, passwordMD5, fullName, 3, currentDateTime, currentDateTime, false, activationCode);

                    // Send an email to activate the account
                    String subject = "Kích Hoạt Tài Khoản";
                    String body = "Xin chào,\n\n"
                            + "Cảm ơn bạn vì đã đăng ký tài khoản Debt Management System. "
                            + "Hãy nhấn vào link dưới đây để kích hoạt tài khoản của bạn:\n\n"
                            + request.getRequestURL().toString().replace("register", "activate")
                            + "?email=" + email + "&code=" + activationCode + "\n\n"
                            + "Nếu bạn không muốn kích hoạt tài khoản, vui lòng bỏ qua email này.\n\n"
                            + "Best regards,\n"
                            + "Debt Management System";
                    EmailSender sender = new EmailSender();
                    new Thread(() -> {
                        try {
                            sender.sendEmail(email, subject, body);
                        } catch (Exception ex) {
                            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
                            request.setAttribute("error", ex);
                        }
                    }).start();
                    // redirect to check-email.jsp
                    response.sendRedirect("check-email.jsp");
                }
            }
        } catch (Exception exception) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, exception);
            request.setAttribute("error", exception);
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
