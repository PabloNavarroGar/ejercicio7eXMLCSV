/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author pablo
 *
 *
 */
//-Los XML SE PONEN AQUI
// Anotación @XmlRootElement, nombre de la etiqueta XML raíz.
@XmlRootElement(name = "mueble")
// Anotación @XmlAccesorType define el elemento que usará JAXB durante el 
// procesamiento de datos (en este caso por atributo)
@XmlAccessorType(XmlAccessType.FIELD)
public class Factura {

    //Atributos
    private List<Factura> facturas;
    private int contadorInstancias = 0;
    private String codigoUnico;
    private LocalDate fechaEmision;
    private String descripcion;
     @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private double importe;

    //--El XML
    public Factura(String codigoUnico, LocalDate fechaEmision, String descripcion, double importe) {
        this.codigoUnico = codigoUnico;
        this.fechaEmision = fechaEmision;
        this.descripcion = descripcion;
        this.importe = importe;
    }

    public Factura() {
        contadorInstancias++;
        this.codigoUnico = "FACTURA" + "-" + contadorInstancias;
        this.fechaEmision = LocalDate.now();
        this.descripcion = RandomStringUtils.randomAlphabetic(10);
        this.importe = UtilidadesMetodos.numeroDecimalRandom(100, 1000);
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
    
    @Override
    public String toString() {
        return "["  + codigoUnico + ";" + fechaEmision + ";" + descripcion + ";" + importe + ']';
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    
}
