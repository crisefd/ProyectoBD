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
public class Empleado extends Persona {
    private String cargo, email, id_area;
    private double salario;

    public Empleado(String id_persona, String nombre, String direccion, String telefono,String id_area,String cargo,  String email, double salario) {
        super(id_persona, nombre, direccion, telefono);
        this.cargo = cargo;
        this.email = email;
        this.salario = salario;
        this.id_area = id_area;
    }
    
    public String obtCargo(){
        return cargo;
    }
    public String obtEmail(){
        return email;
    }
    public double obtSalario(){
        return salario;
    }
    public String obtIdArea(){
        return id_area;
    }
    
}