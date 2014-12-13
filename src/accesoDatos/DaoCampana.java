package accesoDatos;
import accesoDatos.FachadaBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import logica.Campana;
import logica.Empleado;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
public class DaoCampana {
    FachadaBD fachada;

    public DaoCampana(){
        fachada= new FachadaBD();
    }

     public int guardarCampana(Campana camp){
        String sql_guardar;
        sql_guardar="INSERT INTO Campana(id_campana, nombre,objetivo, id_medico_encargado_fk) VALUES ('" 
                +camp.obtId() + "', '" + camp.obtNombre() +  "', '" + camp.obtObjetivo() + "', '" + camp.obtId_medico() +"');";
        
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            int numFilas = sentencia.executeUpdate(sql_guardar);
            conn.close();
            return numFilas;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return -1;
    }//fin guardar

    public ArrayList<Campana> consultarcampanas(){
        ArrayList<Campana> array= new ArrayList<Campana>();
        String sql_select;
        sql_select="SELECT id_campana, nombre,objetivo, id_medico_encargado_fk FROM Campana";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            //
            while(tabla.next()){
               Campana c= new Campana(tabla.getString(1), tabla.getString(2), tabla.getString(3), tabla.getString(4));
               array.add(c);
            }
             conn.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
         return array;
    }


public Campana consultarCampana(String id_campana){
        Campana c = new Campana();
        String sql_select;
        sql_select = "SELECT id_campana, nombre,objetivo, id_medico_encargado_fk FROM Campana WHERE id_campana='" + id_campana + "'";
        try {
            Connection conn = fachada.conectar();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while (tabla.next()) {
                c.setId(tabla.getString(1));
                c.setNombre(tabla.getString(2));
                c.setObjetivo(tabla.getString(3));
                c.setId_medico(tabla.getString(4));
            }
            conn.close();
            System.out.println("Conexion cerrada");


            return c;
        } catch (SQLException s) {
            System.out.println(s);
        } catch (Exception s) {
            System.out.println(s);
        }
        return null;
}

 public void cerrarConexionBD() {
        fachada.closeConection(fachada.getConnetion());
    }
 
 public static void main(String args[]){
     DaoCampana dao = new DaoCampana();
     Campana cam = new Campana();
     
     cam.setId("0000");
     cam.setId_medico("1234");
     cam.setNombre("campana1");
     cam.setObjetivo("hacer nada");
     
     dao.guardarCampana(cam);
 }
}