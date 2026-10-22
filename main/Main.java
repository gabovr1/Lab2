package Lab2;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.max;

public class Main {
    static void main(String[] args) {


        Repositorio<Integer, Producto> productos = new Repositorio<>();
        productos.guardar(1, new Platos("Bandeja paisa", 30000, 1));
        productos.guardar(2, new Platos("Sancocho", 25000, 2));
        productos.guardar(3, new Bebidas("Jugo", 8000, 3));
        productos.guardar(4, new Bebidas("Limonada", 8000, 4));
        productos.guardar(5, new Combo("Combo familiar", 50000, 5));

        ArrayList<Producto> lista = productos.listar();

        lista.sort(Comparator.comparing(Producto::getPrecio).reversed().thenComparing(Producto::getNombre));

        System.out.println(lista);

        Cliente ana = new Cliente("Ana", "1001");
        Cliente luis = new Cliente("Luis", "1002");

        Repartidor r1 = new Repartidor("R1", "Carlos", 4.8, 120);
        Repartidor r2 = new Repartidor("R2", "Sofia", 4.5, 90);

        Producto bandeja = new Platos("Bandeja paisa", 30000, 1);
        Producto sancocho = new Platos("Sancocho", 25000, 2);
        Producto jugo = new Bebidas("Jugo", 8000, 3);
        Producto combo = new Combo("Combo familiar", 50000, 5);

        Pedido p1 = new Pedido(1, ana, r1, "Centro");
        p1.agregarProducto(bandeja);
        p1.agregarProducto(jugo);

        Pedido p2 = new Pedido(2, ana, r2, "Poblado");
        p2.agregarProducto(combo);
        p2.agregarProducto(sancocho);

        Pedido p3 = new Pedido(3, luis, r1, "Centro");
        p3.agregarProducto(sancocho);
        p3.agregarProducto(jugo);
        p3.agregarProducto(jugo);

        Repositorio<Integer, Pedido> pedidos = new Repositorio<>();
        pedidos.guardar(1, p1);
        pedidos.guardar(2, p2);
        pedidos.guardar(3, p3);

        ArrayList<Pedido> listaPedidos = pedidos.listar();

        Optional<Pedido> masCaro = listaPedidos.stream()
                .filter(p -> p.getCliente().equals(ana))
                .max(Comparator.comparingDouble(Pedido::calcularTotal));

        masCaro.ifPresent(p -> System.out.println("Pedido " + p.getId() + ": " + p.calcularTotal()));

        Map<String, Double> facturacion = listaPedidos.stream()
                .collect(Collectors.groupingBy(Pedido::getSede, Collectors.summingDouble(Pedido::calcularTotal)));

        facturacion.forEach((sede, total) -> System.out.println(sede + ": " + total));

        List<Producto> vendidos = listaPedidos.stream()
                .flatMap(p -> p.getProductos().stream())
                .toList();

        System.out.println(vendidos.size());

        Map<String, Long> ventas = vendidos.stream()
                .filter(prod -> prod instanceof Platos)
                .collect(Collectors.groupingBy(Producto::getNombre, Collectors.counting()));

        System.out.println(ventas);

        ventas.entrySet().stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .limit(3)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        Repartidor r3 = new Repartidor("R3", "Marta", 4.8, 150);
        List<Repartidor> repartidores = List.of(r1, r2, r3);

        List<String> mejores = repartidores.stream()
                .filter(r -> r.getCalificacion() >= 4.5)
                .sorted(Comparator.comparing(Repartidor::getCalificacion).reversed())
                .map(Repartidor::getNombre)
                .toList();
        System.out.println("\n"+"Mejores repartidores en orden");
        System.out.println(mejores);

        System.out.println("\n");

        Platos pl1 = new Platos("Ajiaco", 22000, 6);
        Platos pl2 = new Platos("Mondongo", 24000, 7);
        Bebidas be1 = new Bebidas("Cafe", 5000, 8);

        List<Platos> soloPlatos = List.of(pl1, pl2);
        List<Bebidas> soloBebidas = List.of(be1);
        List<Producto> mezcla = List.of(pl1, be1);
        System.out.println("\n"+"Suma solo platos");
        System.out.println(CalculosProducto.sumarPrecios(soloPlatos));
        System.out.println("\n"+"Suma solo bebidas");
        System.out.println(CalculosProducto.sumarPrecios(soloBebidas));
        System.out.println("\n"+"Suma mixta");
        System.out.println(CalculosProducto.sumarPrecios(mezcla));

        List<Producto> menu = new ArrayList<>();
        CalculosProducto.agregarPlato(menu, pl1);
        System.out.println(menu);

        System.out.println("\n"+"Notificacion de cambio de estado");
        p1.suscribir(new Cocina());
        p1.suscribir(new NotificacionCliente());
        p1.suscribir(new NotificacionRepartidor());



        p1.suscribir(p -> System.out.println("Auditoria: pedido " + p.getId() + " cambio a " + p.getEstado()));
        p1.cambiarEstado(EstadoPedido.EN_CAMINO);

        System.out.println("\n"+"Aplicacion del patron Factory");
        Producto ajiaco = ProductoFactory.crear(TipoProducto.PLATO, "Ajiaco", 22000, 6);
        Producto cafe = ProductoFactory.crear(TipoProducto.BEBIDA, "Cafe", 5000, 8);

        System.out.println(ajiaco);
        System.out.println(cafe);


        System.out.println("\n"+"No es posible el duplicado de cliente "); // compara por documento y el map se da cuenta que ya esta dentro entonces procede a no permitirle el ingreso

        Repositorio<String, Cliente> clientes = new Repositorio<>();
        clientes.guardar(ana.getDocumento(), ana);

        Cliente anaPorWhatsApp = new Cliente("Ana G.", "1001");

        try {
            clientes.guardar(anaPorWhatsApp.getDocumento(), anaPorWhatsApp);
        } catch (ElementoDuplicadoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n"+"Aplicacion del descuento");
        p1.aplicarPromocion(new DescuentoPorcentaje(0.1));
        System.out.println(p1.calcularTotal());
        p1.aplicarPromocion(total -> total - 5000);
        System.out.println(p1.calcularTotal());
    }



}
