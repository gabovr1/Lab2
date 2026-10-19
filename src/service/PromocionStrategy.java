package Lab2.service;

import Lab2.model.Pedido;

// Interface para Strategy
public interface PromocionStrategy {
    double aplicar(Pedido pedido);
}