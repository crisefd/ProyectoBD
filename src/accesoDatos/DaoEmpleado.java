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
import logica.Empleado;
import logica.Programa;


/**
 *
 * @author daniel
 */
public class DaoEmpleado {
    FachadaBD fachada;

    public DaoEmpleado(){
        fachada= new FachadaBD();
    }//

     public int guardarEmpleado(Empleado emp){
        String sql_guardar;
        sql_guardar="INSERT INTO Persona(id_persona, nombre,direccion, telefono) VALUES ('" 
                +emp.obtIdPersona() + "', '" + emp.obtNombre() +  "', '" + emp.obtDireccion() + "', '" + emp.obtTelefono() +"');";
        sql_guardar+="INSERT INTO Empleado(id_persona, nombre,id_empleado,direccion, telefono, cargo, salario, email, id_area_fk, perfil_seguridad) VALUES ('" 
                +emp.obtIdPersona() + "', '" + emp.obtNombre() + "', '" + emp.obtIdPersona() +  "', '" + emp.obtDireccion() + "', '" + emp.obtTelefono() +"', '"+emp.obtCargo() + "', '" + emp.obtSalario() +  "', '" +
                 emp.obtEmail() + "', '"  +
                 emp.obtIdArea() + "', '"  +
                 "0" +"')";
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

    public ArrayList<Empleado> consultarEmpleados(){
        ArrayList<Empleado> array= new ArrayList<Empleado>();
        String sql_select;
        sql_select="SELECT id_empleado, nombre,direccion, telefono, id_area_fk, cargo, email, salario FROM Empleado";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            //
            while(tabla.next()){
               Empleado e= new Empleado(tabla.getString(1), tabla.getString(2), tabla.getString(3), tabla.getString(4),tabla.getString(5),tabla.getString(6),  tabla.getString(7), tabla.getDouble(8));
               array.add(e);
               System.out.println(tabla.getString(2));
            }
             conn.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
         return array;
    }


public Empleado consultarEmpleado(String id_empleado){
        Empleado e = new Empleado();
        String sql_select;
        sql_select = "SELECT id_empleado, nombre, telefono, email, cargo,perfil_seguridad, id_area_fk, salario FROM Empleado WHERE id_empleado='" + id_empleado + "'";
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
                e.setPerfilSeguridad(tabla.getString(6));
                e.setId_area(tabla.getString(7));
                e.setSalario(tabla.getDouble(8));
//
//                e.setNombre(tabla.getString(2));
//
//                e.setNivel(tabla.getString(3));
//                e.setCreditos(tabla.getInt(4));

                System.out.println("OK");
            }
            conn.close();
            System.out.println("Conexion cerrada");


            return e;
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