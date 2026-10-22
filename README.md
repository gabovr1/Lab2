[README.md](https://github.com/user-attachments/files/33802028/README.md)
# Sistema de Gestión de Pedidos - Lab 2

## Integrantes

* Matias Garzon Sanchez
* Harold Galeano
* Gabriel
* Braulio

## Decisiones Técnicas y Arquitectura

* **Gestión de Clientes únicos:** Se modificaron los métodos `hashCode()` y `equals()` para que evalúen únicamente el *documento de identidad*. Esto garantiza la condición de no tener clientes duplicados, ya que dos personas pueden tener el mismo nombre, pero nunca el mismo documento.
* **Optimización con HashMap:** En la clase `Repositorio` se utiliza un `HashMap`. Esto permite buscar a un cliente de forma directa e instantánea mediante un código generado/otorgado, evitando la ineficiencia de recorrer toda una lista con un ciclo `for`.
* **Prevención de Errores (Optional):** El método de búsqueda devuelve un `Optional` en lugar de `null`. Esto responde a las condiciones del requerimiento y es una buena práctica para evitar que el programa colapse por un `NullPointerException`.
* **Manejo de Estados (Enum):** El estado del pedido se maneja mediante un `Enum`. Como el estado obedece a reglas fijas que cambian durante el ciclo de vida del pedido, el enum nos da seguridad de tipos. Si se hubieran usado variables `String`, requeriría manipulaciones de texto más propensas a errores de escritura.

## Patrones de Diseño Utilizados

### 1. Strategy

* **Implementación:** Se definió una interfaz `Promocion` que es implementada por clases como `DescuentoPorcentaje`.
* **Justificación:** Evita el anidamiento sucesivo de bloques `if-else`. En lugar de modificar el código original cada vez que hay una nueva promoción, simplemente se crea un nuevo objeto instanciando la interfaz y asignándole el monto de descuento correspondiente.

### 2. Observer

* **Implementación:** Sistema de suscripción y actualización de pedidos.
* **Justificación:** Permite avisar automáticamente a todos los actores interesados cuando cambia el estado de un pedido. Esto cumplió con el requisito de no repetir código y evitó tener que escribir las notificaciones manualmente en múltiples clases.

### 3. Factory

* **Implementación:** Creación centralizada de productos.
* **Justificación:** Un solo lugar (`ProductoFactory`) decide qué clase concreta instanciar. Quien usa la fábrica recibe un `Producto` genérico sin preocuparse por las clases hijas. Centraliza el uso del `new`; por ejemplo, si mañana se agrega la categoría "Postre", solo se modifica la fábrica sin alterar el resto del sistema.

## Aplicación de Conceptos del Curso

Hemos aplicado diversos conceptos avanzados de programación a lo largo del proyecto para garantizar un código limpio y eficiente:

* **Colecciones:** Implementadas en las clases `Repositorio` y `Pedido` para agrupar elementos.
* **Ordenamiento:** Utilizado en la clase `Main` para organizar la salida de datos.
* **Genéricos:** Aplicados en el `Repositorio` para flexibilizar los tipos de datos almacenados.
* **Wildcards (Comodines):** Aplicados en `CalculosProducto`. Se usó `? extends Producto` para la lectura segura de datos y `? super Platos` para permitir la agregación de elementos.
* **Programación Funcional:** Uso intensivo de **Streams** en la clase `Main` para realizar consultas de forma declarativa.
* **SOLID:** Cumplimiento del *Principio de Responsabilidad Única (SRP)*, asegurando que cada clase tenga una sola razón para cambiar.
