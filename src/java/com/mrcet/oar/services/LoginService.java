/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrcet.oar.services;

import com.mrcet.oar.beans.User;
import java.sql.SQLException;

/**
 *
 * @author techm
 */
public interface LoginService {
        public abstract String validateUser(User user)throws SQLException,ClassNotFoundException;
        public abstract boolean registrationStatus(User user) throws SQLException,ClassNotFoundException;
        
}