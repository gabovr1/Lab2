package Lab2;

public class ProductoFactory {

    public static Producto crear(TipoProducto tipo, String nombre, float precio, int id) {
        return switch (tipo) {
            case PLATO -> new Platos(nombre, precio, id);
            case BEBIDA -> new Bebidas(nombre, precio, id);
            case COMBO -> new Combo(nombre, precio, id);
        };
    }
}