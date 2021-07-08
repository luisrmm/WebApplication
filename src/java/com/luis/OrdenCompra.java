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
public class OrdenCompra {

    public int getOrdenID() {
        return OrdenID;
    }

    public void setOrdenID(int OrdenID) {
        this.OrdenID = OrdenID;
    }

    public int getClienteID() {
        return ClienteID;
    }

    public void setClienteID(int ClienteID) {
        this.ClienteID = ClienteID;
    }

    public double getDescuento() {
        return Descuento;
    }

    public void setDescuento(double Descuento) {
        this.Descuento = Descuento;
    }

    public double getImpuesto() {
        return Impuesto;
    }

    public void setImpuesto(double Impuesto) {
        this.Impuesto = Impuesto;
    }

    public double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(double SubTotal) {
        this.SubTotal = SubTotal;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public OrdenCompra(int OrdenID, int ClienteID, double Descuento, double Impuesto, double SubTotal, double Total, String Fecha) {
        this.OrdenID = OrdenID;
        this.ClienteID = ClienteID;
        this.Descuento = Descuento;
        this.Impuesto = Impuesto;
        this.SubTotal = SubTotal;
        this.Total = Total;
        this.Fecha = Fecha;
    }
    
    private int OrdenID;
    private int ClienteID ;
    private double Descuento ;
    private double Impuesto ;
    private double SubTotal ;
    private double Total ;
    private String Fecha;
    
}
