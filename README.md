# Lab 2 - Sistema de Gestión de Pedidos - SaborExpress S.A.S.

## Integrantes
- Gabriel V, Matías G, Harold G, Braulio N

## Descripción
Este proyecto implementa un sistema básico de gestión de pedidos para una cadena de restaurantes con servicio a domicilio.  
El objetivo es reemplazar el manejo con listas por una solución más clara, modular y eficiente, aplicando los conceptos vistos en clase de Programación Orientada a Objetos en Java.

## Decisiones de diseño
- **Clases y objetos:** Se definieron clases `Cliente`, `Producto`, `Plato`, `Bebida`, `Combo`, `Pedido` para representar las entidades principales.
- **Encapsulamiento:** Todos los atributos son privados y se accede mediante getters y setters.
- **Herencia y polimorfismo:** `Plato`, `Bebida` y `Combo` heredan de la clase abstracta `Producto`.
- **Enum:** Se creó `EstadoPedido` para manejar los estados de un pedido.
- **Colecciones:** Se usaron `ArrayList` para almacenar productos en un pedido.
- **Ordenamiento y búsqueda:** Se aplican comparadores y uso de `Stream API` para consultas dinámicas.
- **Programación funcional:** Se emplean lambdas y streams para calcular totales y filtrar datos.
- **Principios SOLID:** Separación de responsabilidades entre clases, abierto/cerrado para nuevas promociones.
- **Patrones de diseño:**
    - **Strategy:** Para aplicar diferentes promociones sin modificar la clase `Pedido`.
    - **Observer:** Para notificar automáticamente a cocina, cliente y repartidor cuando cambia el estado de un pedido.
    - **Factory:** Para la creación de productos de manera centralizada.

## Organización del código
En la versión final se entregan los archivos en el mismo nivel de `src` para facilitar la copia en IntelliJ:
- `Cliente.java`
- `Producto.java`
- `Plato.java`
- `Bebida.java`
- `Combo.java`
- `EstadoPedido.java`
- `Pedido.java`
- `PromocionStrategy.java`
- `PromocionDescuento.java`
- `App.java`

## Ejecución
1. Clonar el repositorio desde GitHub.
2. Abrir el proyecto en IntelliJ.
3. Ejecutar la clase `App.java` que contiene el método `main`.

## Aportes de los integrantes
Cada integrante del grupo aportó código en diferentes clases y métodos, lo cual se puede verificar en el historial de commits del repositorio en GitHub.

## Bonus
Se implementó el patron **Strategy**.
