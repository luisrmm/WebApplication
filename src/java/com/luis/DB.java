/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
        this.password = "admin";
        this.hostname = "localhost";
        this.database = "facturaweb";
        this.driver = "com.mysql.jdbc.Driver";
        this.url = "jdbc:mysql://localhost:3306/facturaweb?allowPublicKeyRetrieval=true&useSSL=false";
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
                int Precio = rs.getInt("Precio");
                // print the results
                Producto p = new Producto(ProductoID, Nombre, Precio, 0);
                arrayProducto.add(p);
            }
            this.getConn().close();

        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayProducto;
    }

    public void insertdata() {
        LecturaXML x = new LecturaXML();
        ArrayList<Producto> arrayProd = new ArrayList<>();
        ArrayList<Cliente> arrayClient = new ArrayList<>();

        try {
            Factura factura_xml = x.prepararXMLaDB(); // Retorna la informacion de la factura..

            if (factura_xml != null) {
                int ClienteID = factura_xml.getClienteID();
                String Fecha = factura_xml.getFecha();

                System.out.println(">>>>>>> Fecha" + Fecha + "<>" + Fecha.length());

                String insertTableSQL = "INSERT INTO ordencompra"
                        + "(ClienteID, Fecha) VALUES"
                        + "(?, ? )";

                PreparedStatement stmt = this.getConn().prepareStatement(insertTableSQL, Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(1, ClienteID);
                stmt.setString(2, Fecha);

                int retorno = stmt.executeUpdate();
                if (retorno > 0) {
                    System.out.println("Insertado correctamente");

                    ResultSet rs = stmt.getGeneratedKeys();
                    int generatedKey = 0;
                    if (rs.next()) {
                        generatedKey = rs.getInt(1);
                        String insertTableSQL2 = "INSERT INTO productoorden"
                                + "(OrdenID, ProductoID, Cantidad, Precio) VALUES ";

                        for (Producto p : factura_xml.getProductos()) {
                            insertTableSQL2 += "(" + generatedKey + ", " + p.getProductoID() + ", " + p.getCantidad() + ", " + p.getPrecio() + "), ";
                        }
                        insertTableSQL2 = insertTableSQL2.substring(0, insertTableSQL2.length() - 2);
                        System.out.println("insertTableSQL2 > " + insertTableSQL2);

                        PreparedStatement stmt2 = this.getConn().prepareStatement(insertTableSQL2);

                        int retorno2 = stmt2.executeUpdate();
                        if (retorno2 > 0) {
                            System.out.println("EXITO : ");
                        } else {
                            System.out.println("ERROR : ");
                        }
                    }

                    System.out.println("insertTableSQL : ");
                    System.out.println(insertTableSQL);
                    
                    Thread.sleep(5000);
                    // TODO Crear nuevo query para ProductoOrden
                } else {
                    System.out.println("Formato de XML incorrecto...!");
                }
            }

        } catch (SQLException sqle) {
            System.out.println("SQLState: "
                    + sqle.getSQLState());
            System.out.println("SQLErrorCode: "
                    + sqle.getErrorCode());
            sqle.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
