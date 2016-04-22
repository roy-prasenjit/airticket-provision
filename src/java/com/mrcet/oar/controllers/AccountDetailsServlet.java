/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrcet.oar.controllers;

import com.mrcet.oar.beans.User;
import com.mrcet.oar.services.FlightService;
import com.mrcet.oar.services.FlightServiceImpl;
import com.mrcet.oar.services.TransactionService;
import com.mrcet.oar.services.TransactionServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author techm
 */
public class AccountDetailsServlet extends HttpServlet {

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
        HttpSession httpSession = request.getSession(false);
        User user = new User();
        String username = (String)httpSession.getAttribute("username");
        user.setEmail(username);
        FlightService flightService = new FlightServiceImpl();
        TransactionService transactionService = new TransactionServiceImpl();
        List flightsList = null;
        List ticketList = null;
        try {
            flightsList = flightService.getAllFlights();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ticketList = transactionService.getAllTickets(user);
        } catch (SQLException ex) {
            Logger.getLogger(AccountDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        httpSession.setAttribute("tickets",ticketList);
        httpSession.setAttribute("flights",flightsList);
        response.sendRedirect("./useraccount.jsp");
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
