package controlador;

import accesoDatos.DaoCama;
import accesoDatos.DaoCampana;
import java.util.ArrayList;
import logica.Area;
import logica.Cama;
import logica.Campana;

/**
 *
 * @author fabianact
 */
public class ControladorCampana{

    DaoCampana daoCampana;
    
    
    public ControladorCampana(){
        daoCampana=new DaoCampana();
    }
    
    
    public int  insertarCampana(Campana c){
              
        
        int result =daoCampana.guardarCampana(c);
        
        return result;

    }
    public int insertarPacientesCampana(String idsPacientes[], String idCampana){
        return daoCampana.guardarPacientesCampana(idsPacientes, idCampana);
    }


    
    public ArrayList<Campana> consultarCampanasPorId(String idCampana){
        return daoCampana.consultarCampanasPorId(idCampana);
        
    }
    
    public ArrayList<Campana> consultarCampanasPorNombre(String nombreCampana){
        return daoCampana.consultarCampanasPorNombre(nombreCampana);
        
        
    }
    public ArrayList<Campana> consultarCampanasPorMedico(String idMedico){
        return daoCampana.consultarCampanasPorMedico(idMedico);
    }
    
    public Campana consultarCampanaNombreMedico(String nombre){

        Campana c = new Campana();    

        c = daoCampana.consultarCampanaNombreMedico(nombre);
      
       return c;
    }
    
    
    public ArrayList<Campana> consultarCamas(){
        Area a = new Area();
        ArrayList<Campana> lista = daoCampana.consultarCampanas();
      
       return lista;
    }

    public void cerrarConexionBD(){
        daoCampana.cerrarConexionBD();
    }

}