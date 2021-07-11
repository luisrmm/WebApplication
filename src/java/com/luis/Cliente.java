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
public class Cliente {

    public int getClienteID() {
        return ClienteID;
    }

    public void setClienteID(int ClienteID) {
        this.ClienteID = ClienteID;
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

  

    public Cliente(int ClienteID, String Nombre, String Correo) {
        this.ClienteID = ClienteID;
        this.Nombre = Nombre;
        this.Correo = Correo;
    }
    
   private int ClienteID;
   private String Nombre;
   private String Correo; 
  
}
