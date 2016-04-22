/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrcet.oar.daoImpl;

import com.mrcet.oar.beans.Ticket;
import com.mrcet.oar.beans.Transaction;
import com.mrcet.oar.beans.User;
import com.mrcet.oar.dao.TrnxDAO;
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
public class TrnxDaoImpl implements TrnxDAO{

    public void bookDetails(Transaction transaction) throws SQLException, ClassNotFoundException {
        Connection con=null;
        String role = null;
        con=DBUtil.getConnection();
        Math.round(34.6);
        if(con != null){
         String insertSQL = "INSERT INTO TRNX(TRANX,USEREMAIL,FLIGHTID,BOOKINGDATE,JOURNEYDATE,FARE,STATUS_APPROVAL) VALUES(?,?,?,?,?,?,?)";
         PreparedStatement preparedStatement = con.prepareStatement(insertSQL);
         preparedStatement.setString(1,getUniqueTransactionID());
         preparedStatement.setString(2,transaction.getEmail());
         preparedStatement.setString(3,transaction.getFlightId());
         preparedStatement.setString(4,transaction.getBookingDate());
         preparedStatement.setString(5,transaction.getJourneyDate());
         String fare = "" + Math.round(transaction.getFare());
         preparedStatement.setString(6,fare);
         preparedStatement.setString(7,transaction.getStatusApproval());
         int returnVal = preparedStatement.executeUpdate();
        }
        DBUtil.closeConnection(con);
    }

    private static String getUniqueTransactionID() throws SQLException {
       Connection con=null;
        String ID = "";
        con=DBUtil.getConnection();
        if(con != null){
            PreparedStatement preparedStatement = con.prepareStatement("select max(TRANX) as id from trnx");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                ID = resultSet.getString("id");
                System.out.println("ID:" + ID);
            }
            if(ID == null) ID="1111";
            int temp = Integer.parseInt(ID);
            temp = temp + 1;
            ID = "" + temp;
        }
        DBUtil.closeConnection(con);
        return ID;
    }

    public List<Transaction> getAllTickets(User user) throws SQLException, ClassNotFoundException {
        Connection con=null;
        String role = null;
        con=DBUtil.getConnection();
        List tickets = null;
        if(con != null){
          tickets = new ArrayList();
            PreparedStatement preparedStatement=con.prepareStatement("select * from trnx where USEREMAIL=? order by fare");
            preparedStatement.setString(1,user.getEmail());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Transaction temp = new Transaction();
                temp.setFlightId(resultSet.getString("flightid"));
                temp.setFare(resultSet.getDouble("fare"));
                temp.setBookingDate(resultSet.getString("bookingdate"));
                temp.setJourneyDate(resultSet.getString("journeydate"));
                temp.setStatusApproval(resultSet.getString("status_approval"));
                tickets.add(temp);
            }  
        }
        DBUtil.closeConnection(con);
        return tickets;
    }

    public List<Ticket> getTicketsToConfirm() throws SQLException, ClassNotFoundException {
        List<Ticket> ticketList = null;
        Connection con=DBUtil.getConnection();
        if(con!=null){
         PreparedStatement preparedStatement = con.prepareStatement("select * from TRNX X,USERDETAILS U WHERE X.USEREMAIL=U.EMAIL");
         // unimplemented code for retriving tickets
        }
        DBUtil.closeConnection(con);
        return ticketList;        
    }
    
}
