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


/**
 *
 * @author daniel
 */
public class DaoEmpleado {
    FachadaBD fachada;

    DaoEmpleado(){
        fachada= new FachadaBD();
    }//

     public int guardarEstudiante(Empleado emp){
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

    public void consultarEmpleado(){
        
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
}
