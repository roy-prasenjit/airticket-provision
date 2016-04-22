/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrcet.oar.util;

/**
 *
 * @author techm
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
          //LOG to be written
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@hstslc015:1521:elp", "", "");
        } catch (Exception e) {
            //LOG to be written
            e.printStackTrace();
        }
        return con;
    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
    public static void main(String args[]){
        System.out.println(getConnection());
    }
}
