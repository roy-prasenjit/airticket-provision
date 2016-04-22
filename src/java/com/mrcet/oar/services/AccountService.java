/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrcet.oar.services;

import com.mrcet.oar.beans.UserDetails;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author techm
 */
public interface AccountService {
    public abstract List<UserDetails> getAllUsers() throws SQLException,ClassNotFoundException;
    public abstract void approveUser(String registrationID) throws SQLException,ClassNotFoundException;;
}
