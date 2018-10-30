/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
* @author grupo28
 */
public class ClienteData {
    private Connection connection = null;

    public ClienteData(Conexion conectar) {
        try {
            connection = conectar.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
            ex.printStackTrace();
        }
    }
    
    public void guardarCliente(Cliente cliente) {
        try {
            String sql = "INSERT INTO cliente (nombre, n_pasaporte, n_tarjeta) VALUES (? , ? , ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getN_pasaporte());
            ps.setString(3, cliente.getN_tarjeta());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizarCliente(Cliente cliente) {
        try {
            String sql = "UPDATE cliente SET nombre = ?, n_pasaporte = ?, n_tarjeta = ? WHERE id_cliente = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getN_pasaporte());
            ps.setString(3, cliente.getN_tarjeta());
            ps.setInt(4, cliente.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarCliente(int id) {
        try {
            String sql = "DELETE FROM cliente WHERE id_cliente = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Cliente buscarCliente(Cliente cliente) {
        try {
            String sql = "SELECT * FROM cliente WHERE nombre = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ResultSet r = ps.executeQuery();
            
           /*va mientras no if*/
            while(r.next()) {
               cliente.setId(r.getInt(1));
               cliente.setNombre(r.getString(2));
               cliente.setN_pasaporte(r.getString(3));
               cliente.setN_tarjeta(r.getString(4));
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
