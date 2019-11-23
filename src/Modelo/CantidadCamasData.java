/*
 * private TipoHabitacion idTipoHab;
    private TipoCama idTipoCama;
    private int cant; 
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
public class CantidadCamasData {
    Connection con= null;       
    Conexion conexion;
    
    public CantidadCamasData(Conexion conexion){
        try {
            con= conexion.getConexion();
            this.conexion=conexion;
        } catch (SQLException ex) {
            Logger.getLogger(CantidadCamasData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void guardarCantidadCamas(CantidadCamas cantidadCamas){   
        String sql="INSERT INTO cantidad_camas(TIPO HABITACION, TIPO CAMA, CANTIDAD) VALUES (?,?,?)";
        
            try (PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, cantidadCamas.getTipoHabitacion().getIdTipoHabitacion());
                ps.setInt(2, cantidadCamas.getTipoCama().getIdTipoCama());
                ps.setInt(3, cantidadCamas.getCant());
                
                ps.executeUpdate();     
                ResultSet rs= ps.getGeneratedKeys();    
   
                ps.close();
            
        }catch(SQLException ex){
                System.out.println("Error al ingresar la cantidad de camas");
        }
        
    }
    
    public List<CantidadCamas> obtenerCantidadCamas(){
        List<CantidadCamas> cantidadDeCamas = new ArrayList<CantidadCamas>();  
        try {          
            String sql=("SELECT * FROM cantidad_camas") ;
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();         
            
            CantidadCamas cantidadCamas;  
            while(rs.next()){   
            cantidadCamas= new CantidadCamas();
            TipoHabitacion tipoHabitacion = buscarTipoHabitacion(rs.getInt(1));
            cantidadCamas.setTipoHabitacion(tipoHabitacion);
            
            TipoCama tipoCama=buscarTipoCama(rs.getInt(2));   
            cantidadCamas.setTipoCama(tipoCama);
            
            cantidadCamas.setCant(rs.getInt(3));
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            System.out.println("Error al listar cantidad de camas" );
        }
        return cantidadDeCamas;
    }
    
    
    public CantidadCamas buscarCantidadCamas(int Cant){     
        CantidadCamas cantidadCamas = null;                   
        try {
        String sql=("SELECT * FROM cantidad_camas WHERE CANTIDAD=?");
        PreparedStatement ps = con.prepareStatement(sql) ;
                      
        ResultSet rs= ps.executeQuery();       
                                               
        while(rs.next()){
            cantidadCamas = new CantidadCamas();       
            
            TipoCama tc=buscarTipoCama(rs.getInt(1));
            cantidadCamas.setTipoCama(tc);
            
            TipoHabitacion th = buscarTipoHabitacion(rs.getInt(2));
            cantidadCamas.setTipoCama(tc);  
            
            cantidadCamas.setCant(rs.getInt(3));
            
        }
        ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar cantidad de camas");
        }
        return cantidadCamas;      
        
    }
    public TipoCama buscarTipoCama(int id_TipoCama){     
       
        TipoCamaData tcd= new TipoCamaData(conexion);    
        return tcd.buscarTipoCama(id_TipoCama);
    }
    public TipoHabitacion buscarTipoHabitacion(int idTipoHabitacion){     
       
        TipoHabitacionData thd= new TipoHabitacionData(conexion);    
        return thd.buscarTipoHabitacion(idTipoHabitacion);
    }
  
    public void actualizarCantidadCamas(CantidadCamas cantidadCamas){
        try {
            
            String sql=("UPDATE cantidad_camas SET Tipo Cama=?, Tipo habitacion=?, WHERE Cant=?");
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, cantidadCamas.getTipoHabitacion().getIdTipoHabitacion());
            ps.setInt(2, cantidadCamas.getTipoCama().getIdTipoCama());
            ps.setInt(3, cantidadCamas.getCant());
               
            ps.executeUpdate(); 
                                
            ps.close();
        } catch (SQLException ex) {
            
            System.out.println("Error al ACTUALIZAR la cantidad de camas ");
        }
        
    }
    
    
    public void borrarCantidadCamas(int Cant){
        try {
            String sql="DELETE FROM cantidad_camas WHERE Cant=?";
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, Cant);
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("error al BORRAR una cantidad de camas");
        }
    }
}
