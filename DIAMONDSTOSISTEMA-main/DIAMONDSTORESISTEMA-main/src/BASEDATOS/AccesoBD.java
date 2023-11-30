
package BASEDATOS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author analu
 */
public class AccesoBD {
     public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        
        Class.forName(driverClassName);
        
        String connectionURL = "jdbc:sqlserver://MSI\\SQLEXPRESS:1433;databaseName=DIAMONDSTORESYSTEM;user=sa;password=sql;encrypt=true;TrustServerCertificate=true;";
        Connection cn = DriverManager.getConnection(connectionURL);
        
        return cn; 
    }
}
