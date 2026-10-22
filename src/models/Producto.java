package Lab2;

public abstract class Producto {
    private String Nombre;
    private float precio;
    private  int id;

    public Producto(String nombre, float precio, int id) {
        Nombre = nombre;
        this.precio = precio;
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Producto{" +
                "Nombre='" + Nombre + '\'' +
                ", precio=" + precio +
                ", id=" + id +
                '}';
    }
}
