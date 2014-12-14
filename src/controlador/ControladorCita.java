/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import accesoDatos.DaoCita;
import java.util.ArrayList;
import logica.Cita;

/**
 *
 * @author daniel
 */
public class ControladorCita{

    DaoCita daoCita;
    
    
    public ControladorCita(){
        daoCita=new DaoCita();
    }
    
    
    public int  insertarCita(String tiempo, String fecha, String tipo, String id_medico, String id_paciente){
        Cita c = new Cita(tiempo,fecha,tipo,id_medico, id_paciente);        

       
        
        int result =daoCita.guardarCita(c);
        
        return result;

    }//end

    public Cita consultarCita(String id_cita){

        Cita c = new Cita();        
        c = daoCita.consultarCita(id_cita);
      
       return c;
    }
    
    public ArrayList<Cita> consultarCitas(){
        Cita c = new Cita();
        ArrayList<Cita> lista = daoCita.consultarCitas();
      
       return lista;
    }
    
    
    
    

    public void cerrarConexionBD(){
        daoCita.cerrarConexionBD();
    }
    
    
}//fin clase
