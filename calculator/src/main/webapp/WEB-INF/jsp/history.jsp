<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Previous Calculations</title>
</head>
<body>
    <h1>History <br>
    <%
        for(Calculator temp: ${previousCalculations}) {
         %>
         temp
         <%
        }
    %>
    </h1>
</body>
</html>