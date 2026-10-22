package Lab2;

public class DescuentoPorcentaje implements Promocion {
    private double porcentaje;

    public DescuentoPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public double aplicar(double total) {
        return total - (total * porcentaje);
    }
}