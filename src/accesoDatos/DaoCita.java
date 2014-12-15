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
import java.util.Date;
import logica.Cama;
import logica.Cita;
import logica.Empleado;



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
                 "3000" + "')";
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
     public int borrarCita(Cita c){
        String sql_guardar;
        sql_guardar="UPDATE Cita SET logic_delete=False WHERE hora='" +c.obtTiempo() + "'AND tipo= '" + c.getTipo() +  "'AND fecha= '" +
                  c.getFecha()+  "' AND id_medico_fk ='" + c.getId_medico() + "' AND id_paciente_fk='" + c.getId_paciente() +  "';";                
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
    
    
    public ArrayList<Cita> consultarCitaPorIdPaciente(String id_paciente){
        
        String sql_select;
        ArrayList<Cita> citas = new ArrayList<Cita>();
        sql_select = "SELECT hora, tipo, fecha, id_medico_fk, id_paciente_fk,costo_cita FROM Cita WHERE id_paciente_fk='" + id_paciente + "'";
        try {
            Connection conn = fachada.conectar();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while (tabla.next()) {
                Cita c = new Cita();
                c.setTiempo(tabla.getString(1));
                c.setTipo(tabla.getString(2));
                c.setFecha(tabla.getString(3));
                c.setId_medico(tabla.getString(4));
                c.setId_paciente(tabla.getString(5));
                c.setCosto(tabla.getDouble(6));
                citas.add(c);
                System.out.println("OK");
            }

          //  return c;
        } catch (SQLException s) {
            System.out.println(s);
        } catch (Exception s) {
            System.out.println(s);
        }
        return citas;
}
    
    public ArrayList<Cita> consultarCitaPorIdMedico(String id_medico){
        
        String sql_select;
        ArrayList<Cita> citas = new ArrayList<Cita>();
        sql_select = "SELECT hora, tipo, fecha, id_medico_fk, id_paciente_fk,costo_cita FROM Cita WHERE id_medico_fk='" + id_medico + "'";
        try {
            Connection conn = fachada.conectar();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while (tabla.next()) {
                Cita c = new Cita();
                c.setTiempo(tabla.getString(1));
                c.setTipo(tabla.getString(2));
                c.setFecha(tabla.getString(3));
                c.setId_medico(tabla.getString(4));
                c.setId_paciente(tabla.getString(5));
                c.setCosto(tabla.getDouble(6));
                citas.add(c);
                System.out.println("OK");
            }

          //  return c;
        } catch (SQLException s) {
            System.out.println(s);
        } catch (Exception s) {
            System.out.println(s);
        }
        return citas;
}
    
    public void cerrarConexionBD() {
        fachada.closeConection(fachada.getConnetion());
    }
    
    
    
    public ArrayList<Cita> consultarCitasMedicoMes(String id_medico, String mes){
    ArrayList<Cita> array= new ArrayList<Cita>();
    Date fecha= new Date();
    String ano=""+(fecha.getYear() + 1900);
    
    String sql_select;
    sql_select = "SELECT hora, EXTRACT(DAY FROM fecha), id_paciente_fk FROM Cita WHERE id_medico_fk='" + id_medico + "' AND EXTRACT(YEAR FROM fecha)= '"+ano+"' AND EXTRACT(MONTH FROM fecha)= '"+mes+"';";
    System.out.println(sql_select);
       try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            //
            while(tabla.next()){
               Cita c= new Cita();
               c.setTiempo(tabla.getString(1));
               c.setDia(tabla.getString(2));
               c.setId_paciente(tabla.getString(3));
               array.add(c);
              // System.out.println(tabla.getString(2));
            }
             conn.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ 
             System.out.println(e); 
         }
         catch(Exception e){ 
             System.out.println(e); 
         }
       System.out.println("size->: "+array.size());
         return array;
    }
    
   
    public ArrayList<String> consultarNumeroCitasMedico(String numeroMes, String numeroAno){
        int numero=0;
          ArrayList<String> array= new ArrayList<String>();
        String sql_select;
        sql_select = "SELECT Cita.id_medico_fk, count( *) FROM Cita WHERE fecha between '01-"+numeroMes+"-"+numeroAno+"' and '31-"+numeroMes+"-"+numeroAno+"' GROUP BY Cita.id_medico_fk;";
        try {
            Connection conn = fachada.conectar();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while (tabla.next()) {
               array.add(tabla.getString(1)+"-"+tabla.getString(2));
            }

            return array;
        } catch (SQLException s) {
            System.out.println(s);
        } catch (Exception s) {
            System.out.println(s);
        }
        return null;
}
    
    
    public ArrayList<Double> promedioCostosMensual(String id_user){
    ArrayList<Double> costos = new ArrayList<Double>();
    double costoCita = 0 ,costoMedicamento = 0;
    Date fecha= new Date();
    String mes=""+fecha.getMonth();
    String sql_select;
        sql_select = "SELECT AVG(Cita.costo_cita), AVG(Medicamento.costo_medicamento) FROM (Cita NATURAL JOIN Medicamento) WHERE Cita.id_paciente_fk= '"+id_user+"'AND EXTRACT(MONTH FROM fecha)= '"+mes+"';";
    try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            conn.close();
             System.out.println("Conexion cerrada");
             
            costoCita= Double.parseDouble( tabla.getString(0));
            costoMedicamento = Double.parseDouble(tabla.getString(0));

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
         costos.add(costoCita);
         costos.add(costoMedicamento);
    return costos;
}
public ArrayList<Double> promedioCostosAnual(String id_user){
    ArrayList<Double> costos = new ArrayList<Double>();
    double costoCita = 0 ,costoMedicamento = 0;
    Date fecha= new Date();
    String year=""+fecha.getYear();
    String sql_select;
        sql_select = "SELECT AVG(Cita.costo_cita), AVG(Medicamento.costo_medicamento) FROM (Cita NATURAL JOIN Medicamento) WHERE Cita.id_paciente_fk= '"+id_user+"'AND EXTRACT(YEAR FROM fecha)= '"+year+"';";
    try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            conn.close();
             System.out.println("Conexion cerrada");
             
            costoCita= Double.parseDouble( tabla.getString(0));
            costoMedicamento = Double.parseDouble(tabla.getString(0));

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
         costos.add(costoCita);
         costos.add(costoMedicamento);
    return costos;
}
    
}
