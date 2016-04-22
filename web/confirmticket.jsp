<%-- 
    Document   : confirmticket
    Created on : Oct 8, 2015, 5:12:09 PM
    Author     : techm
--%>

<%@page import="com.techm.oar.beans.Flight"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
        HttpSession httpSession = request.getSession(false);
       String username = (String)httpSession.getAttribute("username");
       String role = (String)httpSession.getAttribute("role");
       out.println("username: " + username + "  role" + role);
       if(httpSession == null || username == null || role == null  ) response.sendRedirect("./login.html");
       Flight flight = (Flight)httpSession.getAttribute("flight");
        %>
    </head>
    <body>
        <h3>Confirm Your Ticket Details </h3>
        <form action="./confirm" method="post">
            <table>
                <tr><td>Registered Email: <% out.println(username); %></td></tr>
                <tr><td>Flight ID: <% out.println(flight.getFlightID()); %></td></tr>
                <tr><td>Flight Name: <% out.println(flight.getFlightName()); %></td></tr>
                <tr><td>Flight Type: <% out.println(flight.getFlightType()); %></td></tr>
                <tr><td>Source: <% out.println(flight.getSource()); %></td></tr>
                <tr><td>Destination: <% out.println(flight.getDestination()); %></td></tr>
                <tr><td>Departure Time: <% out.println(flight.getDepartureTime()); %></td></tr>
                <tr><td>Arrival Time: <% out.println(flight.getArrivalTime()); %></td></tr>
                <tr><td><b>Date of journey: </b><input type="date" name="dateofjourney"></td></tr>
                <tr><td>Flight Fare: <b><% out.println(flight.getFare() + flight.getFare()*0.125); %></b></td></tr>
                <tr><td><input type="submit" value="Confirm!"></td></tr>
            </table>
        </form>
    </body>
</html>
