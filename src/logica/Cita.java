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
    private Date tiempo;
    private String tipo, id_medico, id_paciente;
    private Calendar fecha;
    
    public Cita(Date tiempo, Calendar fecha, String tipo, String id_medico, String id_paciente){
       this.tiempo = tiempo;
       this.fecha = fecha;
       this.tipo = tipo;
       this.id_medico = id_medico;
       this.id_paciente = id_paciente;
        
    }

    /**
     * @return the time
     */
    public Date obtTiempo() {
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
    public Calendar getFecha() {
        return fecha;
    }
    
    
    
}
