/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrcet.oar.dao;

import com.mrcet.oar.beans.User;
import com.mrcet.oar.beans.UserDetails;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author techm
 */
public abstract interface UserDetailsDAO {
     public abstract int registerUser(User user,UserDetails userDetails) throws SQLException,ClassNotFoundException; 
     public abstract List<UserDetails> getAllUsers() throws SQLException,ClassNotFoundException;
    public abstract void approveUser(String registrationID) throws SQLException,ClassNotFoundException;;
     
}
