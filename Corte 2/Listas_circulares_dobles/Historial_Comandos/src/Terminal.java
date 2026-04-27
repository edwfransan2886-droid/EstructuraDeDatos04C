public class Terminal {
    Comando cabeza;
    Comando cola;
    Comando cursor;

    public Terminal() {
        this.cabeza = null;
        this.cola = null;
        this.cursor = null;
    }

    public void agregarComando(String texto, boolean exitoso, String directorio) {
        Comando nuevo = new Comando(texto, exitoso, directorio);

        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            nuevo.siguiente = nuevo;
            nuevo.anterior = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cola = nuevo;
        }

        cursor = cola;
    }

    public void arriba() {
        if (cursor != null) {
            cursor = cursor.anterior;
        }
    }

    public void abajo() {
        if (cursor != null) {
            cursor = cursor.siguiente;
        }
    }

    public void mostrarCursor() {
        if (cursor == null) {
            System.out.println("No hay comandos");
            return;
        }

        System.out.println("Cursor: " + cursor.texto + " | Exitoso: " + cursor.exitoso + 
        " | Directorio: " + cursor.directorio);
    }

    public void eliminarActual() {
        if (cursor == null) {
            System.out.println("No hay comando para eliminar");
            return;
        }

        if (cabeza == cola) {
            cabeza = null;
            cola = null;
            cursor = null;
            return;
        }

        Comando eliminado = cursor;

        eliminado.anterior.siguiente = eliminado.siguiente;
        eliminado.siguiente.anterior = eliminado.anterior;

        if (eliminado == cabeza) {
            cabeza = eliminado.siguiente;
        }

        if (eliminado == cola) {
            cola = eliminado.anterior;
        }

        cursor = eliminado.siguiente;

        System.out.println("Comando eliminado");
    }

    public void mostrarHistorial() {
        if (cabeza == null) {
            System.out.println("Historial vacio");
            return;
        }

        Comando actual = cabeza;

        do {
            if (actual == cursor) {
                System.out.println(actual.texto + " | " + actual.exitoso + " | " + actual.directorio);
            } else {
                System.out.println(actual.texto + " | " + actual.exitoso + " | " + actual.directorio);
            }

            actual = actual.siguiente;

        } while (actual != cabeza);
    }
}