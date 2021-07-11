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
public class OCXML {


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

    public OCXML ( double Descuento, double Impuesto, double SubTotal, double Total, String Fecha) {
      
        this.Descuento = Descuento;
        this.Impuesto = Impuesto;
        this.SubTotal = SubTotal;
        this.Total = Total;
        this.Fecha = Fecha;
    }

    
       
        private double Descuento;
        private double Impuesto;
        private double SubTotal;
        private double Total;
        private String Fecha;


}
