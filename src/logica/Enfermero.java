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
public class Enfermero extends Empleado{
    private int anosExp;
    private String []habilidades;
    private String idEnfermero;

    public Enfermero(String id_persona, String nombre, String direccion, 
                    String telefono, String id_area, String cargo, String email, 
                    double salario, int anos_exp, String[]habilidades) {
        super(id_persona, nombre, direccion, telefono, id_area, cargo, email, salario);
        this.anosExp = anos_exp;
        this.habilidades = habilidades;
    }
    
    public Enfermero(){
        
    }

    /**
     * @return the anos_exp
     */
    public int obtAnos_exp() {
        return anosExp;
    }

    /**
     * @return the habilidades
     */
    public String[] obtHabilidades() {
        return habilidades;
    }

    /**
     * @param anosExp the anosExp to set
     */
    public void setAnosExp(int anosExp) {
        this.anosExp = anosExp;
    }

    /**
     * @param habilidades the habilidades to set
     */
    public void setHabilidades(String[] habilidades) {
        this.habilidades = habilidades;
    }

    /**
     * @return the idEnfermero
     */
    public String getIdEnfermero() {
        return idEnfermero;
    }

    /**
     * @param idEnfermero the idEnfermero to set
     */
    public void setIdEnfermero(String idEnfermero) {
        this.idEnfermero = idEnfermero;
    }
    
}
