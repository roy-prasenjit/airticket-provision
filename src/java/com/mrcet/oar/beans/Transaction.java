/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrcet.oar.beans;

import java.io.Serializable;

/**
 *
 * @author techm
 */
public class Transaction implements Serializable{
    private String transactionID;
    private String email;
    private String flightId;
    private String bookingDate;
    private String journeyDate;
    private double fare;
    private String statusApproval;

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(String journeyDate) {
        this.journeyDate = journeyDate;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getStatusApproval() {
        return statusApproval;
    }

    public void setStatusApproval(String statusApproval) {
        this.statusApproval = statusApproval;
    }

    @Override
    public String toString() {
        return "Transaction{" + "transactionID=" + transactionID + ", email=" + email + ", flightId=" + flightId + ", bookingDate=" + bookingDate + ", journeyDate=" + journeyDate + ", fare=" + fare + ", statusApproval=" + statusApproval + '}';
    }
    
}   

