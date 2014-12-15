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
    public int guardarPacientesCampana(String idsPacientes[], String idCampana){
        String sql_guardar = "";
        try{
            Connection conn= fachada.conectar();
                    Statement sentencia = conn.createStatement();
        
            for(String idPaciente: idsPacientes){
                 sql_guardar +="INSERT INTO Campana_Paciente VALUES('"+idCampana+"','"
                        + idPaciente+"');";
                //System.out.println(sql_guardar);
                
                
            }
             int numFilas = sentencia.executeUpdate(sql_guardar);
             conn.close();
             return numFilas;
        }catch(SQLException e){
                System.out.println(e); 
        }catch(Exception e){ 
                    System.out.println(e); 
                }
        return -1;
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
     public int actualizarCampana(Campana camp){
        String sql_guardar;
        sql_guardar="UPDATE  Campana SET nombre='"  + camp.obtNombre() +  "',objetivo= '" + camp.obtObjetivo() + "',id_medico_encargado_fk= '" + camp.obtId_medico() +"'WHERE id_campana='"+camp.obtId()+"';";
        
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
    }
      
      public int borrarCampana(Campana camp){
        String sql_guardar;
        sql_guardar="UPDATE  Campana SET logic_delete= FALSE WHERE id_campana='"+camp.obtId()+"';";
        
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
    }

    public ArrayList<Campana> consultarCampanas(){
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
    
    public ArrayList<Campana> consultarCampanasPorId(String idCampana){
        ArrayList<Campana> array= new ArrayList<Campana>();
        String sql_select;
        sql_select="SELECT id_campana, nombre,objetivo, id_medico_encargado_fk FROM Campana WHERE id_campana='"+idCampana+"';";
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
    
    public ArrayList<Campana> consultarCampanasPorNombre(String nombreCampana){
        ArrayList<Campana> array= new ArrayList<Campana>();
        String sql_select;
        sql_select="SELECT id_campana, nombre,objetivo, id_medico_encargado_fk FROM Campana WHERE nombre='"+nombreCampana+"';";
        System.out.println(sql_select);
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            //
            while(tabla.next()){
               Campana c= new Campana();
               c.setId(tabla.getString(1));
               c.setNombre(tabla.getString(2));
               c.setObjetivo(tabla.getString(3));
               c.setId_medico(tabla.getString(4));
               array.add(c);
            }
             conn.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
         return array;
    }
    
    public ArrayList<Campana> consultarCampanasPorMedico(String idMedico){
        ArrayList<Campana> array= new ArrayList<Campana>();
        String sql_select;
        sql_select="SELECT id_campana, nombre,objetivo, id_medico_encargado_fk FROM Campana WHERE id_medico_encargado_fk='"+idMedico+"';";
        System.out.println(sql_select);
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            //
            while(tabla.next()){
               //Campana c= new Campana(tabla.getString(1), tabla.getString(2), tabla.getString(3));
                Campana c = new Campana();
                c.setId(tabla.getString(1));
                c.setNombre(tabla.getString(2));
                c.setObjetivo(tabla.getString(3));
                c.setId_medico(tabla.getString(4));
                array.add(c);
            }
             conn.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
         return array;
    }


public Campana consultarCampanaNombreMedico(String nombre){
        Campana c = new Campana();
        String sql_select;
        sql_select = "select campana.id_campana, campana.nombre, campana.objetivo from campana, medico where campana.id_medico_encargado_fk=medico.id_persona and medico.nombre=" + nombre + "'";
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
     
 }
}