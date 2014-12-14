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
public class Cita {
    private String tiempo;
    private String tipo, id_medico, id_paciente;
    private String fecha;
    private double costo=2500;
    
    public Cita(String tiempo, String fecha, String tipo, String id_medico, String id_paciente){
       this.tiempo = tiempo;
       this.fecha = fecha;
       this.tipo = tipo;
       this.id_medico = id_medico;
       this.id_paciente = id_paciente;
        
    }
    
    public Cita(){
        
    }

    /**
     * @return the time
     */
    public String obtTiempo() {
        return tiempo;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @return the id_medico
     */
    public String getId_medico() {
        return id_medico;
    }

    /**
     * @return the id_paciente
     */
    public String getId_paciente() {
        return id_paciente;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }
    public Double getCosto() {
        return costo;
    }

    /**
     * @param tiempo the tiempo to set
     */
    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @param id_medico the id_medico to set
     */
    public void setId_medico(String id_medico) {
        this.id_medico = id_medico;
    }

    /**
     * @param id_paciente the id_paciente to set
     */
    public void setId_paciente(String id_paciente) {
        this.id_paciente = id_paciente;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    
    
}
