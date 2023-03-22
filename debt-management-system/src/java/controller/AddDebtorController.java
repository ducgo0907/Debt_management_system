/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DebtorDAO;
import dao.impl.DebtorDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author ngoqu
 */
public class AddDebtorController extends HttpServlet {

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
            out.println("<title>Servlet AddDebtorController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddDebtorController at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            try {
                String fullName = request.getParameter("fullName").trim();
                String address = request.getParameter("address").trim();
                String phone = request.getParameter("phone").trim();
                String email = request.getParameter("email").trim();
                int genderId = Integer.parseInt(request.getParameter("gender"));

                Timestamp currentDateTime = Timestamp.valueOf(LocalDateTime.now());

                DebtorDAO debtorDAO = new DebtorDAOImpl();

                User currentUser = (User) session.getAttribute("user");

                debtorDAO.add(fullName, address, phone, email, genderId,
                        currentUser.getId(), 0, currentDateTime, currentDateTime);

                response.sendRedirect("home");

            } catch (ParseException exception) {
                Logger.getLogger(AddDebtorController.class.getName()).log(Level.SEVERE, null, exception);
                request.setAttribute("error", exception);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(AddDebtorController.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("error", ex);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
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
