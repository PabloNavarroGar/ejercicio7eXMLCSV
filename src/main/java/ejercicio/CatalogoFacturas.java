/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pablo
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CatalogoFacturas {
    
     private ArrayList<Factura> listaFacturas;

    private String descripcion;

    public CatalogoFacturas(ArrayList<Factura> listaFactura) {
        this.listaFacturas = listaFactura;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Factura> getListaFactura() {
        return listaFacturas;
    }

    public ArrayList<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(ArrayList<Factura> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }
    
    
}
