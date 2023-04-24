/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.text.Document;
import javax.xml.bind.Element;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;

/**
 *
 * @author pablo
 */
public class GenerarFicheros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Creo una lista para guardar las facturas
        // No olvidar nunca poner entre los diamantes las clase, porque si no pondra object
        ArrayList<Factura> listaFacturas = generarListaFacturas(50);
        
        
        
        
         System.out.println("Lista de las facturas");
        
        for(Factura factura : listaFacturas){
            
            System.out.println(factura);
            
        }
        
        //Metodos para crear las carpetas del ejercicio para guardarlos los csv y xml
        
        
         // Directorio raíz del proyecto
        String directorioRaiz = System.getProperty("user.dir");

        // Rutas de las carpetas csv y xml
        String rutaCsv = directorioRaiz + "/csv";
        String rutaXml = directorioRaiz + "/xml";

        // Crear la carpeta csv si no existe
        File carpetaCsv = new File(rutaCsv);
        if (!carpetaCsv.exists()) {
            carpetaCsv.mkdir();
            System.out.println("La carpeta csv ha sido creada.");
        }

        // Crear la carpeta xml si no existe
        File carpetaXml = new File(rutaXml);
        if (!carpetaXml.exists()) {
            carpetaXml.mkdir();
            System.out.println("La carpeta xml ha sido creada.");
        }
        
        
        //Guardamos las listas en las capetas...
        
        // Ruta del archivo facturas.csv
        String rutaArchivoCsv = "./csv/facturas.csv";

        try {
            // Crear un objeto FileWriter para escribir en el archivo
            FileWriter writer = new FileWriter(rutaArchivoCsv);

            // Escribir la cabecera del archivo
            writer.write("CodigoUnico;FechaEmision;Descripcion;TotalImporteFactura\n");

            // Escribir los datos de cada factura
            for (Factura factura : listaFacturas) {
                
                writer.write(factura.getCodigoUnico() + ";" +
                             factura.getFechaEmision() + ";" +
                             factura.getDescripcion() + ";" +
                             factura.getImporte() + "\n");
            }

            // Cerrar el objeto FileWriter
            writer.close();

            System.out.println("Los datos de las facturas han sido guardados correctamente en el archivo " + rutaArchivoCsv);
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar los datos de las facturas en el archivo " + rutaArchivoCsv);
        }
        
        //-Guardamos los XML.....
        
          // Ruta del archivo facturas.xml
        String rutaArchivoXml = "./xml/facturas.xml";
           
       
      
        
    }
    
    
    // Genera una lista de numMuebles muebles
    public static ArrayList<Factura> generarListaFacturas(int numFacturas) {

        ArrayList<Factura> lista = new ArrayList<>();

        for (int i = 10; i <= numFacturas; i++) {
             Factura factura = new Factura();
             lista.add(factura);
        }

        return lista;
    }
    
    
    
}
