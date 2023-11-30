package SERVICES;

import BASEDATOS.AccesoBD;
import MODELO.Producto;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultarProductosService {

   public List<Producto> getProducto(String nombre) {
    List<Producto> lista = new ArrayList<>();
    Connection cn = null;

    // Usamos el nombre del procedimiento almacenado en la base de datos
    String sql = "{call pa_selectProducto(?)}"; // Se agrega el parámetro ?

    CallableStatement cstmt = null;
    ResultSet rs = null;
    nombre = "%" + nombre.trim() + "%"; // Se corrige la formación del patrón LIKE

    try {
        cn = AccesoBD.getConnection();
        cstmt = cn.prepareCall(sql);

        // Se asigna el valor del parámetro @nombre
        cstmt.setString(1, nombre);

        rs = cstmt.executeQuery();
        while (rs.next()) {
            Producto producto = new Producto();
            producto.setNombre(rs.getString("nombre"));
            producto.setCategoria(rs.getInt("id_cate"));
            producto.setPrecio(rs.getDouble("precio"));
            producto.setStock(rs.getInt("stock"));

            producto.setImagen(rs.getBytes("imagen"));

            lista.add(producto);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException(e.getMessage());
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(ConsultarProductosService.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (cstmt != null) {
                cstmt.close();
            }
            if (cn != null) {
                cn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    return lista;
}


    

    public boolean eliminarProducto(String nombreProducto) {
        Connection cn = null;
        String sql = "{call pa_eliminarProducto(?)}";

        try {
            try {
                cn = AccesoBD.getConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConsultarProductosService.class.getName()).log(Level.SEVERE, null, ex);
            }
            CallableStatement cstmt = cn.prepareCall(sql);
            cstmt.setString(1, nombreProducto); // Pasar el nombre del producto como argumento

            int filasAfectadas = cstmt.executeUpdate();

            return filasAfectadas == 1; // Devuelve true si se eliminó correctamente
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
