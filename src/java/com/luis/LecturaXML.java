/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luis;

import java.io.File;
import java.io.IOException;
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

    public List enviar() throws ParserConfigurationException, SAXException {
        List arrayOC = new ArrayList<>();
        String idProducto = "";
        String nombreProducto = "";
        String cantidadProducto = "";
        String precioProducto = "";
        String clienteID = "";
        String Correo = "";
        String Nombre = "";
        String Descuento = "";
        String Impuesto = "";
        String SubTotal = "";
        String Total = "";
        String Fecha = "";

        try {

            File file = new File("/Users/luisr/Documents/NetBeansProjects/WebApplication2/Documentos/XML recibido/ordencompra.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            document.getDocumentElement().normalize();
            System.out.println("Root Element :" + document.getDocumentElement().getNodeName());
            NodeList nListProducto = document.getElementsByTagName("producto");
            NodeList nCliente = document.getElementsByTagName("cliente");
            System.out.println("----------------------------");
            for (int temp = 0; temp < nListProducto.getLength(); temp++) {
                Node nNode = nListProducto.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    idProducto = eElement.getElementsByTagName("id").item(0).getTextContent();
                    nombreProducto = eElement.getElementsByTagName("nombre").item(0).getTextContent();
                    cantidadProducto = eElement.getElementsByTagName("cantidad").item(0).getTextContent();
                    precioProducto = eElement.getElementsByTagName("precio").item(0).getTextContent();
                    Productosxml producto = new Productosxml(Integer.parseInt(idProducto), nombreProducto, Integer.parseInt(cantidadProducto), Double.parseDouble(precioProducto));
                    arrayOC.add(producto);
                }

            }
            for (int temp = 0; temp < nCliente.getLength(); temp++) {
                Node nNode = nCliente.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    clienteID = eElement.getElementsByTagName("cedula").item(0).getTextContent();
                    Nombre = eElement.getElementsByTagName("autor").item(0).getTextContent();
                    Correo = eElement.getElementsByTagName("email").item(0).getTextContent();
                    Descuento = eElement.getElementsByTagName("descuento").item(0).getTextContent();
                    Impuesto = eElement.getElementsByTagName("impuesto").item(0).getTextContent();
                    SubTotal = eElement.getElementsByTagName("subtotal").item(0).getTextContent();
                    Total = eElement.getElementsByTagName("total").item(0).getTextContent();
                    Fecha = eElement.getElementsByTagName("fecha").item(0).getTextContent();
                    Cliente cliente = new Cliente(Integer.parseInt(clienteID), Nombre, Correo);
                    arrayOC.add(cliente);
                    OCXML oc = new OCXML(Double.parseDouble(Descuento), Double.parseDouble(Impuesto), Double.parseDouble(SubTotal), Double.parseDouble(Total), Fecha);
                    arrayOC.add(oc);
                }
            }

        } catch (IOException e) {
            System.out.println(e);
        }
        return arrayOC;
    }

}
