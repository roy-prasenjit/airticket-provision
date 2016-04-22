/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrcet.oar.controllers;

import com.mrcet.oar.beans.User;
import com.mrcet.oar.beans.UserDetails;
import com.mrcet.oar.services.LoginService;
import com.mrcet.oar.services.LoginServiceImpl;
import com.mrcet.oar.services.RegistrationService;
import com.mrcet.oar.services.RegistrationServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author techm
 */
public class RegistrationServlet extends HttpServlet {

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
        RequestDispatcher rd = null;
         
            String email=request.getParameter("username");
            String pwd=request.getParameter("password");
            String fname=request.getParameter("name");
            String lname=request.getParameter("lname");
            String gender=request.getParameter("gender");
            if(gender.equals("Male")) {
                    gender = "M";
                }
            else {
                    gender = "F";
                }
            String dob=request.getParameter("dateOfBirth");
            String panNum=request.getParameter("panNo");
            String bankAccNo=request.getParameter("bankAccountNo");
            String bName=request.getParameter("bankName");
            String addr=request.getParameter("bankbranch");
            String privilegeNo=request.getParameter("bankPrivilegeCustomerNumber");
            String contactNo1=request.getParameter("mobileNo");
            String contactNo2=request.getParameter("mobileNo2");
            
            User user=new User();
            user.setEmail(email);
            user.setPassword(pwd);
            user.setRole("traveller");
            UserDetails userdetails=new UserDetails();
            
            userdetails.setEmailId(email);
            userdetails.setFirstName(fname);
            userdetails.setLastName(lname);
            userdetails.setDateOfBirth(dob);
            userdetails.setGender(gender);
            userdetails.setPanNo(panNum);
            userdetails.setAccountNumber(bankAccNo);
            userdetails.setBankName(bName);
            userdetails.setBranchName(addr);
            userdetails.setContact1(contactNo1);
            userdetails.setContact2(contactNo2);
            userdetails.setCustomerCertificateNumber(privilegeNo);
            userdetails.setStatusApproval("N");
            RegistrationService registrationService  = new RegistrationServiceImpl() ;
            int check = -1;
        try {
            check = registrationService.registerUser(user, userdetails);
        } catch (SQLException ex) {
            check=-1;
        } catch (ClassNotFoundException ex) {
            check=-1;
        }
        if(check == 1) response.sendRedirect("./registrationincomplete.jsp");
        else if(check == -1) response.sendRedirect("./error.html");
        else response.sendRedirect("./registration.jsp");
            
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
