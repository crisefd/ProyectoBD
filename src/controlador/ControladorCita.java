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
    
    
    public int  insertarCita(Cita c){      

       
        
        int result =daoCita.guardarCita(c);
        
        return result;

    }//end

    
    public ArrayList<Cita> consultarCitas(){
        Cita c = new Cita();
        ArrayList<Cita> lista = daoCita.consultarCitas();
      
       return lista;
    }
    public ArrayList<Cita> consultarCitasMedicoMes(String id_med, String mes){
        Cita c = new Cita();
        ArrayList<Cita> lista = daoCita.consultarCitasMedicoMes(id_med, mes);
      
       return lista;
    }
    public ArrayList<Cita> consultarCitasIdMed(String id_med){
        Cita c = new Cita();
        ArrayList<Cita> lista = daoCita.consultarCitaPorIdMedico(id_med);
      
       return lista;
    }
    public ArrayList<Cita> consultarCitasIdPac(String id_pac){
        Cita c = new Cita();
        ArrayList<Cita> lista = daoCita.consultarCitaPorIdPaciente(id_pac);
      
       return lista;
    }
     public ArrayList<String> consultarCitasCountIdMed(String numeroMes,String numeroAno){
        Cita c = new Cita();
        ArrayList<String> lista = daoCita.consultarNumeroCitasMedico(numeroMes,numeroAno);
      
       return lista;
    }
    
        public ArrayList<String> promedioCostoMensual(String id_user){
       ArrayList<String> costos = new ArrayList<String>();
        Double costoMedicamento = daoCita.promedioCostosMensual(id_user).get(1);
        Double costoCita = daoCita.promedioCostosMensual(id_user).get(0);
        costos.add(costoMedicamento.toString());
        costos.add(costoCita.toString());
        return costos;
    }
    public ArrayList<String> promedioCostoAnual(String id_user){
       ArrayList<String> costos = new ArrayList<String>();
        Double costoMedicamento = daoCita.promedioCostosAnual(id_user).get(1);
        Double costoCita = daoCita.promedioCostosAnual(id_user).get(0);
        costos.add(costoMedicamento.toString());
        costos.add(costoCita.toString());
        return costos;
    }
    

    public void cerrarConexionBD(){
        daoCita.cerrarConexionBD();
    }
    
    
}