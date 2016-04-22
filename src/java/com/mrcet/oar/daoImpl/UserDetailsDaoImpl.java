/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrcet.oar.daoImpl;

import com.mrcet.oar.beans.User;
import com.mrcet.oar.beans.UserDetails;
import com.mrcet.oar.dao.UserDetailsDAO;
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
public class UserDetailsDaoImpl implements UserDetailsDAO{

    private static String getUniqueRegistrationId() throws SQLException{
        Connection con=null;
        String ID = "";
        con=DBUtil.getConnection();
        if(con != null){
            PreparedStatement preparedStatement = con.prepareStatement("select max(registrationid) as id from oaruserdetails");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                ID = resultSet.getString("id");
            }
            int temp = Integer.parseInt(ID);
            temp = temp + 1;
            ID = "" + temp;
        }
        return ID;
    }
    
    public int registerUser(User user, UserDetails userDetails) throws SQLException, ClassNotFoundException {
        Connection con=null;
        String role = null;
        con=DBUtil.getConnection();
        if(con != null){
            String insertSQL = "INSERT INTO OARUSER(EMAIL,PASSWORD,ROLE) VALUES(?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(insertSQL);
            preparedStatement.setString(1,user.getEmail());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getRole());
            int returnVal = preparedStatement.executeUpdate();
            if(returnVal == 1){
                insertSQL = "INSERT INTO OARUSERDETAILS VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                preparedStatement = con.prepareStatement(insertSQL);
                preparedStatement.setString(1,getUniqueRegistrationId());
                preparedStatement.setString(2,userDetails.getEmailId());
                preparedStatement.setString(3,userDetails.getFirstName());
                preparedStatement.setString(4,userDetails.getLastName());
                preparedStatement.setString(5,userDetails.getDateOfBirth());
                preparedStatement.setString(6,userDetails.getPanNo());
                preparedStatement.setString(7,userDetails.getGender());
                preparedStatement.setString(8,userDetails.getAccountNumber());
                preparedStatement.setString(9,userDetails.getBankName());
                preparedStatement.setString(10,userDetails.getBranchName());
                preparedStatement.setString(11,userDetails.getContact1());
                preparedStatement.setString(12,userDetails.getContact2());
                preparedStatement.setString(13,userDetails.getAddress());
                preparedStatement.setString(14,userDetails.getCustomerCertificateNumber());
                preparedStatement.setString(15,userDetails.getStatusApproval());
                preparedStatement.executeUpdate();
            }
            
        }
        return 1;
    }

    public List<UserDetails> getAllUsers() throws SQLException, ClassNotFoundException {
        Connection con=null;
        String role = null;
        con=DBUtil.getConnection();
        List userList = null;
        if(con != null){
                String insertSQL = "select * from oaruserdetails order by status_approval";
                PreparedStatement preparedStatement = con.prepareStatement(insertSQL);
                ResultSet resultSet = preparedStatement.executeQuery();
                UserDetails userDetails = null;
                userList = new ArrayList();
                while(resultSet.next()){
                    userDetails = new UserDetails();
                userDetails.setRegistrationId(resultSet.getString("registrationid"));
                userDetails.setEmailId(resultSet.getString("email"));
                userDetails.setFirstName(resultSet.getString("firstname"));
                userDetails.setLastName(resultSet.getString("lastname"));
                userDetails.setDateOfBirth(resultSet.getString("dob"));
                userDetails.setPanNo(resultSet.getString("panno"));
                userDetails.setGender(resultSet.getString("gender"));
                userDetails.setAccountNumber(resultSet.getString("accountnumber"));
                userDetails.setBankName(resultSet.getString("bankname"));
                userDetails.setBranchName(resultSet.getString("branchname"));
                userDetails.setContact1(resultSet.getString("contactone"));
                userDetails.setContact2(resultSet.getString("contacttwo"));
                userDetails.setAddress(resultSet.getString("address"));
                userDetails.setCustomerCertificateNumber(resultSet.getString("CUST_CERTIFICATE_NUMBER"));
                userDetails.setStatusApproval(resultSet.getString("STATUS_APPROVAL"));
                
                userList.add(userDetails);
                }
        }
        DBUtil.closeConnection(con);
        return userList;
    }

    public void approveUser(String registrationID) throws SQLException, ClassNotFoundException {
       Connection con=null;
        String role = null;
        con=DBUtil.getConnection();
        
        if(con != null && registrationID != null){
            String updateTableSQL = "UPDATE OARUSERDETAILS SET status_approval = ? WHERE registrationid = ?";
            PreparedStatement preparedStatement = con.prepareStatement(updateTableSQL);
            preparedStatement.setString(1,"Y");
            preparedStatement.setString(2,registrationID);
            preparedStatement.executeUpdate();
            
        }
        DBUtil.closeConnection(con);
    }
//  public static void main(String a[]) throws Exception{
//      Connection con = DBUtil.getConnection();
//      System.out.println("------------------------------");
//      PreparedStatement ps = con.prepareStatement("delete from oaruser where email=? or email=?");
//      ps.setString(1,"test99@gmail.com");
//      ps.setString(2,"test98@gmail.com");
//      System.out.println(ps.executeQuery());
//      con.commit();
//      System.out.println("------------------cisdf");
//  }
}

