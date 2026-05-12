public class PilaRescate {
    private Estacion tope;

    public PilaRescate() {
        this.tope = null;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public void push(Estacion nueva) {
        nueva.siguiente = tope;
        tope = nueva;
    }

    public Estacion pop() {
        if (estaVacia()) {
            return null;
        }

        Estacion aux = tope;
        tope = tope.siguiente;
        aux.siguiente = null;

        return aux;
    }

    public void imprimir() {
        if (estaVacia()) {
            System.out.println("No hay estaciones registradas.");
            return;
        }

        Estacion actual = tope;

        System.out.println("=== RUTA ACTUAL ===");

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

    public void retrocederASuperficie() {

        if (estaVacia()) {
            System.out.println("No hay ruta para retroceder.");
            return;
        }

        System.out.println("=== RETORNO A SUPERFICIE ===");

        while (!estaVacia()) {

            Estacion actual = pop();

            System.out.println("Retrocediendo por: " + actual.nombrePunto);

            if (actual.nivelOxigeno < 18) {
                System.out.println("ALERTA: Uso de Tanque de Emergencia Requerido");
            }
        }

        System.out.println("Superficie alcanzada.");
    }
}