public class TorreControl {
    Vuelo cabeza;

    public TorreControl() {
        cabeza = null;
    }

    public void agregarVuelo(String numero, String aerolinea, int combustible, int pasajeros) {
        Vuelo nuevo = new Vuelo(numero, aerolinea, combustible, pasajeros);

        if (combustible < 10) {
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

        // Si ya está en la cabeza
        if (cabeza.numeroVuelo.equals(numeroVuelo)) {
            System.out.println("El vuelo ya está en prioridad.");
            return;
        }

        Vuelo actual = cabeza;
        Vuelo anterior = null;

        while (actual != null && !actual.numeroVuelo.equals(numeroVuelo)) {
            anterior = actual;
            actual = actual.siguiente;
        }

        // Si no se encontró
        if (actual == null) {
            System.out.println("Vuelo no encontrado.");
            return;
        }

        // 🔥 Lo quitamos de su posición
        anterior.siguiente = actual.siguiente;

        // 🔥 Lo movemos al inicio
        actual.siguiente = cabeza;
        cabeza = actual;

        System.out.println("Vuelo " + numeroVuelo + " movido a prioridad.");
    }

    // Mostrar cola
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