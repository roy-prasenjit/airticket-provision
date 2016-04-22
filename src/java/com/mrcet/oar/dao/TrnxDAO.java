/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrcet.oar.dao;

import com.mrcet.oar.beans.Ticket;
import com.mrcet.oar.beans.Transaction;
import com.mrcet.oar.beans.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author techm
 */
public interface TrnxDAO {
    public abstract void bookDetails(Transaction transaction)  throws SQLException, ClassNotFoundException;
    public List<Transaction> getAllTickets(User user) throws SQLException,ClassNotFoundException;
    public List<Ticket> getTicketsToConfirm()  throws SQLException,ClassNotFoundException; 
}
