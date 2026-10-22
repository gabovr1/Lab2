package Lab2;

import java.util.ArrayList;

public class Pedido {
    private int id;
    private Cliente cliente;
    private Repartidor repartidor;
    private ArrayList<Producto> productos;
    private String sede;
    private EstadoPedido estado;
    private ArrayList<ObservadorPedido> observadores;
    private Promocion promocion;

    public Pedido(int id, Cliente cliente, Repartidor repartidor, String sede) {
        this.id = id;
        this.cliente = cliente;
        this.repartidor = repartidor;
        this.sede = sede;
        this.productos = new ArrayList<>();
        this.estado = EstadoPedido.RECIBIDO;
        this.observadores = new ArrayList<>();
        this.promocion = total -> total;
    }

    public void suscribir(ObservadorPedido observador) {
        observadores.add(observador);
    }

    public void cambiarEstado(EstadoPedido nuevoEstado) {
        this.estado = nuevoEstado;
        for (ObservadorPedido o : observadores) {
            o.actualizar(this);
        }
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public double calcularTotal() {
        double subtotal = productos.stream().mapToDouble(Producto::getPrecio).sum();
        return promocion.aplicar(subtotal);
    }

    public void aplicarPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public String getSede() {
        return sede;
    }

    public EstadoPedido getEstado() {
        return estado;
    }
}
