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
        sql_guardar="INSERT INTO Empleado(cargo, salario, email, id_area) VALUES ('" +
                emp.obtCargo() + "', '" + emp.obtSalario() +  "', '" +
                  emp.obtEmail() + "', '"  +
                 emp.obtIdArea() + "')";
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

    public void consultarEmpleados(){
        
        String sql_select;
        sql_select="SELECT email, salario, cargo, id_area FROM Empleado";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            System.out.println("Email\tSalario\tCargo\tId area");
            //
            while(tabla.next()){
               System.out.println("Email: " + tabla.getString(1) + " Salario: " + tabla.getString(2) + " Cargo:" +  tabla.getString(3)+"Id area"+tabla.getString(4));

            }
            conn.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
    }


public Empleado consultarEmpleado(String id_persona){
        Empleado e = new Empleado();
        String sql_select;
        sql_select = "SELECT id_persona, nombre, telefono, email, cargo, id_area_fk FROM Empleado WHERE id_persona='" + id_persona + "'";
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

 public void cerrarConexionBD() {
        fachada.closeConection(fachada.getConnetion());
    }

}