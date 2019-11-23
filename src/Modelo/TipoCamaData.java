/*
 * private int idTipoCama;
    private String tipo;
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
public class TipoCamaData {
    Connection con= null; 
   
    
    public TipoCamaData(Conexion conexion){
        try {
            con= conexion.getConexion();
     
        } catch (SQLException ex) {
            Logger.getLogger(TipoCamaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void guardarTipoCama(TipoCama tipoCama){   
        String sql="INSERT INTO tipo_cama(TIPO) VALUES (?)";
        
            try (PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1,tipoCama.getTipo());
                                                        
                ps.executeUpdate();     
                ResultSet rs= ps.getGeneratedKeys();    
                
                if(rs.next()){  
                    tipoCama.getIdTipoCama(); 
                    
                }else{
                    System.out.println("No se pudo obtener el ID del tipo cama " );
                }
                
                ps.close();
            
        }catch(SQLException ex){
                System.out.println("Error al ingresar el tipo cama");
        }
        
    }
    
    public List<TipoCama> obtenerTipoCama(){
        List<TipoCama> tipoCamas = new ArrayList<TipoCama>();  
        try {          
            String sql=("SELECT * FROM tipo_cama") ;
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();         
            
            TipoCama tipoCama;  
            while(rs.next()){   
              tipoCama= new TipoCama();
              tipoCama.setIdTipoCama(rs.getInt(1));
              tipoCama.setTipo(rs.getString(2));
                     
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            System.out.println("Error al listar tipo cama" );
        }
        return tipoCamas;
    }
    
    
    public TipoCama buscarTipoCama(int idTipoCama){     
        TipoCama tipoCama = null;                   
        try {
        String sql=("SELECT * FROM tipo_cama WHERE ID_TIPOCAMA=?");
        PreparedStatement ps = con.prepareStatement(sql) ;
        ps.setInt(1, idTipoCama);                
        ResultSet rs= ps.executeQuery();       
                                               
        while(rs.next()){
            tipoCama= new TipoCama();       
            tipoCama.setIdTipoCama(rs.getInt(1));
            tipoCama.setTipo(rs.getString(2));            
        }
        ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar tipo cama");
        }
        return tipoCama;      
        
    }
    
    public void actualizarTipoCama(TipoCama tipoCama){
        try {
            
            String sql=("UPDATE tipo_cama SET TIPO=?, WHERE ID_TIPOCAMA=?");
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1,tipoCama.getTipo());
            ps.setInt(2, tipoCama.getIdTipoCama());
               
            ps.executeUpdate(); 
                                
            ps.close();
        } catch (SQLException ex) {
            
            System.out.println("Error al ACTUALIZAR tipo cama ");
        }
        
    }
    
    
    public void borrarTipoCama(int idTipoCama){
        try {
            String sql="DELETE FROM tipo_cama WHERE ID_TIPOCAMA=?";
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, idTipoCama);
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("error al BORRAR un tipo cama");
        }
    }
}
