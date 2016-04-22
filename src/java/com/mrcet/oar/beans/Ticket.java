/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrcet.oar.beans;

/**
 *
 * @author techm
 */
public class Ticket {
    private UserDetails userDetails;
    private Transaction transaction;

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "Ticket{" + "userDetails=" + userDetails + ", transaction=" + transaction + '}';
    }
    
    
}
