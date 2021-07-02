<%-- 
    Document   : ordenes
    Created on : 1 jul. 2021, 21:57:34
    Author     : luisr
--%>

<%@page import="com.luis.Email" contentType="text/html" pageEncoding="UTF-8"%>

<%
   Email e = new Email("jcnv21@gmail.com","luisrm5142@gmail.com", "localhost");
   e.test();
   System.out.println("Probrando");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
