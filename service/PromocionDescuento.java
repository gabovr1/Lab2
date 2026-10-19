package Lab2.service;

import Lab2.model.Pedido;

// Estrategia concreta
public class PromocionDescuento implements PromocionStrategy {
    private double porcentaje;
    public PromocionDescuento(double porcentaje){
        this.porcentaje=porcentaje;}

    @Override
    public double aplicar(Pedido pedido){
        return pedido.calcularTotal()*(1-porcentaje);
    }
}
