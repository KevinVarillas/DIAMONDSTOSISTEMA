package SERVICES;

import BASEDATOS.AccesoBD;
import MODELO.Pedido;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistroPedidoService {

    Connection cn;
    public int registrarPedido(String ClienteName, String producto, int cantidad, double precio, double total , String metodoPago) {
        int estado = 1;
        CallableStatement cstmt = null;

        try {
            // 1.- Conexión a la base de datos
            cn = AccesoBD.getConnection();
            cn.setAutoCommit(false);

            if (!validarProducto(producto)) {
                // Si la categoría no existe, puedes manejar el error o lanzar una excepción.
                estado = -1;
                throw new RuntimeException("El producto especificado no existe.");
            }

            // 3.- Llamar al procedimiento almacenado para insertar el pedido
            String INSERT_PEDIDO = "{call pr_InsertarPedido(?, ?, ?, ?, ?, ?)}";
            cstmt = cn.prepareCall(INSERT_PEDIDO);
            cstmt.setString(1, ClienteName);
            cstmt.setString(2, producto);
            cstmt.setInt(3, cantidad);
            cstmt.setDouble(4, precio);
            cstmt.setDouble(5, total);
            cstmt.setString(6, metodoPago);

            cstmt.execute();

            // No es necesario recuperar el ID del pedido insertado, ya que es una columna de identidad
            cn.commit();
        } catch (SQLException e) {
            try {
                cn.rollback(); // Cancela todos los cambios
            } catch (SQLException e1) {
                // Manejo de excepciones
            }
            estado = -1;
            throw new RuntimeException(e);
        } catch (Exception e) {
            try {
                cn.rollback(); // Cancela todos los cambios
            } catch (SQLException e1) {
                // Manejo de excepciones
            }
            estado = -1;
            String s = "Error en el proceso, inténtelo más tarde.";
            throw new RuntimeException(s);
        } finally {
            try {
                if (cstmt != null) {
                    cstmt.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                // Manejo de excepciones
            }
        }
        return estado;
    }

    private boolean validarProducto(String producto) {

        return true; // Reemplaza con la lógica real de validación
    }

 
    
  

}
