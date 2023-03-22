/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.captcha.botdetect.web.servlet.Captcha;
import dao.UserDAO;
import dao.impl.UserDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import utils.MD5Hashing;

/**
 *
 * @author bang
 */
public class LoginController extends HttpServlet {

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
        // get email and password
        try {
            HttpSession session = request.getSession();
            boolean isCaptchaSolved = (session.getAttribute("isCaptchaSolved") != null);

            // CAPTCHA user input validation
            if (!isCaptchaSolved) {
                Captcha captcha = Captcha.load(request, "loginCaptcha");
                // validate the Captcha to check we're not dealing with a bot
                boolean isHuman = captcha.validate(request.getParameter("captchaCode"));
                if (!isHuman) {
                    // Captcha validation failed, show error message
                    request.setAttribute("errorMessage", "Captcha không hợp lệ!");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } else {
                    isCaptchaSolved = true;
                    session.setAttribute("isCaptchaSolved", true);
                }
            }
            // Captcha validation passed, only now do we perform the protected action 
            // (try to authenticate the user)
            if (isCaptchaSolved) {
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String passwordMD5 = MD5Hashing.getMD5(password);
                String remember = request.getParameter("remember");

                UserDAO userDAO = new UserDAOImpl();
                User user = userDAO.login(email, passwordMD5);
                if (user == null) {
                    //login false
                    request.setAttribute("errorMessage", "Email hoặc Mật khẩu không hợp lệ");
                    session.removeAttribute("isCaptchaSolved");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } else {
                    if (!user.isIsActive()) {
                        // user is not active
                        request.setAttribute("errorMessage", "Tài khoản hiện chưa/không được kích hoạt");
                        session.removeAttribute("isCaptchaSolved");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    } else {
                        // user is active                 
                        Cookie cEmail = new Cookie("email", email);
                        Cookie cPassword = new Cookie("password", password);
                        Cookie cRemember = new Cookie("remember", remember);

                        session.setAttribute("user", user);
                        //set maxTime exist for 3 cookies
                        if (remember != null) {
                            //setmaxage count uses seconds
                            cEmail.setMaxAge(60 * 60 * 24);
                            cPassword.setMaxAge(60 * 60 * 24);
                            cRemember.setMaxAge(60 * 60 * 24);
                        } else {
                            //setmaxage = 0 -> delete cookie
                            cEmail.setMaxAge(0);
                            cPassword.setMaxAge(0);
                            cRemember.setMaxAge(0);
                        }
                        // save cookies to user
                        response.addCookie(cEmail);
                        response.addCookie(cPassword);
                        response.addCookie(cRemember);
                        session.removeAttribute("isCaptchaSolved");
                        response.sendRedirect("home");
                    }

                }
            }
        } catch (Exception exception) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, exception);
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
