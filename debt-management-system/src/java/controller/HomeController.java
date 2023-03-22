/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DebtorDAO;
import dao.UserDAO;
import dao.impl.DebtorDAOImpl;
import dao.impl.UserDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Debtor;
import model.User;

/**
 *
 * @author bang
 */
public class HomeController extends HttpServlet {

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
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
        } else {
            try {
                String pageRaw = request.getParameter("page") == null ? "1" : request.getParameter("page");

                User currentUser = (User) session.getAttribute("user");
                DebtorDAO debtorDAO = new DebtorDAOImpl();
                UserDAO userDAO = new UserDAOImpl();
                int id = currentUser.getId();

                int page = 1;
                try {
                    page = Integer.parseInt(pageRaw);
                } catch (NumberFormatException e) {
                    Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, e);
                    request.setAttribute("error", e);
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                User getInfor = userDAO.getProfile(id);

                List<Debtor> listDebtor = debtorDAO.getLimitDebtorByUserId(currentUser.getId(), page);

                request.setAttribute("infor", getInfor);
                request.setAttribute("listDebtor", listDebtor);
                request.getRequestDispatcher("home.jsp").forward(request, response);
            } catch (Exception e) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, e);
                request.setAttribute("error", e);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
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
        processRequest(request, response);
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
