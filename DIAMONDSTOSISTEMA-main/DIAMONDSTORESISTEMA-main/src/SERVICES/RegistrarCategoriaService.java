
package SERVICES;
import BASEDATOS.AccesoBD;
import MODELO.Categoria;
import MODELO.Producto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrarCategoriaService {
    
     Connection cn;

    public int registrarCategoria(String nombre) {
        int estado = 1;
        CallableStatement cstmt = null;

        try {
            cn = AccesoBD.getConnection();

            String INSERT_CATEGORIA = "{call pr_InsertarCategoria(?)}";
            cstmt = cn.prepareCall(INSERT_CATEGORIA);
            cstmt.setString(1, nombre);

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
}

