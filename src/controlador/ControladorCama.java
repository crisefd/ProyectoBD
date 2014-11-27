/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.DaoCama;
import logica.Cama;

/**
 *
 * @author fabianact
 */
public class ControladorCama{

    DaoCama daoCama;
    
    
    public ControladorCama(){
        daoCama=new DaoCama();
    }
    
    
    public int  insertarCama(String id_cama, String id_area_fk,String descripcion, String estado){
        Cama c = new Cama(id_cama,id_area_fk, descripcion, estado);        

        
        //Se llama al dao para guardar
        System.out.println("Se va a insertar un Empleado");
        
        int result =daoCama.guardarCama(c);

        System.out.println("Se  insertó  un  nuevo programa");
        
        return result;

    }//end

    public Cama consultarArea(String id_cama){

        Cama c = new Cama();
        
         System.out.println("Se va a consultar un cama");

        c = daoCama.consultarCama(id_cama);
      
       return c;
    }

    public void cerrarConexionBD(){
        daoCama.cerrarConexionBD();
    }

}