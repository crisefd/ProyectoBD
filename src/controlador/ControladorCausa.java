/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.DaoCausa;
import logica.Causa;
import logica.Cita;

/**
 *
 * @author crisefd
 */
public class ControladorCausa {
    DaoCausa daoCausa;
    
    public ControladorCausa(){
        daoCausa = new DaoCausa();
    }
    public int insertarCausas(Causa []causas, Cita cita){
        int n = 0;
        for(Causa causa: causas){
             n = daoCausa.guardarCausa(cita, causa);
            if(n == -1){
                System.out.println("Error, al ingresar causa");
                break;
            }
        }
        return n;
    }
}
