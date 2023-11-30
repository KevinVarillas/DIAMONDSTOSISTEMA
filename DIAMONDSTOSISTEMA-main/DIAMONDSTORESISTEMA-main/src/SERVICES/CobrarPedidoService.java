
package SERVICES;

import BASEDATOS.AccesoBD;
import MODELO.Pedido;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CobrarPedidoService {
    
     public List<Pedido> getPedido(String ClienteName) {
        List<Pedido> lista = new ArrayList<>();
        Connection cn = null;

        // Usamos el nombre del procedimiento almacenado en la base de datos
        String sql = "{call pa_selectPedido}";

        CallableStatement cstmt = null;
        ResultSet rs = null;
        ClienteName = "%%" + ClienteName.trim() + "%%";

        try {
            cn = AccesoBD.getConnection();
            cstmt = cn.prepareCall(sql);

            rs = cstmt.executeQuery();
            while (rs.next()) {
                Pedido pedi = new Pedido();
                pedi.setClienteName(rs.getString("nombreCliente"));
                pedi.setProducto(rs.getString("nombre"));
                pedi.setCantidad(rs.getInt("cantidad"));
                pedi.setPrecio(rs.getDouble("precio"));

                pedi.setTotal(rs.getDouble("total"));

                lista.add(pedi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CobrarPedidoService.class.getName()).log(Level.SEVERE, null, ex);
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
     
     
     
      public boolean eliminarPedido(String ClienteName) {
        Connection cn = null;
        String sql = "{call  pa_eliminarPedido(?)}";

        try {
            try {
                cn = AccesoBD.getConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConsultarProductosService.class.getName()).log(Level.SEVERE, null, ex);
            }
            CallableStatement cstmt = cn.prepareCall(sql);
            cstmt.setString(1, ClienteName); // Pasar el nombre del producto como argumento

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