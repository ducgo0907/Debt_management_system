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
public class SearchDebtorController extends HttpServlet {

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
            out.println("<title>Servlet SearchDebtorController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchDebtorController at " + request.getContextPath() + "</h1>");
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
        if (session.getAttribute("user") != null) {
            try {
                String fullName = request.getParameter("searchName");
                String address = request.getParameter("searchAddress");
                String mobilePhone = request.getParameter("searchPhone");
                String email = request.getParameter("searchEmail");
                String genderIdText = request.getParameter("searchGender");
                String debtFromText = !request.getParameter("debtFrom").isEmpty() ? request.getParameter("debtFrom") : Long.toString(Long.MIN_VALUE);
                String debtToText = !request.getParameter("debtTo").isEmpty() ? request.getParameter("debtTo") : Long.toString(Long.MAX_VALUE);
                String pageRaw = request.getParameter("page") == null ? "1" : request.getParameter("page");
                String listDebtorJson = "[";

                float debtFrom = Float.parseFloat(debtFromText);
                float debtTo = Float.parseFloat(debtToText);
                int genderId = Integer.parseInt(genderIdText);

                User currentUser = (User) session.getAttribute("user");
                DebtorDAO debtorDAO = new DebtorDAOImpl();
                int page = Integer.parseInt(pageRaw);
                int totalDebtor = debtorDAO.getAmountOfDebtorBySearch(
                        currentUser.getId(), fullName, address, mobilePhone,
                        email, genderId, debtFrom, debtTo);
                List<Debtor> listDebtor = debtorDAO.getDebtorBySearch(fullName,
                        address, mobilePhone, email, genderId, debtFrom, debtTo,
                        currentUser.getId(), page);
                for (Debtor debtor : listDebtor) {
                    listDebtorJson += debtor + ", ";
                }
                listDebtorJson += +totalDebtor + " ]";
                out.println(listDebtorJson);
            } catch (Exception exception) {
                Logger.getLogger(SearchDebtorController.class.getName()).log(Level.SEVERE, null, exception);
                request.setAttribute("error", exception);
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
