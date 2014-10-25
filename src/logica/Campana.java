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
public class Campana {
    private String id, nombre, objetivo, id_medico;
    
    public Campana(String id, String nombre, String objetivo, String id_medico){
        this.id = id;
        this.nombre = nombre;
        this.objetivo = objetivo;
        this.id_medico = id_medico;
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
     * @return the objetivo
     */
    public String obtObjetivo() {
        return objetivo;
    }

    /**
     * @return the id_medico
     */
    public String obtId_medico() {
        return id_medico;
    }
    
    
    
}
