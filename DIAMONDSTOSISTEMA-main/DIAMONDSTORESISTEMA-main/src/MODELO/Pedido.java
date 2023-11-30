package MODELO;

import java.util.Date;

public class Pedido {

    private int idPedido;
    private String ClienteName;
    private String producto;
    private int cantidad;
        private double precio;
        private double total;
        private String metodoPago;

    //private Date fecha;

    public Pedido() {

    }

    public Pedido( String ClienteName, String producto, int cantidad, double precio, double total, String metodoPago) {
        this.ClienteName = ClienteName;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
        this.metodoPago = metodoPago;
    }

 

    public String getClienteName() {
        return ClienteName;
    }

    public void setClienteName(String ClienteName) {
        this.ClienteName = ClienteName;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

   
    
}

   