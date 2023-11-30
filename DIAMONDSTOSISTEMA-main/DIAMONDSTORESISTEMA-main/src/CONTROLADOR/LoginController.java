/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import MODELO.Empleados;
import SERVICES.LoginService;
import util.Session;

public class LoginController {

    public void ValidarUsuario(String usuario, String clave) {
        LoginService service = new LoginService();
        Empleados empleado = service.validarUsuario(usuario, clave);
        Session.put("userUsuario", empleado);

    }
}
