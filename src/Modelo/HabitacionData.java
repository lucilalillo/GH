/*
 * private int numero, piso;
    private String estado;
    private TipoHabitacion tipoHabitacion;
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class HabitacionData {  
    Connection con= null;       
    Conexion conexion;
    
    public HabitacionData(Conexion conexion){
        
        try {                                                     
            con= conexion.getConexion();
            this.conexion=conexion;
            
        } catch (SQLException ex) {
            Logger.getLogger(HabitacionData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void guardarHabitacion(Habitacion habitacion){   
        String sql="INSERT INTO habitacion(NUMERO,PISO, ESTADO, TIPOHABITACION) VALUES (?,?,?,?)";
        
            try (PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
                ps.setInt(1, habitacion.getNumero());
                ps.setInt(2,habitacion.getPiso());
                ps.setString(3,habitacion.getEstado());
                ps.setString(4, habitacion.getTipoHabitacion());// pido que devuelva la lista de clave de huesped(con Statement)
                                                             
                ps.executeUpdate();     
                ResultSet rs= ps.getGeneratedKeys();    
                
                /* if(rs.next()){  
                   habitacion.getNumero(); 
                    
               }else{
                   System.out.println("No se pudo obtener el Numero de habitacion " );
                }
                */
                ps.close();
            
        }catch(SQLException ex){
                System.out.println("Error al ingresar una habitacion");
        }
        
    }
    
    public List<Habitacion> obtenerHabitacion(){
        List<Habitacion> habitaciones = new ArrayList<Habitacion>();  
        try {          
            String sql=("SELECT * FROM habitacion") ;
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();        
            
            Habitacion habitacion;  
            while(rs.next()){   
                habitacion=new Habitacion();        
                habitacion.setNumero(rs.getInt(1));
                habitacion.setPiso(rs.getInt(2));
                habitacion.setEstado(rs.getString(3));
                habitacion.setTipoHabitacion(rs.getString(4));
                        
                habitaciones.add(habitacion);       
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            System.out.println("Error al listar una habitacion" );
        }
        return habitaciones;
    }
    
    
    public Habitacion buscarHabitacion(int numero){   
        Habitacion habitacion = null;                  
        try {
        String sql=("SELECT * FROM habitacion WHERE NUMERO=?");
        PreparedStatement ps = con.prepareStatement(sql) ;
        ps.setInt(1, numero);                
        ResultSet rs= ps.executeQuery();        
        
        while(rs.next()){
            habitacion= new Habitacion();       
            habitacion.getNumero();
            habitacion.setPiso(rs.getInt(2));
            habitacion.setEstado(rs.getString(3));
            habitacion.setTipoHabitacion(rs.getString(4));
          
        }
        ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar habitacion");
        }
        return habitacion;      
    }
    public void actualizarHabitacion(Habitacion habitacion){
        try {
            
            String sql=("UPDATE habitacion SET PISO=?, ESTADO=?, TIPOHABITACION=? WHERE NUMERO=?");
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, habitacion.getPiso());
            ps.setString(2,habitacion.getEstado());
            ps.setString(3, habitacion.getTipoHabitacion());
            
            ps.executeUpdate(); 
            
            ps.close();
        } catch (SQLException ex) {
            
            System.out.println("Error al ACTUALIZAR habitacion ");
        }
        
    }
    
    
    public void borrarHabitacion(int numero){
        try {
            String sql="DELETE FROM habitacion WHERE NUMERO =?";
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, numero);
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("error al BORRAR una habitacion");
        }
    }
}

