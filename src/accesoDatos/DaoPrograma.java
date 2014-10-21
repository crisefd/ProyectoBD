/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

/**
 *
 * @author Oswaldo
 */
import java.sql.*;
import logica.*;

/**
 *
 * @author oswaldo
 */
public class DaoPrograma {

    FachadaBD fachada;

    public DaoPrograma() {
        fachada = new FachadaBD();
    }

    public int guardarPrograma(Programa p) {
        String sql_guardar;
        int numFilas = 0;

        sql_guardar = "INSERT INTO programa VALUES ('"
                + p.getCodigo() + "', '" + p.getNombre() + "', '"
                + p.getNivel() + "', " + p.getCreditos() + ")";
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();

            numFilas = sentencia.executeUpdate(sql_guardar);
            System.out.println("up " + numFilas);
            return numFilas;

        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }//fin guardar

    public Programa consultarPrograma(String codigo) {
        Programa p = new Programa();
        String sql_select;
        sql_select = "SELECT codigo, nombre,nivel, num_creditos FROM  programa WHERE codigo='" + codigo + "'";
        try {
            Connection conn = fachada.getConnetion();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while (tabla.next()) {

                p.setCodigo(tabla.getString(1));

                p.setNombre(tabla.getString(2));

                p.setNivel(tabla.getString(3));
                p.setCreditos(tabla.getInt(4));

                System.out.println("OK");
            }

            return p;
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public int modificarPrograma(String[]valores,String[]nomCols, String codigo) {
        
        String sql_actualizar="";
        int numFilas = 0;
        
        Programa p = consultarPrograma(codigo+"");
        
        if (p!=null){
            
            for(int i=0;i<valores.length;i++){
                if (valores[i]!=null){
                   
                    sql_actualizar="UPDATE Programa SET "+nomCols[i]+"="+
                            "'"+valores[i]+"'"+" WHERE codigo="+codigo+";";
                    System.out.println(sql_actualizar);
                }
                
                        
            }

           
            try {
                Connection conn = fachada.getConnetion();
                Statement sentencia = conn.createStatement();

                numFilas = sentencia.executeUpdate(sql_actualizar);
                System.out.println("up " + numFilas);
                return numFilas;

            } catch (SQLException e) {
                System.out.println(e);
            } catch (Exception e) {
                System.out.println(e);
            }
           
        }
         return -1;
    }
    

    public void listarProgramas() {
        
    }

    public void borrarPrograma(int codigoPrograma) {
    }

    public void cerrarConexionBD() {
        fachada.closeConection(fachada.getConnetion());
    }
    
    public static void main(String[]args){
        DaoPrograma d = new DaoPrograma();
        String[] a={"Ingenieria de Sistemas","Pregrado","190"};
        String[] b ={"nombre","nivel","num_creditos"};
        d.modificarPrograma(
                a,
                b, 
                 "3702"
        );
    }
}

