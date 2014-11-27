/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.DaoEmpleado;
import java.util.ArrayList;
import java.util.Vector;
import logica.Empleado;

/**
 *
 * @author fabianact
 */
public class ControladorEmpleado {

    DaoEmpleado daoEmpleado;
    
    public ControladorEmpleado(){
        daoEmpleado=new DaoEmpleado();
    }
    
    
    public int  insertarEmpleado(String id_persona, String nombre, String direccion, String telefono,String id_area,String cargo,  String email, double salario){
        Empleado e = new Empleado(id_persona,nombre, direccion, telefono, id_area, cargo, email, salario);        

        
        //Se llama al dao para guardar
        System.out.println("Se va a insertar un Empleado");
        
        int result =daoEmpleado.guardarEmpleado(e);

        System.out.println("Se  insertó  un  nuevo programa");
        
        return result;

    }//end

    public Empleado consultarEmpleado(String id_persona){
        Vector v= new Vector();

        Empleado e = new Empleado();
        
         System.out.println("Se va a consultar un empleado");

        e = daoEmpleado.consultarEmpleado(id_persona);
      
       return e;
    }
    
    public ArrayList<Empleado> consultarEmpleados(){
        Empleado e = new Empleado();
        
         System.out.println("Se va a consultar un empleado");

        ArrayList<Empleado> lista = daoEmpleado.consultarEmpleados();
      
       return lista;
    }

    public void cerrarConexionBD(){
        daoEmpleado.cerrarConexionBD();
    }

}