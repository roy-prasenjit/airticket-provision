

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; 
charset=ISO-8859-1">
<title>REGISTRATION PAGE</title>
<script language="javascript" src="./static/registrationvalidation.js">
</script>
</head>
<body bgcolor="white">
<center>
<h2> REGISTRATION FORM </h2>  </center>

<form name="reg" action="./register" method="post">
<center>
<table>
    
    <tr>
<td> <b> <font size=4>email/username                            
</font></b></td>   <td> <input 
type="text" name="username" id="uname"></td> </tr>
 
    <tr>
<td> <b> <font size=4>Password  </font></b></td>   <td> <input 
type="password" name="password" id="pswd"> </td> </tr>
    <tr>
<td> <b> <font size=4>Confirm Password  </font></b></td>   <td> <input 
type="password" name="password" id="pswd2"> </td> </tr>
    
<tr>
<td> <b> <font size=4>First Name                            
</font></b></td>   <td> <input 
type="text" name="name" id="name"></td> </tr>


<tr>
<td> <b> <font size=4>Last Name                            
</font></b></td>   <td> <input 
type="text" name="lname" id="lname"></td> </tr>

<tr>
<td><b> <font size=4> Gender</font></b> 
</td> <td> 
<select name="gender"><option>Male</option><option>Female</option></select>

<tr>
<td> <b> <font size=4>Date Of Birth                   
</font></b></td>   <td> <input 
type="text" name="dateOfBirth" id="dob"></td> </tr>



<tr>
<td> <b> <font size=4>PAN Number                      
</font></b></td>   <td> <input 
type="text" name="panNo" id="panno"></td> </tr>

<tr>
<td><b> <font size=4>Account Number                   
</font></b></td>     <td> <input type="text" name="bankAccountNo" id="accno"></td></tr>

<tr>
<td> <b> <font size=4> Bank Name		         	  
</font></b></td>    <td> <input type="text" name="bankName" id="bname"></td></tr>

<tr>
<td> <b> <font size=4> Bank Branch		         	  
</font></b></td>    <td> <input type="text" name="bankbranch" id="bbranch"></td></tr>

<tr>
<td> <b> <font size=4>Mobile Number                    
</font></b></td>   <td> <input type="text" name="mobileNo" id="num"> </td> 
</tr>

<tr>
<td> <b> <font size=4>Alternate Mobile Number                    
</font></b></td>   <td> <input type="text" name="mobileNo2" id="num2"> </td> 
</tr>

<tr>
<td> <b> <font size=4>Bank Privileged Customer Number  
</font></b></td>   <td> <input type="text" 
name="bankPrivilegeCustomerNumber" id="pno"> </td> </tr>



</table>
 <br>
<input type="submit" value="submit" onclick="return validate()" >
<br>
</center>
</form>
</body>
</html>
