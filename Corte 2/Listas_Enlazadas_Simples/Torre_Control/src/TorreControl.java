class Vuelo {
    String numeroVuelo;
    String aerolinea;
    int combustibleRestante;
    int pasajeros;
    Vuelo siguiente;

    public Vuelo(String numeroVuelo, String aerolinea, int combustibleRestante, int pasajeros) {
        this.numeroVuelo = numeroVuelo;
        this.aerolinea = aerolinea;
        this.combustibleRestante = combustibleRestante;
        this.pasajeros = pasajeros;
        this.siguiente = null;
    }
}

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
        if (cabeza == null) {
            System.out.println("La cola está vacia.");
            return;
        }
        if (cabeza.numeroVuelo.equals(numeroVuelo)) {
            System.out.println("El vuelo ya esta al inicio.");
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

        System.out.println("Vuelo " + numeroVuelo + " movido al inicio por emergencia.");
    }

    public void mostrarCola() {
        Vuelo actual = cabeza;
        while (actual != null) {
            System.out.println("Vuelo: " + actual.numeroVuelo +
                    "  -Aerolinea: " + actual.aerolinea +
                    "  -Combustible: " + actual.combustibleRestante +
                    "  -Pasajeros: " + actual.pasajeros);
            actual = actual.siguiente;
        }
    }
}