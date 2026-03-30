public class Tren {
    Vagon cabeza;

    public Tren() {
        cabeza = null;
    }

    public void agregarVagon(String contenido, double peso, String origen, String destino) {
        Vagon nuevo = new Vagon(contenido, peso, origen, destino);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Vagon actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    public double calcularPesoTotal() {
        double total = 0;
        Vagon actual = cabeza;

        while (actual != null) {
            total += actual.pesoToneladas;
            actual = actual.siguiente;
        }

        return total;
    }
}