package controlador;

import accesoDatos.DaoCama;
import accesoDatos.DaoCampana;
import accesoDatos.DaoPrograma;
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
    
    
    public int  insertarCampana(String id_campana, String nombre, String objetivo,String id_medico_encargado_fk){
        Campana c = new Campana(id_campana, nombre,objetivo, id_medico_encargado_fk);        
        
        int result =daoCampana.guardarCampana(c);
        
        return result;

    }

    public Campana consultarCampana(String id_campana){

        Campana c = new Campana();    

        c = daoCampana.consultarCampana(id_campana);
      
       return c;
    }
    
    
    public ArrayList<Campana> consultarCamas(){
        Area a = new Area();
        ArrayList<Campana> lista = daoCampana.consultarcampanas();
      
       return lista;
    }

    public void cerrarConexionBD(){
        daoCampana.cerrarConexionBD();
    }

}