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

    public DaoPaciente(){
        fachada= new FachadaBD();
    }//

     public int guardarPaciente(Paciente pac){
        String sql_guardar;
//        sql_guardar="INSERT INTO Persona(id_persona, nombre,direccion, telefono) VALUES ('" 
//                +pac.obtIdPersona() + "', '" + pac.obtNombre() +  "', '" + pac.obtDireccion() + "', '" + pac.obtTelefono() +"');";
        sql_guardar="INSERT INTO Paciente(num_seg_soc, fecha_naci, actividad_economica, id_cama_fk,fecha_asig_cama,id_persona,nombre,direccion,telefono) VALUES ('" +
                pac.obtyNum_seg_soc() + "', '" + pac.obtFechaNaci() +  "', '" + pac.obtActEconomica() + "', '"  + pac.obtId_cama() + "', '"+ pac.obtFechaAsigCama()+
                "', '"+ pac.obtIdPersona() +"', '"+pac.obtNombre()+"', '"+pac.obtDireccion()+"', '"+pac.obtTelefono()+"');";
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
     
     public int actualizarPaciente(Paciente pac){
        String sql_guardar;
               sql_guardar="UPDATE Paciente SET num_seg_soc='" +
                pac.obtyNum_seg_soc() + "',fecha_naci= '" + pac.obtFechaNaci() +  "',actividad_economica='" + pac.obtActEconomica() + "',id_cama_fk= '"  + pac.obtId_cama() + "',fecha_asig_cama= '"+ pac.obtFechaAsigCama()+
                "',nombre= '"+pac.obtNombre()+"',direccion= '"+pac.obtDireccion()+"',telefono= '"+pac.obtTelefono()+"'WHERE id_persona='"+pac.obtIdPersona()+"';";
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
    }
     
     public int borrarPaciente(Paciente pac){
        String sql_guardar;
               sql_guardar="UPDATE Paciente SET logic_delete = FALSE WHERE id_persona='" +pac.obtIdPersona()+"';";
                
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
     
     public void consultarPacientes(){
        
        String sql_select;
        sql_select="SELECT id_persona,nombre,direccion,telefono,num_seg_soc, fecha_naci, actividad_economica, id_cama,fecha_asig_cama FROM Paciente";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            System.out.println("Email\tSalario\tCargo\tId area");
            //
            while(tabla.next()){
               System.out.println("Id_persona: " + tabla.getString(1) + " Nombre: " + tabla.getString(2) + " Direccion:" +  tabla.getString(3)+"Telefono: "+tabla.getString(4)+"Num seg soc: "+tabla.getString(5)
                       +"Fecha nacimiento: "+tabla.getString(6)+"Actividad economica: "+tabla.getString(7)+"Cama: "+tabla.getString(8)+"Fecha cama: "+tabla.getString(9));

            }
            conn.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
    }

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
    public void cerrarConexionBD() {
        fachada.closeConection(fachada.getConnetion());
    }
    
    public static void main(String args[]){
        DaoPaciente dao= new DaoPaciente();
        Paciente p = new Paciente();
        
        p.setActEconomica("estudiante");
        p.setDireccion("calle 12");
        p.setFechaAsigCama("12-12-2000");
        p.setFechaNaci("12-08-2012");
        p.setId_cama("123");
        p.setId_persona("333");
        p.setNombre("daniel");
        p.setNum_seg_soc("4");
        p.setTelefono("3121111");
        //dao.guardarPaciente(p);
        //dao.actualizarPaciente(p);
        dao.borrarPaciente(p);
    }
}
