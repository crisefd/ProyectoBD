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
    
    
    public int  insertarEmpleado(Empleado emp){        

        
        //Se llama al dao para guardar
        System.out.println("Se va a insertar un Empleado");
        
        int result =daoEmpleado.guardarEmpleado(emp);

        System.out.println("Se  insertó  un  nuevo programa");
        
        return result;

    }//end

    public ArrayList<Empleado> consultarEmpleadoPorNombre(String nombre_persona){
        Vector v= new Vector();

        
         System.out.println("Se va a consultar un empleado");

        ArrayList<Empleado> e = daoEmpleado.consultarEmpleadoPorNombre(nombre_persona);
      
       return e;
    }
    
    public ArrayList<Empleado> consultarEmpleadoPorId(String id){
        ArrayList<Empleado> emps= daoEmpleado.consultarEmpleadosPorId(id);
        return emps;
    }
    
    public ArrayList<Empleado> consultarEmpleados(){
       // Empleado e = new Empleado();
        
         System.out.println("Se va a consultar un empleado");

        ArrayList<Empleado> lista = daoEmpleado.consultarEmpleados();
      
       return lista;
    }

    public void cerrarConexionBD(){
        daoEmpleado.cerrarConexionBD();
    }

}