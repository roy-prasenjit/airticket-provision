/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrcet.oar.services;

import com.mrcet.oar.beans.Flight;
import com.mrcet.oar.dao.FlightDAO;
import com.mrcet.oar.daoImpl.FlightDaoImpl;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author techm
 */
public class FlightServiceImpl implements FlightService{

    public List<Flight> getAllFlights() throws SQLException, ClassNotFoundException {
       FlightDAO flightDAO= new FlightDaoImpl();
        return flightDAO.getAllFlights();
    }

    public Flight getFlightDetails(String flightID) throws SQLException, ClassNotFoundException {
        FlightDAO flightDAO= new FlightDaoImpl();
        return flightDAO.getFlightDetails(flightID);
    }
}
