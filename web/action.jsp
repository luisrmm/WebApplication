<%-- 
    Document   : action
    Created on : Jul 8, 2021, 12:30:01 AM
    Author     : luisr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <script type="text/javascript">
            function runConfiguration(actionName) {
                console.log("runConfiguration")
            }
            function editConfiguration(actionName) {
                console.log("editConfiguration")
            }
            function deleteConfiguration(actionName) {
                console.log("deleteConfiguration")
            }

            function gotopage(actionname) {
                console.log("gotopage")

            }
        </script>


        <button type="button" onclick="runConfiguration()">Run</button>  
        <button type="button" onclick="editConfiguration()">Edit</button>
        <button type = "button" onclick = "deleteConfiguration()">Delete</button>

        <a href="<%=request.getContextPath()%>/action.jsp?action=runConfig">RUN</a>

        <a href="<%=request.getContextPath()%>/action.jsp?action=editConfig">EDIT</a>

        <h1>Hello World!</h1>

        <form action="action.jsp"> 
            <select name="productId"> 
                <option value="1">MyExamCloud</option> 
                <option value="2">ExamBoat</option> 
                <option value="3">Test Generator Lab</option> 
            </select> 
            <input type="submit" value="Submit"> 
            <input type="button" value="Create" onclick="location.href = '@Url.Action("Create", "User")'" />

        </form> 

        <%
            String productSelected = request.getParameter("productId");
        %>

        <h1><%= productSelected%></h1>
    </body>
</html>
