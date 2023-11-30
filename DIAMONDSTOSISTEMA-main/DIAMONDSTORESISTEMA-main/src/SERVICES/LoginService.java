package SERVICES;

import BASEDATOS.AccesoBD;
import MODELO.Empleados;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {

    public Empleados validarUsuario(String usuario, String clave) {
    Connection cn = null;
    CallableStatement cstmt = null;
    ResultSet rs = null;
    Empleados empleado = null;
    String LLAMAR_USUARIO = "{call pr_LlamarUsuario(?, ?)}";

    try {
        cn = AccesoBD.getConnection();

        cstmt = cn.prepareCall(LLAMAR_USUARIO);
        cstmt.setString(1, usuario);
        cstmt.setString(2, clave);

        rs = cstmt.executeQuery();

        if (!rs.next()) {
            throw new SQLException("Datos incorrectos");
        }

        empleado = new Empleados();
        empleado.setId(rs.getInt("userid"));
        empleado.setApellido(rs.getString("userapellido"));
        empleado.setNombre(rs.getString("usernombre"));
        empleado.setSexo(rs.getString("usersexo"));
        empleado.setTurno(rs.getString("userTurno"));
        empleado.setUsuario(rs.getString("userUsuario"));

    } catch (SQLException e) {
        throw new RuntimeException("Error al ejecutar la consulta: " + e.getMessage(), e);
    } catch (Exception e) {
        throw new RuntimeException("Error en el proceso, inténtelo nuevamente.", e);
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
            // Manejo de excepciones al cerrar recursos
        }
    }
    return empleado;
}

}
