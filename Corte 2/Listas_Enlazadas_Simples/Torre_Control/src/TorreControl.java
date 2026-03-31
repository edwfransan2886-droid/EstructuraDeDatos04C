public class TorreControl {
    Vuelo cabeza;

    public TorreControl() {
        cabeza = null;
    }

    public void agregarVuelo(String numeroVuelo, String aerolinea, int combustibleRestante, int pasajeros) {
        Vuelo nuevo = new Vuelo(numeroVuelo, aerolinea, combustibleRestante, pasajeros);

        if (combustibleRestante < 10) {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        } else {
            if (cabeza == null) {
                cabeza = nuevo;
            } else {
                Vuelo actual = cabeza;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevo;
            }
        }
    }
    public void reportarEmergencia(String numeroVuelo) {
        if (cabeza == null) return;

        if (cabeza.numeroVuelo.equals(numeroVuelo)) {
            System.out.println("El vuelo ya esta en prioridad.");
            return;
        }

        Vuelo actual = cabeza;
        Vuelo anterior = null;

        while (actual != null && !actual.numeroVuelo.equals(numeroVuelo)) {
            anterior = actual;
            actual = actual.siguiente;
        }

        if (actual == null) {
            System.out.println("Vuelo no encontrado.");
            return;
        }
        anterior.siguiente = actual.siguiente;

        actual.siguiente = cabeza;
        cabeza = actual;

        System.out.println("Vuelo " + numeroVuelo + " movido a prioridad.");
    }
    public void mostrarCola() {
        Vuelo actual = cabeza;

        while (actual != null) {
            System.out.println("Vuelo: " + actual.numeroVuelo +
                    " | Aerolínea: " + actual.aerolinea +
                    " | Combustible: " + actual.combustibleRestante +
                    " | Pasajeros: " + actual.pasajeros);
            actual = actual.siguiente;
        }
    }
}