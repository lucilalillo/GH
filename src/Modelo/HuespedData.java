/*
 * private int id_Huesped, dni, celular;
   private String nombre, domicilio, correo;
 */
package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class HuespedData {
    private Connection connection = null;

    public HuespedData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
    
    
    public void guardarHuesped(Huesped huesped){
        try {
            
            String sql = "INSERT INTO huesped (NOMBRE, DOMICILIO, DNI,CELULAR,CORREO) VALUES ( ?,?,?,?,? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, huesped.getNombre());
            statement.setString(2, huesped.getDomicilio());
            statement.setInt(3, huesped.getDni());
            statement.setInt(4, huesped.getCelular());
            statement.setString(5, huesped.getCorreo());
            
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                huesped.setId_Huesped(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un huesped");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un huesped: " + ex.getMessage());
        }
    }
    
    public List<Huesped> obtenerHuesped(){
       List<Huesped> huespedes = new ArrayList<Huesped>();
            

        try {
            String sql = "SELECT * FROM huesped;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Huesped huesped;
            while(resultSet.next()){
                huesped = new Huesped();
                huesped.setId_Huesped(resultSet.getInt("ID_HUESPED"));
                huesped.setNombre(resultSet.getString("NOMBRE"));
                huesped.setDomicilio(resultSet.getString("DOMICILIO"));
                huesped.setDni(resultSet.getInt("DNI"));
                huesped.setCelular(resultSet.getInt("CELULAR"));              
                huesped.setCorreo(resultSet.getString("CORREO"));
               

                huespedes.add(huesped);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los huespedes: " + ex.getMessage());
        }
        
        
        return huespedes;
    }
    
    public void borrarHuesped(int id_Huesped){
    try {
            
            String sql = "DELETE FROM huesped WHERE ID_HUESPED =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id_Huesped);
           
            
            statement.executeUpdate();
            
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un huesped: " + ex.getMessage());
        }
        
    
    }
    
    public void actualizarHuesped(Huesped huesped){
    
        try {
            
            String sql = "UPDATE huesped SET NOMBRE = ?, DOMICILIO = ?, DNI = ?, CELULAR = ?, CORREO = ? WHERE ID_HUESPED = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(3, huesped.getNombre());
            statement.setString(4, huesped.getDomicilio());
            statement.setInt(1, huesped.getDni());
            statement.setInt(2, huesped.getCelular());
            statement.setString(5, huesped.getCorreo());
            statement.setInt(6, huesped.getId_Huesped());
            statement.executeUpdate();
            
          
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un huesped: " + ex.getMessage());
        }
    
    }
    
    public Huesped buscarHuesped(int id_Huesped){
    Huesped huesped=null;
    try {
            
            String sql = "SELECT * FROM huesped WHERE ID_HUESPED =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id_Huesped);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                huesped = new Huesped();
                huesped.setId_Huesped(resultSet.getInt("ID_HUESPED"));
                huesped.setNombre(resultSet.getString("NOMBRE"));
                huesped.setDomicilio(resultSet.getString("DOMICILIO"));
                huesped.setDni(resultSet.getInt("DNI"));
                huesped.setCelular(resultSet.getInt("CELULAR"));
                huesped.setCorreo(resultSet.getString("CORREO"));
    
            }      
            statement.close();
     
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un huesped: " + ex.getMessage());
        }
        
        return huesped;
    }
    
}

