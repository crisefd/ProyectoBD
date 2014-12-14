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
import java.util.Calendar;
import logica.Cama;
import logica.Cita;
import logica.Empleado;
import java.util.Date;



/**
 *
 * @author daniel
 */
public class DaoCita {
   FachadaBD fachada;

    public DaoCita(){
        fachada= new FachadaBD();
    }//

     public int guardarCita(Cita c){
        String sql_guardar;
        sql_guardar="INSERT INTO Cita(hora, tipo, fecha, id_medico_fk, id_paciente_fk,costo_cita) VALUES ('" +
                c.obtTiempo() + "', '" + c.getTipo() +  "', '" +
                  c.getFecha()+  "', '" + c.getId_medico() + "', '" + c.getId_paciente() +  "', '"+
                 "2500" + "')";
        System.out.println(sql_guardar);
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

   public ArrayList<Cita> consultarCitas(){
        ArrayList<Cita> array= new ArrayList<Cita>();
        String sql_select;
        sql_select="SELECT hora, tipo, fecha, id_medico_fk, id_paciente_fk,costo_cita FROM Cita";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            //
            while(tabla.next()){
               Cita c= new Cita(tabla.getString(1), tabla.getString(2), tabla.getString(3), tabla.getString(4), tabla.getString(5));
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
    
    
    public Cita consultarCita(String id_cita){
        Cita c = new Cita();
        String sql_select;
        sql_select = "SELECT hora, tipo, fecha, id_medico_fk, id_paciente_fk,costo_cita FROM Cita WHERE id_medico='" + id_cita + "'";
        try {
            Connection conn = fachada.conectar();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while (tabla.next()) {
                c.setTiempo(tabla.getString(1));
                c.setTipo(tabla.getString(2));
                c.setFecha(tabla.getString(3));
                c.setId_medico(tabla.getString(4));
                c.setId_paciente(tabla.getString(5));
                c.setCosto(tabla.getDouble(6));
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
public ArrayList<Cita> consultarCitasMedicoMes(String id_medico, String mes){
    ArrayList<Cita> array= new ArrayList<Cita>();
    Date fecha= new Date();
    String año=""+fecha.getYear();
    String patronMes = "%/"+mes+"/"+año;
    String sql_select;
    sql_select = "SELECT hora, tipo, fecha, id_medico_fk, id_paciente_fk,costo_cita FROM Cita WHERE (id_medico='" + id_medico + "' && fecha LIKE '"+ patronMes+ "'";
       try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            //
            while(tabla.next()){
               Cita c= new Cita(tabla.getString(1), tabla.getString(2), tabla.getString(3), tabla.getString(4), tabla.getString(5));
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

public ArrayList<Cita> consultarCitasIdMed(String id_medico){
        ArrayList<Cita> array= new ArrayList<Cita>();
        String sql_select;
        sql_select = "SELECT hora, tipo, fecha, id_medico_fk, id_paciente_fk,costo_cita FROM Cita WHERE id_medico='" + id_medico + "'";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            //
            while(tabla.next()){
               Cita c= new Cita(tabla.getString(1), tabla.getString(2), tabla.getString(3), tabla.getString(4), tabla.getString(5));
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
//EDITAR ESTOOOO
public ArrayList<Cita> consultarCitasIdPac(String id_pac){
        ArrayList<Cita> array= new ArrayList<Cita>();
        String sql_select;
        sql_select = "SELECT hora, tipo, fecha, id_medico_fk, id_paciente_fk,costo_cita FROM Cita WHERE id_paciente_fk='" + id_pac + "'";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            //
            while(tabla.next()){
               Cita c= new Cita(tabla.getString(1), tabla.getString(2), tabla.getString(3), tabla.getString(4), tabla.getString(5));
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
public String consultarCitasCountIdMed(String id_medico){
    String count="";
    String sql_select;
        sql_select = "SELECT COUNT (*) AS Count FROM Cita WHERE id_medico='" + id_medico + "'";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            count=tabla.getString(1);              
            conn.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
         return count;
    
}
    public void cerrarConexionBD() {
        fachada.closeConection(fachada.getConnetion());
    }
    
    public static void main(String asrg[]){
        DaoCita dao = new DaoCita();
        Cita c = new Cita();
        
        c.setCosto(112);
        c.setFecha("12-10-2014");
        c.setId_medico("1234");
        c.setId_paciente("333");
        c.setTiempo("08:00:00");
        c.setTipo("externa");
        dao.guardarCita(c);
        
    }
}
