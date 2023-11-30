
package util;
import MODELO.Producto;
import java.util.ArrayList;

public class ListadoCombo {
     ArrayList<Producto>lista;
    
    public ListadoCombo(){
        lista = new ArrayList();
    }
    
    public void AgregarProductos(Producto p){
        lista.add(p);
    }
}
