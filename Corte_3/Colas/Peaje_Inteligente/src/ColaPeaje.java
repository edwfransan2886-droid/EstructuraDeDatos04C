public class ColaPeaje {

    private Vehiculo salida;
    private Vehiculo entrada;
    private int tamanio;

    public ColaPeaje() {
        salida = null;
        entrada = null;
        tamanio = 0;
    }

    public boolean isEmpty() {
        return salida == null;
    }

    public int size() {
        return tamanio;
    }

    public void enqueue(Vehiculo vehiculo) {

        Vehiculo nuevo = vehiculo;

        if (isEmpty()) {
            salida = nuevo;
            entrada = nuevo;
        } else {
            entrada.siguiente = nuevo;
            entrada = nuevo;
        }

        tamanio++;
    }

    public Vehiculo dequeue() {

        if (isEmpty()) {
            return null;
        }

        Vehiculo eliminado = salida;

        salida = salida.siguiente;

        if (salida == null) {
            entrada = null;
        }

        tamanio--;

        return eliminado;
    }

    public void imprimir() {

        if (isEmpty()) {
            System.out.println("No hay vehiculos en fila");
            return;
        }

        Vehiculo actual = salida;

        System.out.println("=== FILA DEL PEAJE ===");

        while (actual != null) {

            System.out.println(actual.toString());

            actual = actual.siguiente;
        }
    }

    public void cerrarTurno() {

        if (isEmpty()) {
            System.out.println("No hay vehiculos en cola");
            return;
        }

        double totalRecaudado = 0;

        System.out.println("=== CERRANDO TURNO ===");

        while (!isEmpty()) {

            Vehiculo actual = dequeue();

            System.out.println("Procesando vehiculo: " + actual.placa);

            if (!actual.esExento) {
                totalRecaudado += actual.tarifa;
            }
        }

        System.out.println("Total recaudado: " + totalRecaudado);
    }
}