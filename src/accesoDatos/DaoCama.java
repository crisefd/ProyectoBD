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
import logica.Empleado;



/**
 *
 * @author daniel
 */
public class DaoCama {
   FachadaBD fachada;

    public DaoCama(){
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
    
    
    public Empleado consultarCama(String id_cama){
        Empleado e = new Empleado();
        String sql_select;
        sql_select = "SELECT id_empleado, nombre, telefono, email, cargo, id_area_fk FROM Cama WHERE id_cama='" + id_cama + "'";
        try {
            Connection conn = fachada.conectar();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while (tabla.next()) {
                e.setId_persona(tabla.getString(1));
                e.setNombre(tabla.getString(2));
                e.setTelefono(tabla.getString(3));
                e.setEmail(tabla.getString(4));
                e.setCargo(tabla.getString(5));
                e.setId_area(tabla.getString(6));
//
//                e.setNombre(tabla.getString(2));
//
//                e.setNivel(tabla.getString(3));
//                e.setCreditos(tabla.getInt(4));

                System.out.println("OK");
            }

            return e;
        } catch (SQLException s) {
            System.out.println(s);
        } catch (Exception s) {
            System.out.println(s);
        }
        return null;
}
}
