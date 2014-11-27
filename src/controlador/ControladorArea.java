/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import accesoDatos.DaoArea;
import accesoDatos.DaoEmpleado;
import java.util.Vector;
import logica.Area;

/**
 *
 * @author daniel
 */
public class ControladorArea{

    DaoArea daoArea;
    
    
    public ControladorArea(){
        daoArea=new DaoArea();
    }
    
    
    public int  insertarArea(String id_area, String nombre,String descripcion){
        Area a = new Area(id_area,nombre, descripcion);        

        
        //Se llama al dao para guardar
        System.out.println("Se va a insertar un Empleado");
        
        int result =daoArea.guardarArea(a);

        System.out.println("Se  insertó  un  nuevo programa");
        
        return result;

    }//end

    public Area consultarArea(String id_area){

        Area a = new Area();
        
         System.out.println("Se va a consultar un empleado");

        a = daoArea.consultarArea(id_area);
      
       return a;
    }

    public void cerrarConexionBD(){
        daoArea.cerrarConexionBD();
    }

}//fin clase
