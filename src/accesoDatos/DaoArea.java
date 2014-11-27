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
import logica.Area;
import logica.Empleado;



/**
 *
 * @author daniel
 */
public class DaoArea {
    FachadaBD fachada;

    public DaoArea(){
        fachada= new FachadaBD();
    }//

     public int guardarArea(Area a){
        String sql_guardar;
        sql_guardar="INSERT INTO Area(id_area, nombre, descripcion) VALUES ('" +
                a.obtIdArea() + "', '" + a.obtNombre() +  "', '" +
                  a.descripcion() + "')";
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

    public void consultarArea(){
        
        String sql_select;
        sql_select="SELECT id_area, nombre, descripcion FROM Area";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            System.out.println("Id cama\tNombre\tDescripcion");
            //
            while(tabla.next()){
               System.out.println("id_area: " + tabla.getString(1) + " Nombre: " + tabla.getString(2) + " Descripcion:" +  tabla.getString(3));

            }
            conn.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
}
    
    public Area consultarArea(String id_area){
        Area a = new Area();
        String sql_select;
        sql_select = "SELECT id_area, nombre, descripcion from Area WHERE id_area='" + id_area + "'";
        try {
            Connection conn = fachada.conectar();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while (tabla.next()) {
                a.setId_area(tabla.getString(1));
                a.setNombre(tabla.getString(2));
                a.setDescripcion(tabla.getString(3));
//
//                e.setNombre(tabla.getString(2));
//
//                e.setNivel(tabla.getString(3));
//                e.setCreditos(tabla.getInt(4));

                System.out.println("OK");
            }

            return a;
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
  
}
