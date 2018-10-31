/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuelos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Grupo 28
 */
public class VueloData {
    private Connection connection = null;

    public VueloData(Conexion conectar) {
        try {
            connection = conectar.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
    
    public void guardarVuelo(Vuelo vuelo){
        try {
            String url = "INSERT INTO vuelo (aerolinea, aeronave, fecha_llegada, fecha_partida, id_ciudad, id_ciudad_destino) VALUES (? , ? , ? , ? , ? , ?)";
            PreparedStatement ps = connection.prepareStatement(url);
            ps.setString(1, vuelo.getAerolinea());
            ps.setString(2,vuelo.getAeronave());
            ps.setDate(3, Date.valueOf(vuelo.getFecha_llegada()));
            ps.setDate(4, Date.valueOf(vuelo.getFecha_partida()));
            ps.setInt(5, vuelo.getId_ciudad().getId());
            ps.setInt(6, vuelo.getId_ciudad_destino().getId());
            ps.executeUpdate();
            
        } catch(SQLException ex){
            
        }
    }
    
        public void actualizarCliente(Vuelo vuelo) {
        try {
            String sql = "UPDATE vuelo SET aerolinea = ?, aeronave = ?, fecha_llegada = ?, fecha_partida = ?, id_ciudad = ?, id_ciudad_destino = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, vuelo.getAerolinea());
            ps.setString(2, vuelo.getAeronave());
            ps.setDate(3, Date.valueOf(vuelo.getFecha_llegada()));
            ps.setDate(4, Date.valueOf(vuelo.getFecha_partida()));
            ps.setInt(5, vuelo.getId_ciudad().getId());
            ps.setInt(6, vuelo.getId_ciudad_destino().getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(VueloData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public void eliminarVuelo(int id) {
        try {
            String sql = "DELETE FROM cliente WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(VueloData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    
    
}
