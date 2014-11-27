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
import logica.Paciente;
import logica.Programa;

/**
 *
 * @author daniel
 */
public class DaoPaciente {
   FachadaBD fachada;

    DaoPaciente(){
        fachada= new FachadaBD();
    }//

     public int guardarPaciente(Paciente pac){
        String sql_guardar;
        sql_guardar="INSERT INTO Paciente(num_seg_soc, fecha_naci, actividad_economica, id_cama,fecha_asig_cama) VALUES ('" +
                pac.getCodigo() + "', '" + est.getNombre() +  "', '" +
                est.getSexo() + "', '"  +
                est.getPrograma().getCodigo() + "')";
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

    public void consultarEstudiantes(){
        Programa p= new Programa();
        String sql_select;
        sql_select="SELECT codigo, nombre, codigo_programa FROM estudiante";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            System.out.println("Codigo\tNombre\tPrograma");
            //
            while(tabla.next()){
               System.out.println("Codigo: " + tabla.getString(1) + " Nombre: " + tabla.getString(2) + " Plan:" +  tabla.getString(3));

            }
            conn.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
    } 
}
