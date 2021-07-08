/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luis;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/list")
public class ListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DB dao = new DB();
        dao.setConn();
        List<Producto> arrayProducto = dao.getProductos();
         System.out.println("lfglhljlfjlfjghjfdhkjhgfdhgfkdh");
         System.out.println(arrayProducto.size()); 
        request.setAttribute("arrayProducto", arrayProducto);
        request.setAttribute("id", "1234");
        RequestDispatcher dispatcher = request.getRequestDispatcher("newjsp.jsp");
        dispatcher.forward(request, response);
    }
}