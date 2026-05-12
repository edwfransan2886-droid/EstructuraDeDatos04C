public class PilaCamiones {
    private Camion tope;

    public PilaCamiones() {
        this.tope = null;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public void push(Camion nuevo) {
        nuevo.siguiente = tope;
        tope = nuevo;
    }

    public Camion pop() {
        if (estaVacia()) {
            return null;
        }

        Camion aux = tope;
        tope = tope.siguiente;
        aux.siguiente = null;

        return aux;
    }

    public void imprimir() {
        if (estaVacia()) {
            System.out.println("No hay camiones.");
            return;
        }

        Camion actual = tope;

        System.out.println("=== CAMIONES EN EL CALLEJON ===");

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

    public double calcularCargaTotal() {

        if (estaVacia()) {
            return 0;
        }

        PilaCamiones auxiliar = new PilaCamiones();

        double suma = 0;

        while (!estaVacia()) {

            Camion actual = pop();

            suma += actual.cargaToneladas;

            auxiliar.push(actual);
        }

        while (!auxiliar.estaVacia()) {
            push(auxiliar.pop());
        }

        return suma;
    }
}
