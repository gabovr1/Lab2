package Lab2;

import java.util.List;

public class CalculosProducto {

    public static double sumarPrecios(List<? extends Producto> productos) {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        return total;
    }

    public static void agregarPlato(List<? super Platos> destino, Platos plato) {
        destino.add(plato);
    }
}