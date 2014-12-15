/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import logica.Causa;
import logica.Cita;

/**
 *
 * @author crisefd
 */
public class DaoCausa {
    private FachadaBD fachada;
    public DaoCausa(){
        fachada = new FachadaBD();
    }
    public int guardarCausa(Cita cita, Causa causa){
        String sql_guardar = "INSERT INTO Causa(nombre, descripcion, hora_cita_fk, tipo_cita_fk, fecha_cita_fk, id_medico_cita_fk, id_paciente_cita_fk, costo_cita_fk) VALUES('"
                +causa.getNombre()+"', '"+causa.getDescripcion()+"', '"+cita.obtTiempo()
                +"', '"+cita.getTipo()+"','"+cita.getFecha()+"','"+cita.getId_medico()
                +"','"+cita.getId_paciente()+"', 3000);";
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
    
    public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }
}
