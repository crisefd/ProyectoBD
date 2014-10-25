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
public class Area {
    private String id_area="", nombre="", descripcion="";
    
    public Area(String id_area, String nombre, String descripcion){
        this.id_area=id_area;
        this.nombre= nombre;
        this.descripcion= descripcion;
    }
    
    public String obtIdArea(){
        return id_area;
    }
    public String obtNombre(){
        return nombre;
    }
    public String descripcion(){
        return descripcion;
    }
}

