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
public class Cama {
    
    private String id_cama, descripcion, estado, id_area;
    
    public Cama(String id_cama, String id_area, String descripcion, String estado){
        this.id_cama= id_cama;
        this.estado= estado;
        this.descripcion = descripcion;
        this.id_area = id_area;
        
    }
    
    public String obtIdCama(){
        return id_cama;
    }
    public String obtDescripcion(){
        return descripcion;
    }
    public String obtEstado(){
        return estado;
    }
    public String obtIdArea(){
        return id_area;
    }
    
}
