<%-- 
    Document   : ordenes
    Created on : 1 jul. 2021, 21:57:34
    Author     : luisr
--%>

<%@page import="com.luis.Email" contentType="text/html" pageEncoding="UTF-8"%>

<%
   Email e = new Email("smtp.gmail.com","465","pruebaluisrm@gmail.com","Kreatormeta123","luisrm5142@gmail.com","Test","Hello, this is a test, I'm Luis");
   e.test();
   e.enviar();
   System.out.println("Probrando");
   
//  int courseid = Integer.parseInt(request.getParameter("select"));
%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=submit] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
</head>
<body>

<h3>Contact Form</h3>

<div class="container">
  <form action="/action_page.php">
    <label for="fname">First Name</label>
    <input type="text" id="fname" name="firstname" placeholder="Your name..">

    <label for="lname">Last Name</label>
    <input type="text" id="lname" name="lastname" placeholder="Your last name..">

    <label for="country">Country</label>
    <select id="country" name="country">
      <option value="australia">Tomate - $3</option>
      <option value="canada">Canada</option>
      <option value="usa">USA</option>
    </select>
    <!--giving name attribute to access it in servlet-->
<!--    <select name="select">
        <c:forEach var="tempstudent" items="${select}">
            passing id 
            <option value="${tempstudent.id}">${tempstudent.id},
            <td>${tempstudent.name} - $${tempstudent.price}</td>
            </option>
        </c:forEach>
    </select>-->

    <label for="subject">Subject</label>
    <textarea id="subject" name="subject" placeholder="Write something.." style="height:200px"></textarea>

    <input type="submit" value="Submit">
  </form>
</div>

</body>
</html>

