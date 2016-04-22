/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrcet.oar.services;

import com.mrcet.oar.beans.UserDetails;
import com.mrcet.oar.dao.UserDAO;
import com.mrcet.oar.dao.UserDetailsDAO;
import com.mrcet.oar.daoImpl.UserDetailsDaoImpl;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author techm
 */
public class AccountServiceImpl implements AccountService{

    public List<UserDetails> getAllUsers() throws SQLException, ClassNotFoundException {
        UserDetailsDAO userDetailsDAO= new UserDetailsDaoImpl();
        return userDetailsDAO.getAllUsers();
    }

    public void approveUser(String registrationID) throws SQLException, ClassNotFoundException {
        UserDetailsDAO userDetailsDAO= new UserDetailsDaoImpl();
        userDetailsDAO.approveUser(registrationID);
    }
    
}
