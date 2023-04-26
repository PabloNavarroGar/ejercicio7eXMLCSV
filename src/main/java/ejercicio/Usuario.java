/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author samue
 */
public class Usuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
           // Obtener la lista de archivos CSV de la carpeta facturascsv
        File carpeta = new File("./facturascsv");
        File[] archivosCSV = carpeta.listFiles((dir, name) -> name.toLowerCase().endsWith(".csv"));

        // Mostrar los nombres de los archivos al usuario
        System.out.println("Facturas disponibles:");
        for (File archivo : archivosCSV) {
            System.out.println("- " + archivo.getName().replace(".csv", ""));
        }

        // Pedir al usuario el nombre de la factura a leer
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre de la factura a leer: ");
        String nombreFactura = scanner.nextLine().trim() + ".csv";

        // Buscar el archivo de la factura seleccionada y leer su contenido
        File archivoFactura = null;
        for (File archivo : archivosCSV) {
            if (archivo.getName().equalsIgnoreCase(nombreFactura)) {
                archivoFactura = archivo;
                break;
            }
        }

        if (archivoFactura == null) {
            System.out.println("La factura seleccionada no existe.");
        } else {
            try {
                List<String> lineas = Files.readAllLines(archivoFactura.toPath());

                // Crear el objeto factura con los datos leídos del archivo
                String[] campos = lineas.get(0).split(";");
                Factura factura = new Factura(campos[0], LocalDate.parse(campos[1]), campos[2], Double.parseDouble(campos[3]));

                // Mostrar la factura por pantalla
                System.out.println("Factura leída:");
                System.out.println(factura);

                // Borrar el archivo de la factura leída
                archivoFactura.delete();
                System.out.println("Archivo de factura borrado.");

                // Mostrar los archivos restantes en la carpeta
                archivosCSV = carpeta.listFiles((dir, name) -> name.toLowerCase().endsWith(".csv"));
                System.out.println("Facturas restantes:");
                if (archivosCSV.length == 0) {
                    System.out.println("- No hay facturas en la carpeta.");
                } else {
                    for (File archivo : archivosCSV) {
                        System.out.println("- " + archivo.getName().replace(".csv", ""));
                    }
                }

            } catch (IOException e) {
                System.out.println("Error al leer el archivo de factura.");
            } catch (NumberFormatException e) {
                System.out.println("Error al convertir el importe de la factura a double.");
            }
        }
    
    }
    
}
