package SERVICES;

import BASEDATOS.AccesoBD;
import MODELO.Categoria;
import MODELO.Producto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistroProductoService {

    Connection cn;

    Categoria cate = new Categoria();

    Producto p = new Producto();

    public int registroProducto(String nombre, int categoria, double precio, int stock, Producto imagen) {
        int estado = 1;
        CallableStatement cstmt = null;

        try {
            cn = AccesoBD.getConnection();
            if (!validarCategoriaExistente(categoria)) {
                // Si la categoría no existe, puedes manejar el error o lanzar una excepción.
                estado = -1;
                throw new RuntimeException("La categoría especificada no existe.");
            }
            String INSERT_PRODUCTO = "{call pr_InsertarProducto(?, ?, ?, ?, ?)}";

            cstmt = cn.prepareCall(INSERT_PRODUCTO);
            cstmt.setString(1, nombre);
            cstmt.setInt(2, categoria);
            cstmt.setDouble(3, precio);
            cstmt.setInt(4, stock);
            cstmt.setBytes(5, imagen.getImagen());

            cstmt.execute();
            cn.commit();
        } catch (SQLException e) {
            try {
                cn.rollback();
            } catch (SQLException e1) {
                estado = -1;
                throw new RuntimeException(e);
            }
            estado = -1;
            throw new RuntimeException(e);
        } catch (Exception e) {
            try {
                cn.rollback();
            } catch (SQLException e1) {
                estado = -1;
                throw new RuntimeException("Error en el proceso, inténtelo más tarde.");
            }
            estado = -1;
            throw new RuntimeException("Error en el proceso, inténtelo más tarde.");
        } finally {
            try {
                if (cstmt != null) {
                    cstmt.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                estado = -1;
                throw new RuntimeException(e);
            }
        }
        return estado;
    }

    private boolean validarCategoriaExistente(int categoria) {
        // Lógica para verificar si la categoría existe en la base de datos.
        // Debes implementar esta lógica para comprobar la existencia de la categoría.
        // Retorna true si existe, de lo contrario, retorna false.
        return true; // Reemplaza con la lógica real de validación
    }

}
