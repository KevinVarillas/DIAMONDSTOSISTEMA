
package CONTROLADOR;

import SERVICES.RegistrarCategoriaService;

public class RegistrarCategoriaController {

    private RegistrarCategoriaService service;

    public RegistrarCategoriaController() {
        this.service = new RegistrarCategoriaService();
    }

    public int registrarCategoria(String nombre) {

        return service.registrarCategoria(nombre);
    }
}
