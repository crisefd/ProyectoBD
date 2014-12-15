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
import logica.Enfermero;
import logica.Medico;

/**
 *
 * @author danielha
 */
public class DaoMedico {
    FachadaBD fachada;

    public DaoMedico(){
        fachada= new FachadaBD();
    }//

     public int guardarMedico(Medico med){
        String sql_guardar = "";
        sql_guardar += "INSERT INTO Medico(id_persona, nombre,direccion,telefono, cargo, salario, email, perfil_seguridad, id_area_fk, especializacion, num_licencia, universidad) VALUES('" 
                +med.obtIdPersona() + "', '" + med.obtNombre() +  "', '" + med.obtDireccion() + "', '" + med.obtTelefono() + "', '" + med.obtCargo() + "', '" + med.obtSalario()+ "', '" + med.obtEmail() + "', '" + med.obtSeguridad()  +"','"+ med.obtIdArea() +"', '" + med.obtEspecializacion()  +"','"+ med.obtNumLicencia() +"','"+ med.obtUniversidad() +"');";
        
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
     
     public int actualizarMedico(Medico med){
        String sql_guardar = "";
        sql_guardar += "UPDATE Medico SET nombre='"  + med.obtNombre() +  "',direccion= '" + med.obtDireccion() + "',telefono= '" + med.obtTelefono() + "',cargo= '" + med.obtCargo() + "',salario= '" + med.obtSalario()+ "',email= '" + med.obtEmail() + "', perfil_seguridad='" + med.obtSeguridad()
                +"',id_area_fk= '"+ med.obtIdArea() +"',especializacion= '" + med.obtEspecializacion()  +"',num_licencia='"+ med.obtNumLicencia() +"',universidad='"+ med.obtUniversidad()+"' WHERE id_persona='"+med.obtIdPersona()+"';" ;
        
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
     
     public int borrarMedico(Medico med){
        String sql_guardar = "";
        sql_guardar += "UPDATE Medico SET logic_delete=FALSE WHERE id_persona='"+med.obtIdPersona()+"';" ;
        
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
     
     
     

    public ArrayList<Medico> consultarMedicos(){
        
        String sql_select;
        ArrayList<Medico> array = new ArrayList<Medico>();
        sql_select="SELECT id_persona, nombre,direccion,telefono, cargo, salario, email, perfil_seguridad, id_area_fk,especializacion, num_licencia, universidad FROM Medico;";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            System.out.println("Email\tSalario\tCargo\tId area");
            //
            while(tabla.next()){
                Medico e = new Medico();
                e.setId_persona(tabla.getString(1));
                e.setNombre(tabla.getString(2));
                e.setDireccion(tabla.getString(3));
                e.setTelefono(tabla.getString(4));
                e.setCargo(tabla.getString(5));
                e.setSalario(tabla.getInt(6));
                e.setEmail(tabla.getString(7));
                e.setPerfilSeguridad(tabla.getString(8));
                e.setId_area(tabla.getString(9));
                e.setEspecializacion(tabla.getString(9));
                e.setNumLicencia(tabla.getString(9));
                e.setUniversidad(tabla.getString(10));
                array.add(e);
               //System.out.println("id_empleado: " + tabla.getString(1) + " Nombre: " + tabla.getString(2) + " Telefono:" +  tabla.getString(3)+"email: "+tabla.getString(4));

            }
            conn.close();
             

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
         return array;
    }


public Medico consultarMedico(String id_empleado){
        Medico e = new Medico();
        String sql_select;
        sql_select = "SELECT id_persona, nombre,direccion,telefono, cargo, salario, email, perfil_seguridad, id_area_fk FROM Medico WHERE id_empleado='" + id_empleado + "'";
        
        
        try {
            Connection conn = fachada.conectar();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

             while(tabla.next()){
                e.setId_persona(tabla.getString(1));
                e.setNombre(tabla.getString(2));
                e.setDireccion(tabla.getString(3));
                e.setTelefono(tabla.getString(4));
                e.setCargo(tabla.getString(5));
                e.setSalario(tabla.getInt(6));
                e.setEmail(tabla.getString(7));
                e.setPerfilSeguridad(tabla.getString(8));
                e.setId_area(tabla.getString(9));
               //System.out.println("id_empleado: " + tabla.getString(1) + " Nombre: " + tabla.getString(2) + " Telefono:" +  tabla.getString(3)+"email: "+tabla.getString(4));

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
 public static void main(String args[]){
     DaoMedico dao=new DaoMedico();
     Medico e =new Medico();
                e.setId_persona("1235");
                e.setNombre("Fabian");
                e.setDireccion("Calle 80");
                e.setTelefono("445678");
                e.setCargo("Medico novato");
                e.setSalario(1200000);
                e.setEmail("fabian@");
                e.setPerfilSeguridad("2");
                e.setId_area("444");
                e.setEspecializacion("Ginecologia");
                e.setNumLicencia("12345");
                e.setUniversidad("ICESI");
     //dao.guardarMedico(e);
     //dao.actualizarMedico(e);
                dao.borrarMedico(e);
//     dao.consultarMedicos();
//        ArrayList<Medico> array = dao.consultarMedicos();
//      
//          System.out.println(array.get(0).obtNombre());
 }
}

