
package CONTROLADOR;

import MODELO.Pedido;
import SERVICES.CobrarPedidoService;
import java.util.List;

public class CobrarPedidoController {
    
     public List<Pedido> getPedido(String ClienteName)  {
        CobrarPedidoService service = new CobrarPedidoService();
        return service.getPedido(ClienteName);
    }
 
   
      public boolean eliminarPedido(String ClienteName)  {
                CobrarPedidoService service = new CobrarPedidoService();

        return service.eliminarPedido(ClienteName);
    }


    
    
    
    
    
}
