/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrcet.oar.services;

import com.mrcet.oar.beans.Transaction;
import com.mrcet.oar.beans.User;
import com.mrcet.oar.dao.TrnxDAO;
import com.mrcet.oar.daoImpl.TrnxDaoImpl;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author techm
 */
public class TransactionServiceImpl implements TransactionService{

    public void bookDetails(Transaction transaction) throws SQLException, ClassNotFoundException {
       TrnxDAO trnxDAO= new TrnxDaoImpl();
       trnxDAO.bookDetails(transaction);
    }

    public List<Transaction> getAllTickets(User user) throws SQLException, ClassNotFoundException {
        TrnxDAO trnxDAO= new TrnxDaoImpl();
        return trnxDAO.getAllTickets(user);
    }
    
}
