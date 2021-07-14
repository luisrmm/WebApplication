/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luis;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmailServelet")
public class EmailServerlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Email e = new Email("smtp.gmail.com", "587", "pruebaluisrm@gmail.com", "Kreatormetal123", "o.cempresa12@gmail.com", "Orden Compra", "Orden de xml adjunta", "C:/Users/luisr/Documents/NetBeansProjects/WebApplication2/Documentos/XML enviado/ordencompra.xml", "ordencompra.xml");
//jcnv21@gmail.com, oxszzjobvdswnmop
        e.enviar(); // Envia el correo a la 'empresa'
    }
}
