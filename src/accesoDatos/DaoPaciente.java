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
        sql_guardar="INSERT INTO Persona(id_persona, nombre,direccion, telefono) VALUES ('" 
                +pac.obtIdPersona() + "', '" + pac.obtNombre() +  "', '" + pac.obtDireccion() + "', '" + pac.obtTelefono() +"');";
        sql_guardar="INSERT INTO Paciente(num_seg_soc, fecha_naci, actividad_economica, id_cama,fecha_asig_cama,id_persona,,nombre,direccion,telefono) VALUES ('" +
                pac.obtyNum_seg_soc() + "', '" + pac.obtFechaNaci() +  "', '" + pac.obtActEconomica() + "', '"  + pac.obtId_cama() + "', '"+ pac.obtFechaAsigCama()+
                "', '"+ pac.obtIdPersona() +"', '"+pac.obtNombre()+"', '"+pac.obtDireccion()+"', '"+pac.obtTelefono()+"');"
                + "INSERT INTO";
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

    public Paciente consultarPaciente(String id_persona){
        Paciente p = new Paciente();
        String sql_select;
       
        sql_select = "SELECT id_persona,nombre,direccion,telefono,num_seg_soc, fecha_naci, actividad_economica, id_cama,fecha_asig_cama FROM Paciente WHERE  id_persona='" + id_persona + "'";
        try {
            Connection conn = fachada.conectar();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while (tabla.next()) {
                p.setId_persona(tabla.getString(1));
                p.setNombre(tabla.getString(2));
                p.setDireccion(tabla.getString(3));
                p.setTelefono(tabla.getString(4));
                p.setNum_seg_soc(tabla.getString(5));
                p.setFechaNaci(tabla.getString(6));
                p.setActEconomica(tabla.getString(7));
                p.setId_cama(tabla.getString(8));
                p.setFechaAsigCama(tabla.getString(9));
//
//                e.setNombre(tabla.getString(2));
//
//                e.setNivel(tabla.getString(3));
//                e.setCreditos(tabla.getInt(4));

                System.out.println("OK");
            }

            return p;
        } catch (SQLException s) {
            System.out.println(s);
        } catch (Exception s) {
            System.out.println(s);
        }
        return null;
}
}
