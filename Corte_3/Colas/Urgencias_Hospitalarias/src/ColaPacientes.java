public class ColaPacientes {

    private Paciente salida;
    private Paciente entrada;
    private int tamanio;

    public ColaPacientes() {
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

    public void enqueue(Paciente paciente) {

        Paciente nuevo = paciente;

        if (isEmpty()) {
            salida = nuevo;
            entrada = nuevo;
        } else {
            entrada.siguiente = nuevo;
            entrada = nuevo;
        }

        tamanio++;
    }

    public Paciente dequeue() {

        if (isEmpty()) {
            return null;
        }

        Paciente atendido = salida;

        salida = salida.siguiente;

        if (salida == null) {
            entrada = null;
        }

        tamanio--;

        return atendido;
    }

    public void imprimir() {

        if (isEmpty()) {
            System.out.println("No hay pacientes en espera.");
            return;
        }

        Paciente actual = salida;

        System.out.println("=== FILA DE URGENCIAS ===");

        while (actual != null) {

            System.out.println(actual.toString());

            actual = actual.siguiente;
        }
    }

    public void atenderTodos() {

        if (isEmpty()) {
            System.out.println("No hay pacientes.");
            return;
        }

        int totalAtendidos = 0;

        System.out.println("=== ATENDIENDO PACIENTES ===");

        while (!isEmpty()) {

            Paciente actual = dequeue();

            System.out.println("Atendiendo: " + actual);

            totalAtendidos++;
        }

        System.out.println("Total de pacientes atendidos: " + totalAtendidos);
    }
}
