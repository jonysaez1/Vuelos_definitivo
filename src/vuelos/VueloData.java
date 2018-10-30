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
            String url = "INSERT INTO vuelo (aerolinea, aeronave, fecha_llegada, fecha_partida, id_ciudad, id_destino) VALUES (? , ? , ? , ? , ? , ?)";
            PreparedStatement ps = connection.prepareStatement(url);
            ps.setString(1, vuelo.getAerolinea());
            ps.setString(2,vuelo.getAeronave());
            ps.setDate(3, Date.valueOf(vuelo.getFecha_llegada()));
            ps.setDate(4, Date.valueOf(vuelo.getFecha_partida()));
            ps.setInt(5, vuelo.getId_ciudad().getId());
            ps.setInt(6, vuelo.getId_ciudad_origen().getId());
            ps.executeUpdate();
            
        } catch(SQLException ex){
            
        }
    }
 
    
    
}
