/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.DaoPaciente;
import java.util.Vector;
import logica.Empleado;
import logica.Paciente;

/**
 *
 * @author fabianact
 */
public class ControladorPaciente {

    DaoPaciente daoPaciente;
    
    public ControladorPaciente(){
        daoPaciente=new DaoPaciente();
    }
    
    
    public int  guardarPaciente(String id_persona, String nombre, String direccion, String telefono,String numero_seg_soc,  String fecha_naci,String actividad_economica, String cama_fk, String fecha_asig_cama){
        Paciente p = new Paciente(id_persona, nombre, direccion, telefono, numero_seg_soc, fecha_naci, actividad_economica, cama_fk, fecha_asig_cama);        

        
        int result =daoPaciente.guardarPaciente(p);

        
        return result;

    }//end

    public Paciente consultarPaciente(String id_persona){
        Paciente p = new Paciente();
        

        p = daoPaciente.consultarPaciente(id_persona);
      
       return p;
    }

    public void cerrarConexionBD(){
        daoPaciente.cerrarConexionBD();
    }
    
   

}