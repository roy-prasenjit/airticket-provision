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
public class Flight implements Serializable{
    private String flightID;
    private String flightName;
    private String flightType;
    private String arrivalTime;
    private String departureTime;
    private String source;
    private String destination;
    private int capacity;
    private int fare;

    public Flight() {
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "Flight{" + "flightID=" + flightID + ", flightName=" + flightName + ", flightType=" + flightType + ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + ", source=" + source + ", destination=" + destination + ", capacity=" + capacity + ", fare=" + fare + '}';
    }
    
    
    
    
}
