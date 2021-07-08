<%-- 
    Document   : newjsp
    Created on : Jul 7, 2021, 8:37:42 PM
    Author     : luisr
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.luis.Producto"%>
<%@page import="com.luis.Producto"%>
<%-- 
    Document   : ordenes
    Created on : 1 jul. 2021, 21:57:34
    Author     : luisr
--%>

<%@page import="com.luis.Email" import="com.luis.JavaMailPop3Reader" import="com.luis.DB" contentType="text/html" pageEncoding="UTF-8"%>

<%
    Email e = new Email("smtp.gmail.com", "587", "pruebaluisrm@gmail.com", "Kreatormetal123", "o.cempresa12@gmail.com", "Orden Compra", "Orden de compra xml adjunta");
    JavaMailPop3Reader g = new JavaMailPop3Reader();
    DB cone = new DB();
    e.enviar();
    g.getInbox();
    cone.setConn();
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

            input.add{
                margin-top: 6px;
                margin-bottom: 6px;
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

            .orden {
                padding-top: 20px;
            }

        </style>
    </head>
    <body>

        <h3>ORDEN DE COMPRA</h3>

        <div class="container">
            <form action="list" method="get">
                <label for="cant">Cantidad</label>
                <input type="text" id="cant" placeholder="Ingrese una cantidad..">

                <% String id = (String)request.getAttribute("id");
                if (id == null){
                    id = "33";
                }
                %>
                
                 <%  List<Producto> arrayProducto = (List<Producto>)request.getAttribute("arrayProducto");
                 int l = 0;
                if (arrayProducto == null){
                    arrayProducto = new ArrayList<>();
                }else{
                    l= arrayProducto.size();
                }
                %>
                
                <h2><%=l%><h2/>
                <div class="marginTable" data-pubid="<%=id%>" data-count="5"></div>
                Select a Category:&nbsp;
                <select name="producto">
                    <c:forEach items="${arrayProducto}" var="producto">
                        <option value="${producto.getProductoID()}">${producto.getNombre()}</option>
                    </c:forEach>
                </select>
                <br/><br/>
                <input type="submit" value="Submit" />

                <div class="orden" >      
                    <label for="orden">Su Orden</label>
                    <textarea id="orden" disabled placeholder="5 Kilos - Tomates -$3 -> $15" style="height:200px"></textarea>
                </div>


                <label for="ltotal">Total</label>
                <input type="text" id="ltotal" disabled placeholder="Total..">

                <input type="submit" value="Submit">
            </form>
        </div>

    </body>
</html>