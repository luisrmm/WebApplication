/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luis;

/**
 *
 * @author luisr
 */
public class Producto {

    public int getProductoID() {
        return ProductoID;
    }

    public void setProductoID(int ProductoID) {
        this.ProductoID = ProductoID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(double PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }

    public Producto(int ProductoID, String Nombre, double PrecioUnitario) {
        this.ProductoID = ProductoID;
        this.Nombre = Nombre;
        this.PrecioUnitario = PrecioUnitario;
    }
    
    private int ProductoID;
    private String Nombre;
    private double PrecioUnitario;
    
}
