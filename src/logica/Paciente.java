/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Calendar;

/**
 *
 * @author crisefd
 */
public class Paciente extends Persona {
    private String num_seg_soc, actEconomica, id_cama;
    private Calendar fechaNaci, fechaAsigCama;
    

    public Paciente(String id_persona, String nombre, String direccion, 
                     String telefono, String num_seg_soc, String actEconomica,
                     String id_cama, Calendar fechaNaci, Calendar fechaAsigCama) {
        super(id_persona, nombre, direccion, telefono);
        this.num_seg_soc = num_seg_soc;
        this.actEconomica= actEconomica;
        this.id_cama = id_cama;
        this.fechaNaci= fechaNaci;
        this.fechaAsigCama= fechaAsigCama;
    }   

    /**
     * @return the num_seg_soc
     */
    public String obtyNum_seg_soc() {
        return num_seg_soc;
    }

    /**
     * @return the actEconomica
     */
    public String obtActEconomica() {
        return actEconomica;
    }

    /**
     * @return the id_cama
     */
    public String obtId_cama() {
        return id_cama;
    }

    /**
     * @return the fechaNaci
     */
    public Calendar obtFechaNaci() {
        return fechaNaci;
    }

    /**
     * @return the fechaAsigCama
     */
    public Calendar obtFechaAsigCama() {
        return fechaAsigCama;
    }
    
}
