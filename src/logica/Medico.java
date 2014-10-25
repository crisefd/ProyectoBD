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
public class Medico extends Empleado {
    private String especializacion, numLicencia, universidad;

    public Medico(String id_persona, String nombre, String direccion, 
            String telefono, String id_area, String cargo, String email,
            double salario, String especializacion, String numLicencia, String universidad) {
        super(id_persona, nombre, direccion, telefono, id_area, cargo, email, salario);
        this.especializacion = especializacion;
        this.numLicencia = numLicencia;
        this.universidad = universidad;
    }

    /**
     * @return the especializacion
     */
    public String obtEspecializacion() {
        return especializacion;
    }

    /**
     * @return the numLicencia
     */
    public String obtNumLicencia() {
        return numLicencia;
    }

    /**
     * @return the universidad
     */
    public String obtUniversidad() {
        return universidad;
    }
    
}
