/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DebtorDAO;
import dao.impl.DebtorDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Debtor;
import model.User;

/**
 *
 * @author ngoqu
 */
public class ListDebtorController extends HttpServlet {

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
            out.println("<title>Servlet ListDebtorController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListDebtorController at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            out.print("You must login first");
        } else {
            try {
                User currentUser = (User) session.getAttribute("user");
                String pageRaw = request.getParameter("page") == null ? "1" : request.getParameter("page");
                DebtorDAO debtorDAO = new DebtorDAOImpl();
                int totalDebtor = debtorDAO.getAmountOfDebtor(currentUser.getId());
                int page = Integer.parseInt(pageRaw);
                String listDebtorJson = "[";
                List<Debtor> listAllDebtor = debtorDAO.getLimitDebtorByUserId(currentUser.getId(), page);
                for (Debtor debtor : listAllDebtor) {
                    listDebtorJson += debtor + ", ";
                }
                listDebtorJson += " " + totalDebtor + "]";
                out.println(listDebtorJson);
            } catch (Exception e) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, e);
                request.setAttribute("error", e);
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
