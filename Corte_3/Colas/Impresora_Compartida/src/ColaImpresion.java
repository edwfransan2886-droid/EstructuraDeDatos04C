public class ColaImpresion {

    private Documento salida;
    private Documento entrada;
    private int tamanio;

    public ColaImpresion() {
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

    public void enqueue(Documento documento) {

        Documento nuevo = documento;

        if (isEmpty()) {
            salida = nuevo;
            entrada = nuevo;
        } else {
            entrada.siguiente = nuevo;
            entrada = nuevo;
        }

        tamanio++;
    }

    public Documento dequeue() {

        if (isEmpty()) {
            return null;
        }

        Documento eliminado = salida;

        salida = salida.siguiente;

        if (salida == null) {
            entrada = null;
        }

        tamanio--;

        return eliminado;
    }

    public void imprimir() {

        if (isEmpty()) {
            System.out.println("No hay documentos en cola.");
            return;
        }

        Documento actual = salida;

        System.out.println("=== COLA DE IMPRESION ===");

        while (actual != null) {

            System.out.println(actual.toString());

            actual = actual.siguiente;
        }
    }

    public int calcularPaginasTotales() {

        int total = 0;

        Documento actual = salida;

        while (actual != null) {

            total += actual.numeroPaginas;

            actual = actual.siguiente;
        }

        return total;
    }
}
