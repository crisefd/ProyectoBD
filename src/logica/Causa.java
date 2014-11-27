/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author crisefd
 */
public class Causa {
    private String id_causa, nombre, descripcion, 
            tipo_cita, id_medico_cita, id_paciente_cita;
    private String hora_cita;
    private String fecha_cita;

    /**
     * @return the id_causa
     */
    public String getId_causa() {
        return id_causa;
    }

    /**
     * @param id_causa the id_causa to set
     */
    public void setId_causa(String id_causa) {
        this.id_causa = id_causa;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the tipo_cita
     */
    public String getTipo_cita() {
        return tipo_cita;
    }

    /**
     * @param tipo_cita the tipo_cita to set
     */
    public void setTipo_cita(String tipo_cita) {
        this.tipo_cita = tipo_cita;
    }

    /**
     * @return the id_medico_cita
     */
    public String getId_medico_cita() {
        return id_medico_cita;
    }

    /**
     * @param id_medico_cita the id_medico_cita to set
     */
    public void setId_medico_cita(String id_medico_cita) {
        this.id_medico_cita = id_medico_cita;
    }

    /**
     * @return the id_paciente_cita
     */
    public String getId_paciente_cita() {
        return id_paciente_cita;
    }

    /**
     * @param id_paciente_cita the id_paciente_cita to set
     */
    public void setId_paciente_cita(String id_paciente_cita) {
        this.id_paciente_cita = id_paciente_cita;
    }

    /**
     * @return the hora_cita
     */
    public String getHora_cita() {
        return hora_cita;
    }

    /**
     * @param hora_cita the hora_cita to set
     */
    public void setHora_cita(String hora_cita) {
        this.hora_cita = hora_cita;
    }

    /**
     * @return the fecha_cita
     */
    public String getFecha_cita() {
        return fecha_cita;
    }

    /**
     * @param fecha_cita the fecha_cita to set
     */
    public void setFecha_cita(String fecha_cita) {
        this.fecha_cita = fecha_cita;
    }
    
    
    
}
