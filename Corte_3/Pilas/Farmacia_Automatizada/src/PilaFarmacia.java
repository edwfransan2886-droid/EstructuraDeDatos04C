public class PilaFarmacia {
    private Medicamento tope;

    public PilaFarmacia() {
        this.tope = null;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public void push(Medicamento nuevo) {
        nuevo.siguiente = tope;
        tope = nuevo;
    }

    public Medicamento pop() {
        if (estaVacia()) {
            return null;
        }

        Medicamento aux = tope;
        tope = tope.siguiente;
        aux.siguiente = null;

        return aux;
    }

    public Medicamento peek() {
        return tope;
    }

    public void imprimir() {
        if (estaVacia()) {
            System.out.println("Dispensador vacio");
            return;
        }

        Medicamento actual = tope;

        System.out.println("=== DISPENSADOR ===");

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

    public void validarDespacho() {

        if (estaVacia()) {
            System.out.println("No hay medicamentos");
            return;
        }

        while (tope != null && tope.diasParaVencer < 10) {

            Medicamento retirado = pop();

            System.out.println("Retirado por seguridad: " +
                    retirado.nombre +
                    " | Dias restantes: " +
                    retirado.diasParaVencer);
        }

        if (tope != null) {
            System.out.println("Medicamento seguro para despacho: " + tope);
        } else {
            System.out.println("No quedan medicamentos seguros");
        }
    }
}
