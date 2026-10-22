package Lab2;

public class NotificacionRepartidor implements ObservadorPedido {
    @Override
    public void actualizar(Pedido pedido) {
        System.out.println("Repartidor " + pedido.getRepartidor().getNombre() + ": el pedido " + pedido.getId() + " ahora esta " + pedido.getEstado());
    }
}