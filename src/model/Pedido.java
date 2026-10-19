package model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<Producto> productos;
    private EstadoPedido estado;

    public Pedido(Cliente cliente){
        this.cliente=cliente;
        this.productos=new ArrayList<>();
        this.estado=EstadoPedido.PENDIENTE;
    }

    public void agregarProducto(Producto p){productos.add(p);}
    public double calcularTotal(){
        try {
            return productos.stream().mapToDouble(Producto::getPrecio).sum();
        } catch(Exception e){
            System.out.println("Error al calcular total: "+e.getMessage());
            return 0;
        }
    }

    public void cambiarEstado(EstadoPedido nuevo){estado=nuevo;}
    public EstadoPedido getEstado(){return estado;}

}
