/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrcet.oar.controllers;

import com.mrcet.oar.beans.Flight;
import com.mrcet.oar.beans.Transaction;
import com.mrcet.oar.services.TransactionService;
import com.mrcet.oar.services.TransactionServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class ConfirmTicketServlet extends HttpServlet {

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
        HttpSession httpSession = request.getSession(false);
        if(httpSession == null) { response.sendRedirect("./login.html"); }
        String email = (String)httpSession.getAttribute("username");
        Flight flight = (Flight)httpSession.getAttribute("flight");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String bookingDate = simpleDateFormat.format(new Date());
        String dateOfJourney = request.getParameter("dateofjourney");
        if(dateOfJourney.length() < 1) dateOfJourney = bookingDate;
        double fare = flight.getFare() + flight.getFare()*0.125;
        Transaction transaction = new Transaction();
        transaction.setEmail(email);
        transaction.setFlightId(flight.getFlightID());
        transaction.setJourneyDate(dateOfJourney);
        transaction.setBookingDate(bookingDate);
        transaction.setFare(fare);
        transaction.setStatusApproval("N");
        TransactionService transactionService = new TransactionServiceImpl();
        try {
            transactionService.bookDetails(transaction);
        } catch (SQLException ex) {
            Logger.getLogger(ConfirmTicketServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConfirmTicketServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("./account");
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
