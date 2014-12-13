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
        sql_guardar="INSERT INTO Cama(id_cama, id_area_fk, descripcion, estado) VALUES ('" +
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

   public ArrayList<Cama> consultarCamas(){
        ArrayList<Cama> array= new ArrayList<Cama>();
        String sql_select;
        sql_select="SELECT id_cama, id_area_fk,descripcion, estado FROM Cama";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            //
            while(tabla.next()){
               Cama c= new Cama(tabla.getString(1), tabla.getString(2), tabla.getString(3), tabla.getString(4));
               array.add(c);
               System.out.println(tabla.getString(2));
            }
             conn.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
         return array;
    }
    
    
    public Cama consultarCama(String id_cama){
        Cama c = new Cama();
        String sql_select;
        sql_select = "SELECT id_cama,id_area, descripcion,estado FROM Cama WHERE id_cama='" + id_cama + "'";
        try {
            Connection conn = fachada.conectar();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while (tabla.next()) {
                c.setId_cama(tabla.getString(1));
                c.setId_area(tabla.getString(2));
                c.setDescripcion(tabla.getString(3));
                c.setEstado(tabla.getString(4));
//
//                e.setNombre(tabla.getString(2));
//
//                e.setNivel(tabla.getString(3));
//                e.setCreditos(tabla.getInt(4));

                System.out.println("OK");
            }

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
        DaoCama dao = new DaoCama();
        Cama c = new Cama();
        
        c.setDescripcion("dos cama");
        c.setEstado("ocu");
        c.setId_area("444");
        c.setId_cama("1235");
        
        dao.guardarCama(c);
    }
}
