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
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {
 
    Connection conn = null;
    
    public String driver = "com.mysql.jdbc.Driver";
    // Nombre de la base de datos
    public String database = "ocweb";

    // Host
    public String hostname = "localhost";

    // Puerto
    public String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?allowPublicKeyRetrieval=true&useSSL=false";

    // Nombre de usuario
    public String username = "root";

    // Clave de usuario
    public String password = "admin";

    public Connection conectarMySQL() {
       

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException |SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }

        return conn;
    }
    
    public void getProductos(){
    
        try {
            // Instancias la clase que hemos creado anteriormente
            DB SQL = new DB();
            // Llamas al método que tiene la clase y te devuelve una conexión
            conn = SQL.conectarMySQL();
            // Query que usarás para hacer lo que necesites
            String query =  "Select * FROM producto";
            // PreparedStatement
            
          
            // create the java statement
            Statement stmt = conn.createStatement();

            // execute the query, and get a java resultset
             ResultSet rs = stmt.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
              int ProductoID = rs.getInt("ProductoID");
              String Nombre = rs.getString("Nombre");
              double PrecioUnitario = rs.getDouble("PrecioUnitario");
              // print the results
              //System.out.format("%s, %s, %s\n", productoid, nombre, precio_unitario);
            }
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
