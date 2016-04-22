/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrcet.oar.dao;

import com.mrcet.oar.beans.Flight;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author techm
 */
public interface FlightDAO {
    public abstract List<Flight> getAllFlights() throws SQLException,ClassNotFoundException;
    public Flight getFlightDetails(String flightID) throws SQLException,ClassNotFoundException;
}
