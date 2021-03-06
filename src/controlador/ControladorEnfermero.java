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
    
    
    public int  insertarEnfermero(Enfermero enf){
       // Enfermero e = new Enfermero(id_persona,nombre, direccion, telefono, id_area_fk, cargo, email,salario,anos_exp, habilidades);        
        enf.setPerfilSeguridad("3");
        int result =daoEnfermero.guardarEnfermero(enf);
        
        return result;

    }//end
    
   

    public Enfermero consultarEnfermero(String id_enfermero){
        Enfermero e = new Enfermero();
        

        e = daoEnfermero.consultarEnfermero(id_enfermero);
      
       return e;
    }
    
    public ArrayList<Enfermero> consultarEnfermeros(){
        Enfermero e = new Enfermero();
        

        ArrayList<Enfermero> lista = daoEnfermero.consultarEnfermeros();
      
       return lista;
    }
    

    public void cerrarConexionBD(){
        daoEnfermero.cerrarConexionBD();
    }

    
    
}