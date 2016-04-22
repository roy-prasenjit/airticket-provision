/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrcet.oar.daoImpl;

import com.mrcet.oar.beans.Flight;
import com.mrcet.oar.dao.FlightDAO;
import com.mrcet.oar.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author techm
 */
public class FlightDaoImpl implements FlightDAO{

    public List<Flight> getAllFlights() throws SQLException, ClassNotFoundException {
        List flightList = null;
        Connection con=null;
        String role = null;
        con=DBUtil.getConnection();
        if(con != null){
            flightList = new ArrayList();
            PreparedStatement preparedStatement=con.prepareStatement("select * from OARFLIGHTS order by fare");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Flight temp = new Flight();
                temp.setFlightID(resultSet.getString("FLIGHTID"));
                temp.setFlightName(resultSet.getString("FLIGHTNAME"));
                temp.setFlightType(resultSet.getString("FLIGHTTYPE"));
                temp.setArrivalTime(resultSet.getString("ARRIVAL_TIME"));
                temp.setDepartureTime(resultSet.getString("DEPARTURE_TIME"));
                temp.setSource(resultSet.getString("SOURCE"));
                temp.setDestination(resultSet.getString("DESTINATION"));
                temp.setCapacity(Integer.parseInt(resultSet.getString("CAPACITY")));
                temp.setFare(Integer.parseInt(resultSet.getString("FARE")));
                flightList.add(temp);
            }
        }
        DBUtil.closeConnection(con);
        return flightList;
    }

    public Flight getFlightDetails(String flightID) throws SQLException, ClassNotFoundException {
        Connection con=null;
        String role = null;
        con=DBUtil.getConnection();
        Flight temp = null;
        if(con != null){
            PreparedStatement preparedStatement=con.prepareStatement("select * from OARFLIGHTS where flightid=?");
            preparedStatement.setString(1,flightID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                temp = new Flight();
                temp.setFlightID(resultSet.getString("FLIGHTID"));
                temp.setFlightName(resultSet.getString("FLIGHTNAME"));
                temp.setFlightType(resultSet.getString("FLIGHTTYPE"));
                temp.setArrivalTime(resultSet.getString("ARRIVAL_TIME"));
                temp.setDepartureTime(resultSet.getString("DEPARTURE_TIME"));
                temp.setSource(resultSet.getString("SOURCE"));
                temp.setDestination(resultSet.getString("DESTINATION"));
                temp.setCapacity(Integer.parseInt(resultSet.getString("CAPACITY")));
                temp.setFare(Integer.parseInt(resultSet.getString("FARE")));
            }
        }
        DBUtil.closeConnection(con);
        return temp;
    }
}
