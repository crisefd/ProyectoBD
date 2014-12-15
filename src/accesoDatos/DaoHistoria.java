/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import logica.Area;
import logica.HistoriaClinica;



/**
 *
 * @author daniel
 */
public class DaoHistoria {
    FachadaBD fachada;

    public DaoHistoria(){
        fachada= new FachadaBD();
    }//

     public int guardarHistoria(HistoriaClinica m){
        String sql_guardar;
        sql_guardar="INSERT INTO Historia_Clinica(id_hist_clinica, fecha_apertura, id_paciente_fk) VALUES ('" +
                m.getId() + "', '" + m.getFechaApertura() +  "', '" +
                  m.getId_paciente() + "')";
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
     public int actualizarHistoria(HistoriaClinica m){
        String sql_guardar;
        sql_guardar="UPDATE Historia_Clinica(id_hist_clinica, fecha_apertura, id_paciente_fk) VALUES ('" +
                m.getId() + "', '" + m.getFechaApertura() +  "', '" +
                  m.getId_paciente() + "')";
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

    public ArrayList<HistoriaClinica> consultarMedicamento(){
        ArrayList<HistoriaClinica> array= new ArrayList<HistoriaClinica>();
        String sql_select;
        sql_select="SELECT * FROM Medicamento;";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            //
            while(tabla.next()){
               HistoriaClinica m= new HistoriaClinica(tabla.getString(1), tabla.getString(2), tabla.getString(3));
               array.add(m);
            }
             conn.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
         return array;
    }
    
    public HistoriaClinica consultarHistoria(String id){
        HistoriaClinica m= new HistoriaClinica();
        String sql_select;
        sql_select = "SELECT * from Historia_Clinica WHERE id_hist_clinica='" + id + "'";
        try {
            Connection conn = fachada.conectar();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while (tabla.next()) {
                m.setId(tabla.getString(1));
                m.setFechaApertura(tabla.getString(2));
                m.setId_paciente(tabla.getString(3));
//
//                e.setNombre(tabla.getString(2));
//
//                e.setNivel(tabla.getString(3));
//                e.setCreditos(tabla.getInt(4));

                System.out.println("OK");
            }

            return m;
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
         DaoHistoria dao= new DaoHistoria();
         HistoriaClinica m= new HistoriaClinica();
         
         m.setFechaApertura("08-04-2000");
         m.setId("224432");
         m.setId_paciente("333");
         
         
         dao.guardarHistoria(m);
      }
  
}
