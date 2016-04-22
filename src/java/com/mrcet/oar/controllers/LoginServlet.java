/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrcet.oar.controllers;

import com.mrcet.oar.beans.User;
import com.mrcet.oar.services.LoginService;
import com.mrcet.oar.services.LoginServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author techm
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = null;
        HttpSession httpSession = null;
            String userName=request.getParameter("username");
            String pwd=request.getParameter("password");
            User user=new User();
            user.setEmail(userName);
            user.setPassword(pwd);
            LoginService loginservice= new LoginServiceImpl();
            String role = null;
        try {
            role = loginservice.validateUser(user);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            System.out.println(role);
            if(role.equals("admin")){
                httpSession = request.getSession();
                httpSession.setAttribute("username",user.getEmail());
                httpSession.setAttribute("role", role);
                response.sendRedirect("./adminaccount");
            }
            else if(role.equals("traveller")){
                boolean status = false;
                    try {
                        status = loginservice.registrationStatus(user);
                    } catch (SQLException ex) {
                        Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                httpSession = request.getSession();
                httpSession.setAttribute("username",user.getEmail());
                httpSession.setAttribute("role", role);
                if(status == true){
                rd = request.getRequestDispatcher("./account");
                rd.forward(request, response);
                }
                else{
                    response.sendRedirect("./registrationincomplete.jsp");
                }
            }
            else if(role.equals("invalid")){
                response.sendRedirect("./registration.jsp");
            }
            else if(role.equals("dberror")){
                response.sendRedirect("./error.html");
                //rd.forward or include
            }
          
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
