<%-- 
    Document   : useraccount
    Created on : Oct 8, 2015, 11:20:37 AM
    Author     : techm
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="./static/flightbooking.js"></script>
        <%
            HttpSession httpSession = request.getSession(false);
            String username = (String)httpSession.getAttribute("username");
            String role = (String)httpSession.getAttribute("role");
            if(httpSession == null || username == null || role == null  ) response.sendRedirect("./login.html");
        %>
        <h2>Welcome <% out.println(username); %> </h2>&nbsp;&nbsp;&nbsp;<a href="./logout">logout</a>
    </head>
    <body>
        <h3>Previous Booking Details</h3>
        <table>
            <tr>
                    <th> Flight ID </th>
                    <th> Booking date </th>
                    <th> Journey date </th>
                    <th> Status </th>
                    <th> Fare </th>
            </tr>
            <c:forEach var="ticket" items="${sessionScope.tickets}">
                    <tr>
                     <td><c:out value="${ticket.flightId}"/></td>
                     <td><c:out value="${ticket.bookingDate}"/></td>
                     <td><c:out value="${ticket.journeyDate}"/></td>
                     <td><b><c:out value="${ticket.statusApproval}"/></b></td>
                     <td><c:out value="${ticket.fare}"/></td>
                    </tr>
             </c:forEach>
        </table>
        <h3>Running Flight Details</h3>
        <form action="./bookticket" method="post" onsubmit="return validateForm()">
            <table>
                <tr>
                    <th> Flight Name </th>
                    <th> Flight Type </th>
                    <th> Source </th>
                    <th> Destination </th>
                    <th> Departure Time </th>
                    <th> Arrival Time </th>
                    <th> Fare Cost </th>
                    <th> Flight Select </th>
                </tr>
                <c:forEach var="flight" items="${sessionScope.flights}">
                    <tr>
                     <td><c:out value="${flight.flightName}"/></td>
                     <td><c:out value="${flight.flightType}"/></td>
                     <td><c:out value="${flight.source}"/></td>
                     <td><c:out value="${flight.destination}"/></td>
                     <td><c:out value="${flight.departureTime}"/></td>
                     <td><c:out value="${flight.arrivalTime}"/></td>
                     <td><c:out value="${flight.fare}"/></td>
                     <td><input type="radio" name="flightSelected" value="${flight.flightID}"></td>
                    </tr>
                </c:forEach>
                    <tr><td><input type="submit" value="Book Ticket"></td></tr>
            </table>
        </form>
    </body>
</html>
