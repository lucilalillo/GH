/*
 * private int idTipoHabitacion;
    private String descripcion;
    private double precio;
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
public class TipoHabitacionData {
    Connection con= null;       
      Conexion conexion;
    
    
    public TipoHabitacionData(Conexion conexion){
        try {
            con= conexion.getConexion();
            this.conexion=conexion;
           
        } catch (SQLException ex) {
            Logger.getLogger(TipoHabitacionData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void guardarTipoHabitacion(TipoHabitacion tipoHabitacion){   
        String sql="INSERT INTO tipo_habitacion(DESCRIPCION, PRECIO, NUMERO) VALUES (?,?,?)";
        
            try (PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, tipoHabitacion.getDescripcion());
                ps.setDouble(2, tipoHabitacion.getPrecio());
                ps.setInt(3, tipoHabitacion.getNumero().getNumero());
                                                        
                ps.executeUpdate();     
                ResultSet rs= ps.getGeneratedKeys();    
                
                if(rs.next()){  
                     tipoHabitacion.getIdTipoHabitacion(); 
                    
                }else{
                    System.out.println("No se pudo obtener el ID del tipo de habitacion " );
                }
                
                ps.close();
            
        }catch(SQLException ex){
                System.out.println("Error al ingresar el tipo de habitacion");
        }
        
    }
    public List<TipoHabitacion> obtenerTipoHabitacion(){
        List<TipoHabitacion> tipoHabitaciones = new ArrayList<TipoHabitacion>();  
        try {          
            String sql=("SELECT * FROM tipo_habitacion") ;
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();         
            
            TipoHabitacion tipoHabitacion;  
            while(rs.next()){   
              tipoHabitacion= new TipoHabitacion();
              tipoHabitacion.setIdTipoHabitacion(rs.getInt(1));
              tipoHabitacion.setDescripcion(rs.getString(2));
              tipoHabitacion.setPrecio(rs.getDouble(3));
              Habitacion numero = buscarHabitacion(rs.getInt(2));
              tipoHabitacion.setNumero(numero);
               
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            System.out.println("Error al listar tipo de habitacion" );
        }
        return tipoHabitaciones;
    }
    
    
    public TipoHabitacion buscarTipoHabitacion(int IdTipoHabitacion){     
        TipoHabitacion tipoHabitacion = null;                   
        try {
        String sql=("SELECT * FROM tipo_habitacion WHERE ID_TIPOHABITACION=?");
        PreparedStatement ps = con.prepareStatement(sql) ;
        ps.setInt(1, IdTipoHabitacion);                
        ResultSet rs= ps.executeQuery();       
                                               
        while(rs.next()){
            tipoHabitacion= new TipoHabitacion();       
            tipoHabitacion.setIdTipoHabitacion(rs.getInt(1));
            tipoHabitacion.setDescripcion(rs.getString(2));  
            tipoHabitacion.setPrecio(rs.getDouble(3));
            Habitacion numero = buscarHabitacion(rs.getInt(2));
              tipoHabitacion.setNumero(numero);
            
        }
        ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar el tipo de habitacion");
        }
        return tipoHabitacion;      
        
    }
     public Habitacion buscarHabitacion(int numero){     
       
        HabitacionData Hd= new HabitacionData(conexion);    
        return Hd.buscarHabitacion(numero);
    }
    
    
    public void borrarTipoHabitacion(int IdTipoHabitacion){
        try {
            String sql="DELETE FROM tipo_habitacion WHERE ID_TIPOHABITACION=?";
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, IdTipoHabitacion);
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("error al BORRAR un tipo de habitacion");
        }
    }
}
