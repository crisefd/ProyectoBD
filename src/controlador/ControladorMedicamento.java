/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import logica.Medicamento;
import accesoDatos.DaoMedicamento;

/**
 *
 * @author Shaitan
 */
public class ControladorMedicamento {
    
    DaoMedicamento daoMedicamento;
    public int  insertarMedicamento(String id_med, String nombre,String descripcion, double costo){
        Medicamento med = new Medicamento(id_med, nombre,descripcion, costo);        

       
        
        int result =daoMedicamento.guardarMedicamento(med);

        
        return result;  

    }
    public ArrayList<Medicamento> consultarMedicamentoPorID(String id_med){
        
        ArrayList<Medicamento> med= daoMedicamento.consultarMedicamentoPorID(id_med);
      
       return med;
    }
    public ArrayList<Medicamento> consultarMedicamentoPorNombre(String nombre_med){
        
        ArrayList<Medicamento> med= daoMedicamento.consultarMedicamentoPorNombre(nombre_med);
      
       return med;
    }
}
