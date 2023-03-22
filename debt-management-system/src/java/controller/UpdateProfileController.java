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
import java.time.LocalDateTime;

/**
 *
 * @author kaiok
 */
public class UpdateProfileController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet test</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet test at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String fullName = request.getParameter("fullname").trim();
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String phoneNumber = request.getParameter("phonenumber").trim();
        String address = request.getParameter("address").trim();
        String updatedAt = LocalDateTime.now().toString();
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("user");

        int id = currentUser.getId();
        UserDAO userDAO = new UserDAOImpl();
        if (fullName.isEmpty()) {
            request.setAttribute("msg", "Họ và tên không được để trống");
            request.getRequestDispatcher("viewprofile").forward(request, response);
        } else if (fullName.length() <= 2 || fullName.length() >= 50) {
            request.setAttribute("msg", "Họ và tên phải từ 2 đến 50 ký tự");
            request.getRequestDispatcher("viewprofile").forward(request, response);
        } else if (phoneNumber.length() <= 9 || phoneNumber.length() >= 12) {
            request.setAttribute("msg", "Số điện thoại phải từ 9 đến 12 ký tự");
            request.getRequestDispatcher("viewprofile").forward(request, response);
        } else if (address.length() <= 2 || address.length() >= 50) {
            request.setAttribute("msg", "Địa chỉ phải từ 2 đến 50 ký tự");
            request.getRequestDispatcher("viewprofile").forward(request, response);

        } else {
            try {
                userDAO.updateProfile(fullName, gender, birthday, phoneNumber, address, updatedAt, id);
                request.setAttribute("response", "Cập nhật thông tin thành công");
                request.getRequestDispatcher("viewprofile").forward(request, response);

                response.sendRedirect("viewprofile");
            } catch (Exception ex) {
                Logger.getLogger(UpdateProfileController.class.getName()).log(Level.SEVERE, null, ex);
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
