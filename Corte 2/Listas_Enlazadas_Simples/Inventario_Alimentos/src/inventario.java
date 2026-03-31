public class Inventario {
    Producto cabeza;

    public Inventario() {
        cabeza = null;
    }

    public void insertarProducto(String nombre, int cantidad, int diasParaVencer) {
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
                               " | Dias para vencer: " + actual.diasParaVencer);
            actual = actual.siguiente;
        }
    }

    public void productosProximosAVencer() {
        Producto actual = cabeza;
        System.out.println("\nProductos con menos de 5 días para vencer:");
        while (actual != null) {
            if (actual.diasParaVencer < 5) {
                System.out.println("Nombre: " + actual.nombre +
                                   " | Cantidad: " + actual.cantidad +
                                   " | Dias para vencer: " + actual.diasParaVencer);
            }
            actual = actual.siguiente;
        }
    }
}