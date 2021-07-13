/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luis;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LecturaXML {

    public Factura prepararXMLaDB() throws ParserConfigurationException, SAXException {
        List<Producto> productos_list = new ArrayList<>();
        String idProducto = "";
        String cantidadProducto = "";
        String precioProducto = "";

        String clienteID = "";
        String Correo = "";
        String Nombre = "";
        String Fecha = "";

        try {

            String path_ = "/Users/luisr/Documents/NetBeansProjects/WebApplication2/Documentos/XML recibido/ordencompra.xml";

            Path path = Paths.get(path_);

            if (Files.exists(path)) {
                File file = new File(path_);

                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document document = db.parse(file);
                document.getDocumentElement().normalize();
                System.out.println("Root Element :" + document.getDocumentElement().getNodeName());
                NodeList nListProducto = document.getElementsByTagName("producto");
                NodeList nCliente = document.getElementsByTagName("general");
                System.out.println("----------------------------");

                for (int temp = 0; temp < nCliente.getLength(); temp++) {
                    Node nNode = nCliente.item(temp);
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        clienteID = eElement.getElementsByTagName("cedula").item(0).getTextContent();
                        Nombre = eElement.getElementsByTagName("autor").item(0).getTextContent();
                        Correo = eElement.getElementsByTagName("email").item(0).getTextContent();
                        Fecha = eElement.getElementsByTagName("fecha").item(0).getTextContent();
                    }
                }

                for (int temp = 0; temp < nListProducto.getLength(); temp++) {
                    Node nNode = nListProducto.item(temp);
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        idProducto = eElement.getElementsByTagName("id").item(0).getTextContent();
                        cantidadProducto = eElement.getElementsByTagName("cantidad").item(0).getTextContent();
                        precioProducto = eElement.getElementsByTagName("precio").item(0).getTextContent();
                        Producto producto = new Producto(Integer.parseInt(idProducto), " ", Integer.parseInt(precioProducto), Integer.parseInt(cantidadProducto));
                        productos_list.add(producto);
                    }
                }

                Factura fact = new Factura(Integer.parseInt(clienteID), Correo, Nombre, Fecha, productos_list);

                boolean estatus = file.delete();
                if (!estatus) {

                    System.out.println("Error no se ha podido eliminar el  archivo");

                } else {

                    System.out.println("Se ha eliminado el archivo exitosamente");

                }
                return fact;

            }

            if (Files.notExists(path)) {
                System.out.println("No hace nada, no files");
            }

        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

}
