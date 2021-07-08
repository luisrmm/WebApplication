/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {

    public DB() {
        this.conn = null;
        this.port = "3306";
        this.username = "root";
        this.database = "ocweb";
        this.password = "admin";
        this.hostname = "localhost";
        this.driver = "com.mysql.jdbc.Driver";
        this.url = "jdbc:mysql://localhost:3306/ocweb?allowPublicKeyRetrieval=true&useSSL=false";
    }

    private Connection conn;

    private final String driver;

    // Nombre de la base de datos
    private final String database;

    // Host
    private final String hostname;

    // Puerto
    private final String port;

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    private final String url;

    // Nombre de usuario
    private final String username;

    // Clave de usuario
    private final String password;
    
     public Connection getConn() {
        return conn;
    }

    public void setConn() {
        try {
            Class.forName(driver);
            this.conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public List<Producto> getProductos() {

         List<Producto> arrayProducto = new ArrayList<>();
        
        try {
            // Instancias la clase que hemos creado anteriormente
            //DB SQL = new DB();
            // Llamas al método que tiene la clase y te devuelve una conexión
           
            // Query que usarás para hacer lo que necesites
            String query = "Select * FROM producto";
            // PreparedStatement

            // create the java statement
            Statement stmt = this.getConn().createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = stmt.executeQuery(query);
            
           
            // iterate through the java resultset
            while (rs.next()) {
                int ProductoID = rs.getInt("ProductoID");
                String Nombre = rs.getString("Nombre");
                double PrecioUnitario = rs.getDouble("PrecioUnitario");
                // print the results
                System.out.format("%s, %s, %s\n", ProductoID, Nombre, PrecioUnitario);
                Producto p = new Producto(ProductoID, Nombre, PrecioUnitario);
                arrayProducto.add(p);
            }
            this.getConn().close();

        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Print in get producto"); 
        System.out.println(arrayProducto.size()); 
        return arrayProducto;
    }
}
