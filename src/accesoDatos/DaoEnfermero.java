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
        String sql_guardar = "";
        sql_guardar += "INSERT INTO Enfermero(anos_exp,id_persona, nombre,direccion,telefono, cargo, salario, email, perfil_seguridad, id_area_fk) VALUES('" 
                +emf.obtAnos_exp() + "', '" + emf.obtIdPersona() +  "', '" + emf.obtNombre() + "', '" + emf.obtDireccion() + "', '" + emf.obtTelefono() + "', '" + emf.obtCargo()+ "', '" + emf.obtSalario() + "', '" + emf.obtEmail() + "', '" + emf.obtSeguridad() + "', '" + emf.obtIdArea() +"');";
        
        System.out.println(sql_guardar);
        String habilidades[] = emf.obtHabilidades();
       
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            int numFilas = sentencia.executeUpdate(sql_guardar);
            conn.close();
            return numFilas;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
         for(String habilidad: habilidades){
            asignarHabilidadEnfermero(emf.obtIdPersona(), habilidad);
        }
        return -1;
    }//fin guardar
     
     private int asignarHabilidadEnfermero(String id, String hab){
         String sql_insert;
         sql_insert="INSERT INTO Habilidades_Enfermero( id_persona_fk,habilidad) VALUES ('"+id+"','"+hab+"');";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            int numFilas = sentencia.executeUpdate(sql_insert);
            conn.close();
            return numFilas;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return -1;
     }
     
    private Object[] consultarHabilidadEnfermero(String idEnfermero){
       String sql_select;
       sql_select="SELECT habilidad FROM Habilidades_Enfermero WHERE id_persona_fk="+idEnfermero+";";
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

    public  ArrayList<Enfermero> consultarEnfermeros(){
        
        String sql_select;
        ArrayList<Enfermero> array = new ArrayList<Enfermero>();
        sql_select="SELECT anos_exp,id_persona, nombre,direccion,telefono, cargo, salario, email, perfil_seguridad, id_area_fk FROM Enfermero  logic_delete= TRUE;";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            System.out.println("Email\tSalario\tCargo\tId area");
            //
            while(tabla.next()){
                Enfermero e = new Enfermero();
                e.setAnosExp(tabla.getInt(1));
                e.setId_persona(tabla.getString(2));
                e.setNombre(tabla.getString(3));
                e.setTelefono(tabla.getString(4));
                e.setCargo(tabla.getString(5));
                e.setEmail(tabla.getString(6));
                e.setPerfilSeguridad(tabla.getString(7));
                e.setId_area(tabla.getString(8));
                array.add(e);
               //System.out.println("id_empleado: " + tabla.getString(1) + " Nombre: " + tabla.getString(2) + " Telefono:" +  tabla.getString(3)+"email: "+tabla.getString(4));

            }
            conn.close();
             

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
         return array;
    }


public Enfermero consultarEnfermero(String id_empleado){
        Enfermero e = new Enfermero();
        String sql_select;
        sql_select = "SELECT id_empleado, nombre, telefono, email, cargo, id_area_fk,anos_exp,id_enfermero FROM Enfermero WHERE id_empleado='" + id_empleado + "' AND logic_delete= TRUE";
        Object h[];
        h=consultarHabilidadEnfermero(id_empleado);
        String habilidades[] = new String[h.length];
        for (int i = 0; i < h.length; i++) {
        habilidades[i] = (String)h[i];
    }
        
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
            e.setHabilidades(habilidades);

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
 public static void main(String args[]){
     DaoEnfermero dao=new DaoEnfermero();
     Enfermero e =new Enfermero();
     e.setId_persona("123");
     e.setId_area("444");
     e.setAnosExp(14);
     e.setCargo("general");
     e.setDireccion("calle 70");
     e.setEmail("correo");
     e.setIdEnfermero("123");
     e.setNombre("luis");
     e.setPerfilSeguridad("1");
     e.setTelefono("12345678");
     
     e.setSalario(123000);
     e.setHabilidades(new String[]{"injecccion","pediatria"});
     dao.guardarEnfermero(e);
     
      //ArrayList<Enfermero> array = dao.consultarEnfermeros();
      
         // System.out.println(array.get(0).obtNombre());
      
     
 }
}
