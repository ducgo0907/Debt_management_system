/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DebtDAO;
import dao.DebtorDAO;
import dao.impl.DebtDAOImpl;
import dao.impl.DebtorDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
 * @author bang
 */
public class CreateDebtController extends HttpServlet {

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
            out.println("<title>Servlet CreateDebtController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateDebtController at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        if (session.getAttribute("user") != null) {
            try {
                int debtorId = Integer.parseInt(request.getParameter("debtor-id"));
                int isDebtValue = Integer.parseInt(request.getParameter("isDebt"));
                boolean isDebt = isDebtValue == 1;
                double money = Double.parseDouble(request.getParameter("money"));
                String note = request.getParameter("note");
                if (note != null) {
                    note = note.trim();
                }
                String sDate = request.getParameter("startDate");
                Date startDate = Date.valueOf(sDate);
                Timestamp currentDateTime = Timestamp.valueOf(LocalDateTime.now());

                User currentUser = (User) session.getAttribute("user");
                DebtorDAO debtorDAO = new DebtorDAOImpl();
                Debtor debtor = debtorDAO.getDebtorById(debtorId);

                if (debtor.getUserId() != currentUser.getId()) {
                    request.setAttribute("error", "Thêm thất bại do người nợ không được tạo bởi người dùng này");
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                } else {
                    DebtDAO debtDAO = new DebtDAOImpl();
                    debtDAO.create(debtorId, isDebt, money, note, startDate, currentDateTime, currentDateTime, currentUser.getId());
                }
                response.sendRedirect(request.getHeader("referer"));
            } catch (Exception ex) {
                Logger.getLogger(CreateDebtController.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("error", ex);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("login.jsp");
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
