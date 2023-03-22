/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DebtDAO;
import dao.impl.DebtDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Debt;
import model.User;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kaiok
 */
public class SearchDebtController extends HttpServlet {

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
            out.println("<title>Servlet SearchDebtController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchDebtController at " + request.getContextPath() + "</h1>");
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
                String did = request.getParameter ("did");
                String searchStt = request.getParameter("searchStt");
                String searchNote = request.getParameter("searchNote");
                String searchType = request.getParameter("searchType");
                String debtFromText = !request.getParameter("debtFrom").isEmpty() ? request.getParameter("debtFrom") : Long.toString(Long.MIN_VALUE);
                String debtToText = !request.getParameter("debtTo").isEmpty() ? request.getParameter("debtTo") : Long.toString(Long.MAX_VALUE);
               String addFromText = request.getParameter("addFrom");
                String addToText = request.getParameter("addTo");
                String createFromText = request.getParameter("createFrom");
                String createToText = request.getParameter("createTo");
                String listDebtJson = "[";

                float debtFrom = Float.parseFloat(debtFromText);
                float debtTo = Float.parseFloat(debtToText);
                int searchTypeId = Integer.parseInt(searchType);
                int debtorId = Integer.parseInt(did);

                DebtDAO debtDAO = new DebtDAOImpl();
             
                List<Debt> listDebt = debtDAO.getDebtBySearch(searchNote,searchTypeId,
                         debtFrom, debtTo,addFromText,addToText,createFromText,createToText,
                        debtorId);
                for (Debt debt : listDebt) {
                    listDebtJson += debt + ", ";
                }
              
                out.println(listDebtJson);
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
