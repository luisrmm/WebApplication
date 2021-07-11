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

<%@page import="com.luis.Email" import="com.luis.JavaMailPop3Reader" import="com.luis.DB" import="com.luis.LecturaXML" contentType="text/html" pageEncoding="UTF-8"%>

<%
    Email e = new Email("smtp.gmail.com", "587", "pruebaluisrm@gmail.com", "Kreatormetal123", "o.cempresa12@gmail.com", "Orden Compra", "Orden de xml adjunta", "C:/Users/luisr/Documents/NetBeansProjects/WebApplication2/Documentos/XML enviado/ordencompra.xml", "ordencompra.xml");
    JavaMailPop3Reader g = new JavaMailPop3Reader();
    LecturaXML leer = new LecturaXML();
    DB cone = new DB();
    e.enviar();
    g.getInbox();
    cone.setConn();
    leer.enviar();
    cone.insertdata();
   

    List<Producto> arrayProducto = new ArrayList<>();
    arrayProducto = cone.getProductos();
    int l = 0;
    if (arrayProducto == null) {
        arrayProducto = new ArrayList<>();
    } else {
        l = arrayProducto.size();
    }
%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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

            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #dddddd;
            }
            body {margin:0;}

            .icon-bar {
                width: 100%;
                background-color: #555;
                overflow: auto;
            }

            .icon-bar a {
                float: left;
                width: 20%;
                text-align: center;
                padding: 12px 0;
                transition: all 0.3s ease;
                color: white;
                font-size: 36px;
            }

            .icon-bar a:hover {
                background-color: #000;
            }

            .active {
                background-color: #04AA6D;
            }

        </style>
    </head>
    <body>

        <div class="icon-bar">
            <a class="active" href="index.html"><i class="fa fa-home"></i></a> 
        </div>
        <form name="f1" method="get" action="#">
            <select name="clr">
                <option>Red</option>
                <option>Blue</option>   
                <option>Green</option>
                <option>Pink</option>
            </select>
            <input type="submit" name="submit" value="Select Color"/>
        </form>
        <%-- To display selected value from dropdown list. --%>
        <%
            String s = request.getParameter("clr");
            if (s != null) {
                System.out.println("Selected Color is : " + s);
            }
        %>
        <h3>ORDEN DE COMPRA</h3>

        <div class="container">
            <form action="list" method="get">.
                <label for="cant">Cantidad</label>
                <input type="text" id="cant" placeholder="Ingrese una cantidad..">

                <label for="prop">Productos</label>
                </select>
                <select name="prop" id="Produc">
                    <% for (int i = 0; i < arrayProducto.size(); i += 1) {%>
                    <option value="<%=arrayProducto.get(i).getProductoID()%>">
                        <%=arrayProducto.get(i).getNombre()%>  	₡<%=arrayProducto.get(i).getPrecioUnitario()%>
                    </option>
                    <% }%>
                </select>

                <br/><br/>
                <input type="Submit" value="Submit" />
                <br/><br/>
                <label for="orden">Su Orden</label>
                <table>
                    <tr>
                        <th>Producto ID</th>
                        <th>Nombre</th>
                        <th>Precio</th>
                        <th>Cantidad</th>
                    </tr>
                    <tr>
                        <td>6</td>
                        <td>Atun</td>
                        <td>₡700.0</td>
                        <td>2</td>
                    </tr>
                </table>
                <br/><br/>
                <label for="ltotal">Total</label>
                <input type="text" id="ltotal" disabled placeholder="Total..">

                <input type="submit" value="Submit">
            </form>
        </div>

    </body>
</html>