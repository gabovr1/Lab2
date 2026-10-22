package Lab2;

public class NotificacionCliente implements ObservadorPedido {
    @Override
    public void actualizar(Pedido pedido) {
        System.out.println("Cliente " + pedido.getCliente().getNombre() + ": tu pedido " + pedido.getId() + " ahora esta " + pedido.getEstado());
    }
}