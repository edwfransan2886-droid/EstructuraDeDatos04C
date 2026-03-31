class Producto {
    String nombre;
    int cantidad;
    int diasParaVencer;
    Producto siguiente;

    public Producto(String nombre, int cantidad, int diasParaVencer) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.diasParaVencer = diasParaVencer;
        this.siguiente = null;
    }
}

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
    public void mostrarInventario() {
        Producto actual = cabeza;

        while (actual != null) {
            System.out.println("Nombre: " + actual.nombre +
                    " | Cantidad: " + actual.cantidad +
                    " | Dias: " + actual.diasParaVencer);
            actual = actual.siguiente;
        }
    }
    public void mostrarProductosPorVencer() {
        Producto actual = cabeza;

        System.out.println("Productos con menos de 5 dias:\n");
        while (actual != null) {
            if (actual.diasParaVencer < 5) {
                System.out.println("Nombre: " + actual.nombre +
                        " | Cantidad: " + actual.cantidad +
                        " | Dias: " + actual.diasParaVencer);
            }
            actual = actual.siguiente;
        }
    }
}