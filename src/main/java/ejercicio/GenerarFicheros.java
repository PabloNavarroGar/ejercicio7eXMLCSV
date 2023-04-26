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
import java.util.List;
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
    public static void main(String[] args) throws JAXBException {
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
       
        
        CatalogoFacturas facturas = new CatalogoFacturas(listaFacturas);
       
        facturas.setListaFacturas(listaFacturas);
        facturas.setDescripcion("Mi catalogo");
       
        // Crea el contexto JAXB. Se encarga de definir los objetos 
        // que vamos a guardar. En nuestro caso sólo el tipo CatalogoMuebles
        JAXBContext contexto = JAXBContext.newInstance(CatalogoFacturas.class);
        
        // El contexto JAXB permite crear un objeto Marshaller, que sirve para
        // generar la estructura del fichero XML 
        // El proceso de pasar objetos Java (CatalogoMuebles) a ficheros XML 
        // se conoce como "marshalling" o "serialización"
        Marshaller serializador = contexto.createMarshaller();
        
        // Especificamos que la propiedad del formato de salida
        // del serializador sea true, lo que implica que el formato se 
        // realiza con indentación y saltos de línea
        serializador.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Llamando al método de serialización marshal (sobrecargado) se pueden
        // serializar objetos java en formato XML y volcarlos donde necesitemos:
        // consola, ficheros. El proceso consiste en que el contexto es el 
        // encargo de leer los objetos java, pasarlos al serializador y éste 
        // crear la salida de serialización
        
        // Serialización y salida por consola
        serializador.marshal(facturas, System.out);

        // Volcado al fichero xml
        serializador.marshal(facturas, new File("catalogo.xml"));
           
       
      //-hacemos la lista de la escricutra de lso csvarchivos
        escribirCsvArchivo(listaFacturas);
        
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
        
     private static final String CSV_FOLDER = "./facturascsv/";

     public static void escribirCsvArchivo(List<Factura> facturas) {
        for (Factura factura : facturas) {
            String nombreArchivo = factura.getCodigoUnico() + ".csv";
            String direccion = CSV_FOLDER + nombreArchivo;
            
            try (FileWriter writer = new FileWriter(direccion)) {
                String csv = String.join(";", factura.getCodigoUnico(), factura.getFechaEmision().toString(),
                        factura.getDescripcion(), String.valueOf(factura.getImporte()));
                writer.write(csv);
            } catch (IOException e) {
                System.err.println("Error al escribir el archivo CSV para las facturas " + factura.getCodigoUnico() + ": " + e.getMessage());
            }
        }
    }
     
     
    
}
