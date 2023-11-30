package CONTROLADOR;
import SERVICES.ActualizarStockService;

public class ActualizarStockController {
    ActualizarStockService act;

    public ActualizarStockController(ActualizarStockService act) {
        this.act = act;
    }

    public boolean actualizarStock(String nombre, int nuevoStock) {
        if (act == null) {
            // Manejo de error, si es necesario
        }

        // El parámetro stockActual no se utiliza aquí, ya que el servicio solo requiere nombreProducto y nuevoStock.
        return act.actualizarStock(nombre, nuevoStock);
    }
    
    
    public boolean  actualizarStockDesdePedidos(String nombreProducto) {
       
     if (act == null) {
            // Manejo de error, si es necesario
        }

        // El parámetro stockActual no se utiliza aquí, ya que el servicio solo requiere nombreProducto y nuevoStock.
        return act.actualizarStockDesdePedidos(nombreProducto);
    
}

}