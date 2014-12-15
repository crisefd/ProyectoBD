/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import accesoDatos.DaoArea;
import accesoDatos.DaoEmpleado;
import java.util.ArrayList;
import java.util.Vector;
import logica.Area;
import logica.Empleado;

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
        System.out.println("Se va a insertar un area");
        
        int result =daoArea.guardarArea(a);

        System.out.println("Se  insertó  un  nuevo area");
        
        return result;

    }//end

    public Area consultarArea(String id_area){

        Area a = new Area();        
        a = daoArea.consultarArea(id_area);
      
       return a;
    }
    
    public ArrayList<Area> consultarAreas(){
        Area a = new Area();
        ArrayList<Area> lista = daoArea.consultarAreas();
      
       return lista;
    }
    
    

    public void cerrarConexionBD(){
        daoArea.cerrarConexionBD();
    }
    
    
}//fin clase
