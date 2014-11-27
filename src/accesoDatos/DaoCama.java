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
import logica.Cama;



/**
 *
 * @author daniel
 */
public class DaoCama {
   FachadaBD fachada;

    DaoCama(){
        fachada= new FachadaBD();
    }//

     public int guardarCama(Cama c){
        String sql_guardar;
        sql_guardar="INSERT INTO Cama(id_cama, id_area, descripcion, estado) VALUES ('" +
                c.obtIdCama() + "', '" + c.obtIdArea() +  "', '" +
                  c.obtDescripcion()+ "', '"  +
                 c.obtEstado() + "')";
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

    public void consultarCama(){
        
        String sql_select;
        sql_select="SELECT id_cama, descripcion, estado FROM Cama";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            System.out.println("IdCama\tDescripcion\tEstado");
            //
            while(tabla.next()){
               System.out.println("id_cama: " + tabla.getString(1) + " Descripcion: " + tabla.getString(2) + " Estado:" +  tabla.getString(3));

            }
            conn.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
    } 
}
