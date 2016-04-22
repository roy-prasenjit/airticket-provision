/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrcet.oar.daoImpl;

import com.mrcet.oar.beans.User;
import com.mrcet.oar.dao.UserDAO;
import com.mrcet.oar.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author techm
 */
public class UserDaoImpl implements UserDAO{

    public String validateUser(User user) throws SQLException,ClassNotFoundException{
        Connection con=null;
        String role = null;
        con=DBUtil.getConnection();
        if(con != null){
            PreparedStatement pst=con.prepareStatement("select role from oaruser where email=? and password=?");
            pst.setString(1,user.getEmail());
            pst.setString(2,user.getPassword());
            ResultSet resultSet = pst.executeQuery();
            if(resultSet.next()){
                role = resultSet.getString("role");
            }
        }
        else{ return "dberror"; }
        DBUtil.closeConnection(con);
        return role != null ? role : "invalid";
    }

    public boolean registrationStatus(User user) throws SQLException, ClassNotFoundException {
        Connection con=null;
        boolean status = false;
        con=DBUtil.getConnection();
        if(con != null){
         PreparedStatement pst=con.prepareStatement("select status_approval from oaruserdetails where email=?");
         pst.setString(1,user.getEmail());
         ResultSet resultSet = pst.executeQuery();
         if(resultSet.next()){
             String temp = resultSet.getString("status_approval");
             if(temp.equals("Y")){
                 //check if this module is working properly
                 status = true; 
             }
         }
        }
        DBUtil.closeConnection(con);
        return status;
    }
    
    
    
    
    
    
    
}
