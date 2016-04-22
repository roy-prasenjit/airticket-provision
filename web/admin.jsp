<%-- 
    Document   : admin
    Created on : Oct 8, 2015, 11:23:58 AM
    Author     : techm
--%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
        HttpSession httpSession = request.getSession(false);
       String username = (String)httpSession.getAttribute("username");
       String role = (String)httpSession.getAttribute("role");
        if(httpSession == null || username == null || role == null  ) response.sendRedirect("./login.html");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <h3>Admin's Page</h3>&nbsp;<a href="./logout">logout</a><br/>
    <h4> Welcome <% out.println(username); %>
    </head>
    <body>
        <h3>Existing users</h3>
        <form action="./approveuser" method="post">
            <table>
                <tr>
                    <th>Registration ID<th>
                    <th>User Email</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Bank Name</th>
                    <th>Bank Account Number</th>
                    <th> Pan Number </th>
                    <th>Phone Number</th>
                    <th>Alternate Number</th>
                    <th>Status</th>
                </tr>

            <c:forEach var="user" items="${sessionScope.users}">
                <tr>

                         <td><c:out value="${user.registrationId}"/></td>
                         <td><c:out value="${user.emailId}"/></td>
                         <td><c:out value="${user.firstName}"/></td>
                         <td><c:out value="${user.lastName}"/></td>
                         <td><c:out value="${user.bankName}"/></td>
                         <td><c:out value="${user.accountNumber}"/></td>
                         <td><c:out value="${user.panNo}"/></td>
                         <td><c:out value="${user.contact1}"/></td>
                         <td><c:out value="${user.contact2}"/></td>
                         <td><c:out value="${user.statusApproval}"/></td>
                         <c:choose>
                            <c:when test="${user.statusApproval == 'N' }">
                                <td><input type="radio" name="userSelected" value="${user.registrationId}"></td>
                            </c:when>
                        </c:choose> 
                </tr>
            </c:forEach>
                <tr><td><input type="submit" value="Approve User"></td></tr>
            </table>
        </form>
        <h3> Tickets being booked </h3>
        
        
        
    </body>
</html>