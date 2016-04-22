/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrcet.oar.services;

import com.mrcet.oar.beans.Flight;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author techm
 */
public interface FlightService {
    public abstract List<Flight> getAllFlights() throws SQLException,ClassNotFoundException;
    public abstract Flight getFlightDetails(String FlightID) throws SQLException,ClassNotFoundException;
}
