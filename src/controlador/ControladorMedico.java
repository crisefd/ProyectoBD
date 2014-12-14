/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.DaoEmpleado;
import accesoDatos.DaoMedico;
import java.util.ArrayList;
import java.util.Vector;
import logica.Empleado;
import logica.Medico;

/**
 *
 * @author fabianact
 */
public class ControladorMedico {

    DaoMedico daoMedico;
    
    public ControladorMedico(){
        daoMedico=new DaoMedico();
    }
    
    
    public int  insertarMedico(Medico m){
       // Medico m = new Medico(id_persona, nombre,direccion, telefono,id_area, cargo,email,salario, especializacion, numLicencia, universidad);        
       // m.setPerfilSeguridad("2");
        int result =daoMedico.guardarMedico(m);
        
        return result;

    }//end

    public Medico consultarMedico(String id_medico){
        Medico m = new Medico();
        

        m = daoMedico.consultarMedico(id_medico);
      
       return m;
    }
    
    public ArrayList<Medico> consultarMedicos(){
        Medico m = new Medico();
        

       ArrayList<Medico> lista = daoMedico.consultarMedicos();
      
       return lista;
    }
    

    public void cerrarConexionBD(){
        daoMedico.cerrarConexionBD();
    }

    
//    public static void main(String args[]){
//        ControladorMedico ca = new ControladorMedico();
//        ca.insertarMedico("123", "Fabian", "calle 70", "6620721", "444", "jefe", "fabian@",440000, "ginecologo", "12345", "ICESI");
////System.out.print(ca.consultarCama().obtNombre());
//    }
}
