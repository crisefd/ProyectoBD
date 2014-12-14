/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.DaoCama;
import java.util.ArrayList;
import logica.Area;
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

       
        
        int result =daoCama.guardarCama(c);

        
        return result;

    }//end

    public ArrayList<Cama> consultarCama(String id_cama){
        
        ArrayList<Cama> cama= daoCama.consultarCamasPorID(id_cama);
      
       return cama;
    }
     public ArrayList<Cama> consultarCamaArea(String area_cama){

        
        ArrayList<Cama> cama= daoCama.consultarCamasPorID(area_cama);
      
       return cama;
    }
    
    
    public ArrayList<Cama> consultarCamas(){
        Area a = new Area();
        ArrayList<Cama> lista = daoCama.consultarCamas();
      
       return lista;
    }

    public void cerrarConexionBD(){
        daoCama.cerrarConexionBD();
    }

    
}