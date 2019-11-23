/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class GH {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try {
            Conexion con = new Conexion();
            
            Huesped h1 =new Huesped("SEBASTIAN SALAZAR","MITRE 43",24356745,15433243,"LASLYCOSTA@GMAIL.COM");
            HuespedData Hd= new HuespedData(con);
            //Hd.guardarHuesped(h1);
            
            Habitacion hab = new Habitacion(3,"libre","simple");
            HabitacionData habdata = new HabitacionData(con);
            //habdata.guardarHabitacion(hab);
            
            
            
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(GH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
