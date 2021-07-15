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
public class FacturaJson {

    public FacturaJson(int NumFac, int clienteID, String Nombre, String Correo, String Fecha, int ProductoID, String NombrePro, int Cantidad, int Precio, int Total) {
        this.NumFac = NumFac;
        this.clienteID = clienteID;
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.Fecha = Fecha;
        this.ProductoID = ProductoID;
        this.NombrePro = NombrePro;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.Total = Total;
    }

    public int getNumFac() {
        return NumFac;
    }

    public void setNumFac(int NumFac) {
        this.NumFac = NumFac;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public int getProductoID() {
        return ProductoID;
    }

    public void setProductoID(int ProductoID) {
        this.ProductoID = ProductoID;
    }

    public String getNombrePro() {
        return NombrePro;
    }

    public void setNombrePro(String NombrePro) {
        this.NombrePro = NombrePro;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }

   

    private int NumFac;
    private int clienteID;
    private String Nombre;
    private String Correo;
    private String Fecha;
    private int ProductoID;
    private String NombrePro;
    private int Cantidad;
    private int Precio;
    private int Total;

}
