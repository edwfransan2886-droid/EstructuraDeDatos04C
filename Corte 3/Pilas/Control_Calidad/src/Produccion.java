public class Produccion {
    private Pieza tope;

    public Produccion() {
        this.tope = null;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public void push(Pieza nueva) {
        nueva.siguiente = tope;
        tope = nueva;
    }

    public Pieza pop() {
        if (estaVacia()) {
            return null;
        }

        Pieza aux = tope;
        tope = tope.siguiente;
        aux.siguiente = null;

        return aux;
    }

    public void imprimir() {
        if (estaVacia()) {
            System.out.println("Pila vacia");
            return;
        }

        Pieza actual = tope;

        System.out.println("=== LINEA DE ENSAMBLAJE ===");

        while (actual != null) {

            if (actual == tope) {
                System.out.print("TOPE -> ");
            } else {
                System.out.print("        ");
            }

            System.out.println(actual.toString());

            actual = actual.siguiente;
        }
    }

    public void limpiarHastaDefecto() {

        if (estaVacia()) {
            System.out.println("No hay piezas en la pila");
            return;
        }

        System.out.println("Retirando piezas buenas hasta encontrar defecto");

        while (tope != null) {

            if (tope.esDefectuosa) {
                System.out.println("Pieza defectuosa encontrada: " + tope.nombrePieza);
                System.out.println("Linea detenida");
                return;
            }

            Pieza retirada = pop();

            System.out.println("Pieza descartada: " + retirada.nombrePieza);
        }

        System.out.println("No se encontro ninguna pieza defectuosa");
    }
}