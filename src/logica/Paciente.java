/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author crisefd
 */
public class Paciente extends Persona {
    private String num_seg_soc, actEconomica, id_cama;
    private String fechaNaci, fechaAsigCama;
    

    public Paciente(String id_persona, String nombre, String direccion, 
                     String telefono, String num_seg_soc, String actEconomica,
                     String id_cama, String fechaNaci, String fechaAsigCama) {
        super(id_persona, nombre, direccion, telefono);
        this.num_seg_soc = num_seg_soc;
        this.actEconomica= actEconomica;
        this.id_cama = id_cama;
        this.fechaNaci= fechaNaci;
        this.fechaAsigCama= fechaAsigCama;
    }   

    public Paciente(){
        
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
    public String obtFechaNaci() {
        return fechaNaci;
    }

    /**
     * @return the fechaAsigCama
     */
    public String obtFechaAsigCama() {
        return fechaAsigCama;
    }

    /**
     * @param num_seg_soc the num_seg_soc to set
     */
    public void setNum_seg_soc(String num_seg_soc) {
        this.num_seg_soc = num_seg_soc;
    }

    /**
     * @param actEconomica the actEconomica to set
     */
    public void setActEconomica(String actEconomica) {
        this.actEconomica = actEconomica;
    }

    /**
     * @param id_cama the id_cama to set
     */
    public void setId_cama(String id_cama) {
        this.id_cama = id_cama;
    }

    /**
     * @param fechaNaci the fechaNaci to set
     */
    public void setFechaNaci(String fechaNaci) {
        this.fechaNaci = fechaNaci;
    }

    /**
     * @param fechaAsigCama the fechaAsigCama to set
     */
    public void setFechaAsigCama(String fechaAsigCama) {
        this.fechaAsigCama = fechaAsigCama;
    }
    
    public static void main(String args[] ){
        Paciente p =new Paciente("1123054","daniel","direccion","telefono","numseg","act","12","2014-4-4","2014-4-4");
        
        System.out.println(p.obtFechaNaci());
    }
    
}
