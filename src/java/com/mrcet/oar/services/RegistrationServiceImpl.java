/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrcet.oar.services;

import com.mrcet.oar.beans.User;
import com.mrcet.oar.beans.UserDetails;
import com.mrcet.oar.dao.UserDetailsDAO;
import com.mrcet.oar.daoImpl.UserDetailsDaoImpl;
import java.sql.SQLException;

/**
 *
 * @author techm
 */
public class RegistrationServiceImpl implements RegistrationService{

    public int registerUser(User user, UserDetails userdetails) throws SQLException, ClassNotFoundException {
        UserDetailsDAO userDetailsDAO= new UserDetailsDaoImpl();
        return userDetailsDAO.registerUser(user,userdetails);
    }

     
}
