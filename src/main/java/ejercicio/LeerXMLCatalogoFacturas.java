/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author pablo
 */
public class LeerXMLCatalogoFacturas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws JAXBException, 
            FileNotFoundException  {
        // TODO code application logic here
        
         // Crea el contexto JAXB 
        JAXBContext contexto = JAXBContext.newInstance(CatalogoFacturas.class);
        // Crea el objeto Unmarshaller
        Unmarshaller um = contexto.createUnmarshaller();

        // Llama al método de unmarshalling
        CatalogoFacturas catalogo = (CatalogoFacturas) um.unmarshal(new File("catalogo.xml"));

        ArrayList<Factura> listaMuebles = catalogo.getListaFactura();

        listaMuebles.forEach(System.out::println);
    }
    
}
