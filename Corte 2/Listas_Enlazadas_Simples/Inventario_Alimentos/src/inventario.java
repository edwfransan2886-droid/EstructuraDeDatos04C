public class inventario {
    Producto cabeza;

    public inventario() {
        cabeza = null;
    }
    public void agregarProducto(String nombre, int cantidad, int diasParaVencer) {
        Producto nuevo = new Producto(nombre, cantidad, diasParaVencer);

        if (diasParaVencer < 3) {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        } else {
            if (cabeza == null) {
                cabeza = nuevo;
            } else {
                Producto actual = cabeza;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevo;
            }
        }
    }

    public void mostrarProductosPorVencer() {
        Producto actual = cabeza;

        System.out.println("Productos próximos a vencer (<5 días):\n");

        while (actual != null) {
            if (actual.diasParaVencer < 5) {
                System.out.println("Nombre: " + actual.nombre +
                        " | Cantidad: " + actual.cantidad +
                        " | Días para vencer: " + actual.diasParaVencer);
            }
            actual = actual.siguiente;
        }
    }

    public void mostrarInventario() {
        Producto actual = cabeza;

        while (actual != null) {
            System.out.println(actual.nombre + " - " + actual.diasParaVencer + " días");
            actual = actual.siguiente;
        }
    }
}