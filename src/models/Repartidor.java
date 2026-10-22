package Lab2;

public class Repartidor {

    private String id;
    private String nombre;
    private double calificacion;
    private int entregas;

    public Repartidor(String id, String nombre, double calificacion, int entregas) {
        this.id = id;
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.entregas = entregas;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public int getEntregas() {
        return entregas;
    }

}
