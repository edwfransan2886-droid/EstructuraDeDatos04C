public class Editor {
    Capa cabeza;
    Capa cola;
    Capa capaActiva;

    public Editor() {
        this.cabeza = null;
        this.cola = null;
        this.capaActiva = null;
    }

    public void agregarCapa(String nombre, String tipo) {
        Capa nueva = new Capa(nombre, tipo);

        if (cabeza == null) {
            cabeza = nueva;
            cola = nueva;
            nueva.siguiente = nueva;
            nueva.anterior = nueva;
        } else {
            cola.siguiente = nueva;
            nueva.anterior = cola;
            nueva.siguiente = cabeza;
            cabeza.anterior = nueva;
            cola = nueva;
        }

        capaActiva = nueva;
    }

    public void subirCapa() {
        if (capaActiva != null) {
            capaActiva = capaActiva.siguiente;
        }
    }

    public void bajarCapa() {
        if (capaActiva != null) {
            capaActiva = capaActiva.anterior;
        }
    }

    public void toggleVisibilidad() {
        if (capaActiva != null) {
            capaActiva.visible = !capaActiva.visible;
        }
    }

    public void eliminarActiva() {
        if (capaActiva == null) {
            return;
        }

        if (cabeza == cola) {
            cabeza = null;
            cola = null;
            capaActiva = null;
            return;
        }

        Capa eliminar = capaActiva;

        eliminar.anterior.siguiente = eliminar.siguiente;
        eliminar.siguiente.anterior = eliminar.anterior;

        if (eliminar == cabeza) {
            cabeza = eliminar.siguiente;
        }

        if (eliminar == cola) {
            cola = eliminar.anterior;
        }

        capaActiva = eliminar.siguiente;
    }

    public void mostrarActiva() {
        if (capaActiva == null) {
            System.out.println("No hay capas");
            return;
        }

        System.out.println("Capa activa: " + capaActiva.nombre +
                " | Tipo: " + capaActiva.tipo +
                " | Visible: " + capaActiva.visible);
    }

    public void mostrarCapas() {
        if (cabeza == null) {
            System.out.println("No hay capas");
            return;
        }

        Capa actual = cabeza;

        do {
            String marca = "";

            if (actual == capaActiva) {
                marca = "X";
            }

            System.out.println(marca + actual.nombre + " | Tipo: " + actual.tipo + " | Visible: " + actual.visible);

            actual = actual.siguiente;

        } while (actual != cabeza);
    }
}
