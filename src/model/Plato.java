package model;

public class Plato extends Producto {
    public Plato(String nombre,double precio){super(nombre,precio);}
    @Override
    public String tipo(){return "Plato";}
}
