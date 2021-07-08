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
public class ProductoOrden {

    public int getProductoOrdenID() {
        return ProductoOrdenID;
    }

    public void setProductoOrdenID(int ProductoOrdenID) {
        this.ProductoOrdenID = ProductoOrdenID;
    }

    public int getOrdenID() {
        return OrdenID;
    }

    public void setOrdenID(int OrdenID) {
        this.OrdenID = OrdenID;
    }

    public int getProductoID() {
        return ProductoID;
    }

    public void setProductoID(int ProductoID) {
        this.ProductoID = ProductoID;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public ProductoOrden(int ProductoOrdenID, int OrdenID, int ProductoID, int Cantidad) {
        this.ProductoOrdenID = ProductoOrdenID;
        this.OrdenID = OrdenID;
        this.ProductoID = ProductoID;
        this.Cantidad = Cantidad;
    }
    
    private int ProductoOrdenID;
    private int OrdenID;
    private int ProductoID;
    private int Cantidad;
}
