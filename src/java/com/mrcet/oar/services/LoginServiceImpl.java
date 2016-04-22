/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrcet.oar.services;

import com.mrcet.oar.beans.User;
import com.mrcet.oar.dao.UserDAO;
import com.mrcet.oar.daoImpl.UserDaoImpl;
import java.sql.SQLException;

/**
 *
 * @author techm
 */
public class LoginServiceImpl implements LoginService{

    public String validateUser(User user) throws SQLException,ClassNotFoundException{
        UserDAO userDAO= new UserDaoImpl();
        return userDAO.validateUser(user);
    }

    public boolean registrationStatus(User user) throws SQLException, ClassNotFoundException {
        UserDAO userDAO= new UserDaoImpl();
        return userDAO.registrationStatus(user);
    }

    
}

