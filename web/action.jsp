<%-- 
    Document   : action
    Created on : Jul 8, 2021, 12:30:01 AM
    Author     : luisr
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.luis.Producto"%>
<%@page import="com.luis.DB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>



        <%!
            List<Producto> arrayProducto = new ArrayList<>();

            public int runConfiguration() {
                System.out.println("runConfiguration");

                DB cone = new DB();
                cone.setConn();
                arrayProducto = cone.getProductos();
                int l = 0;
                if (arrayProducto == null) {
                    arrayProducto = new ArrayList<>();
                } else {
                    l = arrayProducto.size();
                }
                return l;
            }

            int a = runConfiguration();
        %>

        <%!
            public int sum(int a, int b) {
                System.out.println(a);
                System.out.println(b);
                return a + b;
            }
        %>
        2 + 2 = <%= sum(2, 2)%>



        <button type="button" onclick=" <% sum(5, 6);%>">Run</button>
        <button type="button" onClick=" <%= sum(5, 6)%>">Run</button>  


        <h1>Hello World!</h1>

        <select name="prop" id="Produc">
            <% for (int i = 0;
                        i < arrayProducto.size();
                        i += 1) {%>
            <option value="<%=arrayProducto.get(i).getProductoID()%>">
                <%=arrayProducto.get(i).getNombre()%>  	₡<%=arrayProducto.get(i).getPrecio()%>
            </option>
            <c:if test="${arrayProducto.get(i).getProductoID() eq selectedProdId}">selected="selected"</c:if>
            >
            ${arrayProducto.get(i).getNombre()}
            <% }%>
        </select>
    </body>
</html>
