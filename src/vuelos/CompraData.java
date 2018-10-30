/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuelos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grupo 28
 */
public class CompraData {
    private Connection connection = null;
    
     public CompraData(Conexion conectar) {
        try {
            connection = conectar.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
    
    public void guardarCompra(Compra compra) {
        try {
            String sql = "INSERT INTO compra (id_cliente, id_asiento, fecha, precio) VALUES (? , ? , ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, compra.getId_cliente().getId());
            ps.setInt(2, compra.getId_asiento().getId_asiento());
            ps.setDate(3, Date.valueOf(compra.getFecha()));
            ps.setDouble(4, compra.getPrecio());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                compra.setId_compra(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar una compra");
            }
            ps.close();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
        
    }
     
    
    public void borrarCompra(int id){
        try {
            
            String sql = "DELETE FROM alumno WHERE id =?;";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar una compra: " + ex.getMessage());
        }
        
    
    }
    
    public void actualizarCompra(Compra compra){
    
        try {
            
            String sql = "UPDATE compra SET id_cliente = ? , id_asiento =? , fecha =?, precio =?  WHERE id = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, compra.getId_cliente().getId());
            statement.setInt(2, compra.getId_asiento().getId_asiento());
            statement.setDate(3, Date.valueOf(compra.getFecha()));
            statement.setDouble(4, compra.getPrecio());
            statement.executeUpdate();
            
          
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }
    
    }
    
    public Compra buscarCompra(int id){
    Compra compra=null;
    try {            
            String sql = "SELECT * FROM compra WHERE id =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);                      
            ResultSet resultSet=statement.executeQuery();      
            while(resultSet.next()){
                compra = new Compra();
                compra.setId_compra(resultSet.getInt("id_compra"));
                //compra.setId_cliente(resultSet.getInt(compra.getId_cliente().getId()));
                compra.setFecha(resultSet.getDate("fecha").toLocalDate());
                compra.setPrecio(resultSet.getDouble("precio"));
                //alumno.setActivo(resultSet.getBoolean("activo"));               
            }      
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar una compra: " + ex.getMessage());
        }
        
        return compra;
    }
    
    

   
   
}
