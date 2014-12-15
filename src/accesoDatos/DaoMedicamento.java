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
import logica.Medicamento;



/**
 *
 * @author daniel
 */
public class DaoMedicamento {
    FachadaBD fachada;

    public DaoMedicamento(){
        fachada= new FachadaBD();
    }//

     public int guardarMedicamento(Medicamento m){
        String sql_guardar;
        sql_guardar="INSERT INTO Medicamento(id_medicamento, nombre, descripcion,costo_medicamento) VALUES ('" +
                m.obtId() + "', '" + m.obtNombre() +  "', '" + m.obtDescripcion()+"', '" +
                  m.obtCosto() + "')";
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

    public ArrayList<Medicamento> consultarMedicamento(){
        ArrayList<Medicamento> array= new ArrayList<Medicamento>();
        String sql_select;
        sql_select="SELECT * FROM Medicamento;";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            //
            while(tabla.next()){
               Medicamento m= new Medicamento(tabla.getString(1), tabla.getString(2), tabla.getString(3),tabla.getDouble(4));
               array.add(m);
            }
             conn.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
         return array;
    }
    
    public ArrayList<Medicamento> consultarMedicamentoPorID(String id){
        Medicamento m= new Medicamento();
        ArrayList<Medicamento> array= new ArrayList<Medicamento>();
        String sql_select;
        sql_select = "SELECT * from Medicamento WHERE id_medicamento='" + id + "'";
        try {
            Connection conn = fachada.conectar();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while (tabla.next()) {
                m.setId(tabla.getString(1));
                m.setNombre(tabla.getString(2));
                m.setDescripcion(tabla.getString(3));
                array.add(m);
//
//                e.setNombre(tabla.getString(2));
//
//                e.setNivel(tabla.getString(3));
//                e.setCreditos(tabla.getInt(4));

                System.out.println("OK");
            }

            
        } catch (SQLException s) {
            System.out.println(s);
        } catch (Exception s) {
            System.out.println(s);
        }
        return array;
}
    public ArrayList<Medicamento> consultarMedicamentoPorNombre(String nombre){
        Medicamento m= new Medicamento();
        ArrayList<Medicamento> array= new ArrayList<Medicamento>();
        String sql_select;
        sql_select = "SELECT * from Medicamento WHERE nombre_medicamento='" + nombre + "'";
        try {
            Connection conn = fachada.conectar();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while (tabla.next()) {
                m.setId(tabla.getString(1));
                m.setNombre(tabla.getString(2));
                m.setDescripcion(tabla.getString(3));
                array.add(m);
//
//                e.setNombre(tabla.getString(2));
//
//                e.setNivel(tabla.getString(3));
//                e.setCreditos(tabla.getInt(4));

                System.out.println("OK");
            }

            
        } catch (SQLException s) {
            System.out.println(s);
        } catch (Exception s) {
            System.out.println(s);
        }
        return array;
}
    
     public void cerrarConexionBD() {
        fachada.closeConection(fachada.getConnetion());
    }
     public static void main(String args[]){
         DaoMedicamento dao= new DaoMedicamento();
         Medicamento m= new Medicamento();
         
         m.setCosto(1000);
         m.setDescripcion("quita sintomas");
         m.setId("17");
         m.setNombre("aspirina");
         
         dao.guardarMedicamento(m);
      }
  
}

