
package CONTROLADOR;

import SERVICES.RegistroPedidoService;


public class RegistroPedidoController {
      RegistroPedidoService pe;

    public RegistroPedidoController(RegistroPedidoService pe) {
        this.pe = pe;
    }

    public int registrarPedido(String ClienteName, String producto, int cantidad, double precio, double total , String metodoPago) {
        if (pe == null) {
            return -1;
        }

        return pe.registrarPedido(ClienteName, producto, cantidad, precio, total, metodoPago);
    }
    
  
    
    
}
