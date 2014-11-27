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
public class HistoriaClinica {
    private String id, id_paciente;
    private Calendar fechaApertura;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the id_paciente
     */
    public String getId_paciente() {
        return id_paciente;
    }

    /**
     * @param id_paciente the id_paciente to set
     */
    public void setId_paciente(String id_paciente) {
        this.id_paciente = id_paciente;
    }

    /**
     * @return the fechaApertura
     */
    public Calendar getFechaApertura() {
        return fechaApertura;
    }

    /**
     * @param fechaApertura the fechaApertura to set
     */
    public void setFechaApertura(Calendar fechaApertura) {
        this.fechaApertura = fechaApertura;
    }
    
}
