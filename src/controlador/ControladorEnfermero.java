/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.DaoEmpleado;
import accesoDatos.DaoEnfermero;
import java.util.ArrayList;
import java.util.Vector;
import logica.Empleado;
import logica.Enfermero;

/**
 *
 * @author fabianact
 */
public class ControladorEnfermero {

    DaoEnfermero daoEnfermero;
    
    public ControladorEnfermero(){
        daoEnfermero=new DaoEnfermero();
    }
    
    
    public int  insertarEnfermero(String id_persona, String nombre,String direccion, String telefono,String id_area_fk,String cargo,  String email,double salario,int anos_exp,String id_enfermero, String[] habilidades){
        Enfermero e = new Enfermero(id_persona,nombre, direccion, telefono, id_area_fk, cargo, email,salario,anos_exp, habilidades);        
        
        int result =daoEnfermero.guardarEnfermero(e);
        
        return result;

    }//end

    public Enfermero consultarEnfermero(String id_enfermero){
        Enfermero e = new Enfermero();
        

        e = daoEnfermero.consultarEnfermero(id_enfermero);
      
       return e;
    }
    
    public ArrayList<Enfermero> consultarEnfermeros(){
        Enfermero e = new Enfermero();
        
         System.out.println("Se va a consultar un empleado");

        ArrayList<Enfermero> lista = daoEnfermero.consultarEnfermero();
      
       return lista;
    }
    

    public void cerrarConexionBD(){
        daoEnfermero.cerrarConexionBD();
    }

}