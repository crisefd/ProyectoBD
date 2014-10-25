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
public class Persona {
    
    private String id_persona, nombre, direccion, telefono;
    
    /**
     *
     * @param id_persona
     * @param nombre
     * @param direccion
     * @param telefono
     */
    public Persona(String id_persona, String nombre, String direccion, String telefono){
        this.id_persona = id_persona;
        this.nombre= nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        
    }
    
    /**
     *
     * @return
     */
    public String obtIdPersona(){
        return id_persona;
    }

    /**
     *
     * @return
     */
    public String obtNombre(){
        return nombre;
    }

    /**
     *
     * @return
     */
    public String obtDireccion(){
        return direccion;
    }

    /**
     *
     * @return
     */
    public String obtTelefono(){
        return telefono;
    }
}
