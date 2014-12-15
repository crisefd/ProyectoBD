package controlador;
import accesoDatos.DaoArea;
import accesoDatos.DaoEmpleado;
import accesoDatos.DaoHistoria;
import java.util.ArrayList;
import java.util.Vector;
import logica.Area;
import logica.Empleado;
import logica.HistoriaClinica;

/**
 *
 * @author daniel
 */
public class ControladorHistoria{

    DaoHistoria daoHistoria;
    
    
    public ControladorHistoria(){
        daoHistoria=new DaoHistoria();
    }
    
    
    public int  insertarHistoria(String id_area, String nombre,String descripcion){
        HistoriaClinica a = new HistoriaClinica(id_area,nombre, descripcion);        

        
        //Se llama al dao para guardar
        System.out.println("Se va a insertar un Empleado");
        
        int result =daoHistoria.guardarHistoria(a);

        System.out.println("Se  insertó  un  nuevo programa");
        
        return result;

    }//end

//    public Area consultarArea(String id_area){
//
//        Area a = new Area();        
//       // a = daoArea.consultarArea(id_area);
//      
//       return a;
//    }
    
//    public ArrayList<Area> consultarAreas(){
//        Area a = new Area();
//        //ArrayList<Area> lista = daoArea.consultarAreas();
//      
//       return lista;
//    }
    
    

//    public void cerrarConexionBD(){
//        //daoArea.cerrarConexionBD();
//    }
}