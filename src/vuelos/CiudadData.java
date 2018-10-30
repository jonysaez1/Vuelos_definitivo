
package vuelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Grupo 28
 */
public class CiudadData {
    private Connection connection = null;

    public CiudadData(Conexion conectar) {
        try{
            connection = conectar.getConexion();
        } catch(SQLException ex){
             System.out.println("Error al abrir al obtener la conexion");
        }
    }
    public void guardarCiudad(Ciudad ciudad) throws SQLException{
        try{
            String sql = "INSERT INTO ciudad (id, ciudad_origen, ciudad_destino, pais) VALUES (? , ? , ? , ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, ciudad.getId());
            ps.setString(2, ciudad.getCiudad_origen());
            ps.setString(3, ciudad.getCiudad_destino());
            ps.setInt(4, ciudad.getPais());
            ps.execute();
            ps.close();    
        } catch(SQLException ex){
            Logger.getLogger(ClienteData.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public void actualizarCiudad(Ciudad ciudad){
        try {
            String sql = "UPDATE ciudad SET ciudad_origen = ?, ciudad_destino = ?, pais = ? WHERE id = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ciudad.getCiudad_origen());
            ps.setString(2, ciudad.getCiudad_destino());
            ps.setInt(3, ciudad.getPais());
            ps.setInt(4, ciudad.getId());
            ps.executeUpdate();
            ps.close();
        
        } catch (SQLException ex) {
            Logger.getLogger(CiudadData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       /* public void actualizarCliente(Cliente cliente) {
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
    }*/
        
       
    }
    public void eliminarCiudad(int id){
        try {
            String sql = "DELETE FROM ciudad WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CiudadData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public Ciudad buscarCiudad(Ciudad ciudad){
        try {
            String sql = "SELECT * FROM ciudad WHERE ciudad_origen = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ciudad.getCiudad_origen());
            ResultSet r = ps.executeQuery();
       
            while(r.next()) {
            ciudad.setId(r.getInt(1));
            ciudad.setCiudad_origen(r.getString(2));
            ciudad.setCiudad_destino(r.getString(3));
            ciudad.setPais(r.getInt(4));
            }
            ps.close();
         } catch (SQLException ex) {
            Logger.getLogger(CiudadData.class.getName()).log(Level.SEVERE, null, ex);
         }
            return null;
    }
}    
        