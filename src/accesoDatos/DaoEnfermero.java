/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import logica.Enfermero;

/**
 *
 * @author danielha
 */
public class DaoEnfermero {
    FachadaBD fachada;

    public DaoEnfermero(){
        fachada= new FachadaBD();
    }//

     public int guardarEnfermero(Enfermero emf){
        String sql_guardar;
        sql_guardar="INSERT INTO Persona(id_persona, nombre,direccion, telefono) VALUES ('" 
                +emf.obtIdPersona() + "', '" + emf.obtNombre() +  "', '" + emf.obtDireccion() + "', '" + emf.obtTelefono() +"');";
        sql_guardar+="INSERT INTO Enfermero(id_persona, nombre,id_empleado,direccion, telefono, cargo, salario, email, id_area_fk,anos_exp,id_enfermero) VALUES ('" 
                +emf.obtIdPersona() + "', '" + emf.obtNombre() + "', '" + emf.obtIdPersona() +  "', '" + emf.obtDireccion() + "', '" + emf.obtTelefono() +"', '"+emf.obtCargo() + "', " + emf.obtSalario() +  ", '" +
                 emf.obtEmail() + "', '"  +
                 emf.obtIdArea() +"', '"+emf.getIdEnfermero()+"', "+emf.obtAnos_exp()+ ")";
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
     
    private Object[] consultarHabilidadEnfermero(String idEnfermero){
       String sql_select;
       sql_select="SELECT habilidad FROM Habilidades_Enfermero WHERE id_enfermero_fk="+idEnfermero+";";
       ArrayList<String> array= new ArrayList<String>();
       try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            System.out.println("Email\tSalario\tCargo\tId area");
            //
            int c = 1;
            
            while(tabla.next()){
                
                array.add(tabla.getString(c));
                c++;
               //System.out.println("id_empleado: " + tabla.getString(1) + " Nombre: " + tabla.getString(2) + " Telefono:" +  tabla.getString(3)+"email: "+tabla.getString(4));

            }
            
            conn.close();
             

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
       return array.toArray();
    }

    public void consultarEnfermeros(){
        
        String sql_select;
        ArrayList<Enfermero> array = new ArrayList<Enfermero>();
        sql_select="SELECT id_empleado, nombre, telefono, email, cargo, id_area_fk,anos_exp,id_enfermero FROM Enfermero;";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            System.out.println("Email\tSalario\tCargo\tId area");
            //
            while(tabla.next()){
                Enfermero e = new Enfermero();
                e.setId_persona(tabla.getString(1));
                e.setNombre(tabla.getString(2));
                e.setTelefono(tabla.getString(3));
                e.setEmail(tabla.getString(4));
                e.setCargo(tabla.getString(5));
                e.setId_area(tabla.getString(6));
                e.setAnosExp(tabla.getInt(7));
                e.setIdEnfermero(tabla.getString(8));
               //System.out.println("id_empleado: " + tabla.getString(1) + " Nombre: " + tabla.getString(2) + " Telefono:" +  tabla.getString(3)+"email: "+tabla.getString(4));

            }
            conn.close();
             

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
    }


public Enfermero consultarEnfermero(String id_empleado){
        Enfermero e = new Enfermero();
        String sql_select;
        sql_select = "SELECT id_empleado, nombre, telefono, email, cargo, id_area_fk,anos_exp,id_enfermero FROM Enfermero WHERE id_empleado='" + id_empleado + "'";
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
                e.setAnosExp(tabla.getInt(7));
                e.setIdEnfermero(tabla.getString(8));
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
