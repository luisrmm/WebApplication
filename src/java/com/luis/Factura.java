/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luis;

import java.util.List;

/**
 *
 * @author luisr
 */
public class Factura {

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public List<Producto> getProductos() {
        return Productos;
    }

    public void setProductos(List<Producto> Productos) {
        this.Productos = Productos;
    }

    public Factura(int clienteID, String Correo, String Nombre, String Fecha, List<Producto> Productos) {
        this.clienteID = clienteID;
        this.Correo = Correo;
        this.Nombre = Nombre;
        this.Fecha = Fecha;
        this.Productos = Productos;
    }

    private int clienteID;
    private String Correo;
    private String Nombre;
    private String Fecha;

    private List<Producto> Productos;
}
