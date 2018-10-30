
package vuelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Grupo 28
 */
public class Conexion {
    private String url; 
    private String user;
    private String password; 
    private Connection conectar;
    
    public Conexion(String url, String user, String password) throws ClassNotFoundException {
        this.url = url;
        this.user = user;
        this.password = password;
        
        //Se cargan las clases que implementan JDBC
        Class.forName("org.mariadb.jdbc.Driver");
       
    }
    
    public Connection getConexion() throws SQLException{
        if(conectar == null){
       
                    // Setup the connection with the DB
            conectar = DriverManager
                .getConnection(url + "?useLegacyDatetimeCode=false&serverTimezone=UTC"
                        + "&user=" + user + "&password=" + password);
            System.out.println("Conexion establecida"); // informo que la conexion fue exitosa
           
        }
        
        return conectar;
    }
}
