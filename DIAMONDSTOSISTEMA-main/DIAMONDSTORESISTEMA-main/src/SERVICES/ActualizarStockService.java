package SERVICES;

import BASEDATOS.AccesoBD;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class ActualizarStockService {

    Connection cn;

    public boolean actualizarStock(String nombreProducto, int nuevoStock) {
        try {
            cn = AccesoBD.getConnection();

            // Llamada al procedimiento almacenado para actualizar el stock
            String sql = "{call pr_ActualizarStock(?, ?)}";
            CallableStatement cstmt = cn.prepareCall(sql);
            cstmt.setString(1, nombreProducto);
            cstmt.setInt(2, nuevoStock);

            int filasAfectadas = cstmt.executeUpdate();

            return filasAfectadas == 1; // Se actualizó el stock si se afecta una fila (el producto existe con el stock actual)
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ActualizarStockService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    
    public boolean actualizarStockDesdePedidos(String nombreProducto) {
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        // Establece la conexión a tu base de datos, cn = ...
        cn = AccesoBD.getConnection();

        // Consulta para obtener la cantidad vendida desde los registros de pedidos
        String consulta = "SELECT SUM(cantidad) AS cantidad_vendida FROM pedidos WHERE nombre = ?";
        pstmt = cn.prepareStatement(consulta);
        pstmt.setString(1, nombreProducto);
        rs = pstmt.executeQuery();

        if (rs.next()) {
            int cantidadVendida = rs.getInt("cantidad_vendida");

            // Llama al procedimiento almacenado ActualizarStock para actualizar el stock
            String procedureCall = "{call pr_ActualizarStockSegunCantidad(?, ?)}";
            CallableStatement cstmt = cn.prepareCall(procedureCall);
            cstmt.setString(1, nombreProducto);
            cstmt.setInt(2, cantidadVendida);

            // Ejecuta el procedimiento
            cstmt.execute();
            
            // La actualización fue exitosa
            return true;
        }
    } catch (SQLException e) {
        // Manejo de excepciones
        e.printStackTrace();
        throw new RuntimeException("Error al actualizar el stock: " + e.getMessage());
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(ActualizarStockService.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (cn != null) {
                cn.close();
            }
        } catch (SQLException e) {
            // Manejo de excepciones
        }
    }
    
    // La actualización no fue exitosa
    return false;
}


}


