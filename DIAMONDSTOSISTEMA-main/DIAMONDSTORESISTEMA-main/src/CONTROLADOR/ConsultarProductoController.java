package CONTROLADOR;

import MODELO.Producto;
import SERVICES.ConsultarProductosService;

import java.util.List;

public class ConsultarProductoController {

    public List<Producto> getProducto(String nombre)  {
        ConsultarProductosService service = new ConsultarProductosService();
        return service.getProducto(nombre);
    }
 
    public boolean eliminarProducto(String nombreProducto)  {
                ConsultarProductosService service = new ConsultarProductosService();

        return service.eliminarProducto(nombreProducto);
    }


}
