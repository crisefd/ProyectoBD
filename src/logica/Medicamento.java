/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author crisefd
 */
public class Medicamento {
    private String id, nombre, descripcion;
    private double costo;
    
    public Medicamento(String id, String nombre, String descripcion, double costo){
        this.id= id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
    }
    
    public Medicamento(){
        
    }

    /**
     * @return the id
     */
    public String obtId() {
        return id;
    }

    /**
     * @return the nombre
     */
    public String obtNombre() {
        return nombre;
    }

    /**
     * @return the descripcion
     */
    public String obtDescripcion() {
        return descripcion;
    }

    /**
     * @return the costo
     */
    public double obtCosto() {
        return costo;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    
}
