package Lab2;

public class Cocina implements ObservadorPedido {
    @Override
    public void actualizar(Pedido pedido) {
        System.out.println("Cocina: el pedido " + pedido.getId() + " ahora esta " + pedido.getEstado());
    }
}