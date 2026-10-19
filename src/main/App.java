package main;

import model.*;
import service.*;

// Main solo para ejecutar
public class App {
    public static void main(String[] args){
        Cliente c1=new Cliente("123","Juan");
        Pedido pedido=new Pedido(c1);
        pedido.agregarProducto(new Plato("Hamburguesa",15000));
        pedido.agregarProducto(new Bebida("Cola",5000));

        System.out.println("Total sin promo: "+pedido.calcularTotal());

        PromocionStrategy promo=new PromocionDescuento(0.1);
        System.out.println("Total con promo: "+promo.aplicar(pedido));

        pedido.cambiarEstado(EstadoPedido.EN_REPARTO);
        System.out.println("Estado: "+pedido.getEstado());
    }
}
