package vuelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonathan Saez
 */
public class AsientoData {
    private Connection connection = null;

    public AsientoData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
    public void guardarAsiento(Asiento asiento){
        try {
            String sql = "INSERT INTO asiento (id_vuelo, precio, ubicacion, disponibilidad) VALUES ( ? , ? , ? , ?);";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, asiento.getId_vuelo().getId());
            statement.setDouble(2, asiento.getPrecio());
            statement.setString(3, asiento.getUbicacion());
            statement.setInt(4, asiento.getDisponibilidad());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                asiento.setId_asiento(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un alumno");
            }
            statement.close();
        } catch (SQLException ex){
            System.out.println("Error al insertar un asiento: " + ex.getMessage());
        }
    }
    
      public void actualizarAsiento(Asiento asiento) {
        try {
            String sql = "UPDATE asiento SET id_vuelo = ?, precio = ?, ubicacion = ?, disponibilidad = ? WHERE id_asiento = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, asiento.getId_vuelo().getId());
            ps.setDouble(2, asiento.getPrecio());
            ps.setString(3, asiento.getUbicacion());
            ps.setInt(4, asiento.getDisponibilidad());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AsientoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
      public void eliminarAsiento(int id) {
        try {
            String sql = "DELETE FROM asiento WHERE id_asiento = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AsientoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
       public Asiento buscarAsiento(Asiento asiento) {
        try {
            String sql = "SELECT * FROM asiento WHERE id_asiento = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, asiento.getId_asiento());
            ResultSet r = ps.executeQuery();
            
           /*va mientras no if*/
            while(r.next()) {
               asiento.setId_asiento(r.getInt(1));
               //asiento.setId_vuelo(r.getVuelo(2)); Solucionar
               asiento.setPrecio(r.getDouble(2));
               asiento.setUbicacion(r.getString(3));
               asiento.setDisponibilidad(r.getInt(4));
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AsientoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
}
