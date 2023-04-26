/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author samue
 */
public class LeerXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         try {
            File file = new File("./xml/facturas.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Factura.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Factura facturas = (Factura) jaxbUnmarshaller.unmarshal(file);
            //- He tenido que crear el metodo getFacturas con una lista en la clase Factura
            
            for (Factura factura : facturas.getFacturas()) {
                System.out.println("----------------------------------------");
                System.out.println("Código único: " + factura.getCodigoUnico());
                System.out.println("Fecha de emisión: " + factura.getFechaEmision());
                System.out.println("Descripción: " + factura.getDescripcion());
                System.out.println("Importe total: " + factura.getImporte());
                System.out.println("----------------------------------------");
            }
        } catch (JAXBException e) {
            System.err.println("Error al leer el archivo XML: " + e.getMessage());
        }
    }
    
    
}  
    