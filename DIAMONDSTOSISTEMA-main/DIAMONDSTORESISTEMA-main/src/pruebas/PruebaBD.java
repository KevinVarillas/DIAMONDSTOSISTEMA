package pruebas;

import BASEDATOS.AccesoBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PruebaBD {

    public static void main(String[] args) {
        Connection cn = null;
        
        try {
            cn = AccesoBD.getConnection();
            System.out.println("Conexión exitosa.");

            Statement statement = cn.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT name FROM sys.tables");

            System.out.println("Tablas en la base de datos:");

            // Recorrer los resultados y mostrar los nombres de las tablas
            while (resultSet.next()) {
                String tableName = resultSet.getString("name");
                System.out.println(tableName);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close(); // Cierra la conexión
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}