<%-- 
    Document   : student
    Created on : Jul 7, 2021, 9:38:57 PM
    Author     : luisr
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Actions Example</title>
</head>
<body>

<h1> Student Registration Page</h1>
 <form action="StudentServlet" method="get">
  First Name: <input type="text" name="firstName">
  <br> <br> 
  
  Last Name: <input type="text" name="lastName">
  <br> <br> 
  
  Email ID: <input type="email" name="emailId">
  <br> <br> 
  
  Password: <input type="password" name="password"><br>
  
  <br> 
  <input type="submit" value="register">
 </form>
</body>
</html>