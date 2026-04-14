public class Planificador {
    Proceso cabeza;
    Proceso cola;

    public Planificador() {
        this.cabeza = null;
        this.cola = null;
    }

    public void agregarProceso(Proceso p) {
        if (cabeza == null) {
            cabeza = p;
            cola = p;
            p.siguiente = cabeza;
        } else {
            cola.siguiente = p;
            p.siguiente = cabeza;
            cola = p;
        }
    }

    public void mostrarProcesos() {
        if (cabeza == null) {
            System.out.println("No hay procesos");
            return;
        }

        Proceso actual = cabeza;
        do {
            System.out.println(actual.nombre + " | PID: " + actual.pid + " | Tiempo: " + actual.tiempoRestante);
            actual = actual.siguiente;
        } while (actual != cabeza);
    }

    public void ejecutar(int quantum) {
        if (cabeza == null) {
            System.out.println("No hay procesos");
            return;
        }

        String orden = "";

        Proceso actual = cabeza;

        while (cabeza != null) {

            System.out.println("Ejecutando: " + actual.nombre);

            actual.tiempoRestante -= quantum;

            if (actual.tiempoRestante <= 0) {
                System.out.println("Proceso terminado: " + actual.nombre);

                orden += actual.nombre + "-";

                actual = eliminarProceso(actual);
            } else {
                System.out.println("Tiempo restante: " + actual.tiempoRestante);
                actual = actual.siguiente;
            }
        }

        System.out.println("\nOrden de finalizacion:");
        System.out.println(orden);
    }

    private Proceso eliminarProceso(Proceso p) {
        if (cabeza == null) return null;

        if (cabeza == cola && cabeza == p) {
            cabeza = null;
            cola = null;
            return null;
        }

        if (p == cabeza) {
            cabeza = cabeza.siguiente;
            cola.siguiente = cabeza;
            return cabeza;
        }

        Proceso anterior = cabeza;
        while (anterior.siguiente != p) {
            anterior = anterior.siguiente;
        }

        anterior.siguiente = p.siguiente;

        if (p == cola) {
            cola = anterior;
        }

        return p.siguiente;
    }
}