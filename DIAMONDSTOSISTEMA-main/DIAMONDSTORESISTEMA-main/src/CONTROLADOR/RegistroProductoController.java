
package CONTROLADOR;
import MODELO.Producto;
import SERVICES.RegistroProductoService;

public class RegistroProductoController {
    RegistroProductoService pro;

    public RegistroProductoController(RegistroProductoService pro) {
        this.pro = pro;
    }

    public int registroProducto(String nombre, int categoria, double precio, int stock, Producto imagen) {
        if (pro == null) {
            // Manejar el caso en el que 'pro' sea nulo (si es necesario).
            return -1;
        }

        return pro.registroProducto(nombre, categoria, precio, stock, imagen);
    }
}
