/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrcet.oar.services;

import com.mrcet.oar.beans.User;
import com.mrcet.oar.beans.UserDetails;
import java.sql.SQLException;

/**
 *
 * @author techm
 */
public interface RegistrationService {
        public abstract int registerUser(User user,UserDetails userdetails) throws SQLException,ClassNotFoundException;
        
}