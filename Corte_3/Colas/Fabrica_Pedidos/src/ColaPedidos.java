public class ColaPedidos {

    private Pedido salida;
    private Pedido entrada;
    private int tamanio;

    public ColaPedidos() {
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

    public void enqueue(Pedido pedido) {

        Pedido nuevo = pedido;

        if (isEmpty()) {
            salida = nuevo;
            entrada = nuevo;
        } else {
            entrada.siguiente = nuevo;
            entrada = nuevo;
        }

        tamanio++;
    }

    public Pedido dequeue() {

        if (isEmpty()) {
            return null;
        }

        Pedido eliminado = salida;

        salida = salida.siguiente;

        if (salida == null) {
            entrada = null;
        }

        tamanio--;

        return eliminado;
    }

    public void imprimir() {

        if (isEmpty()) {
            System.out.println("No hay pedidos.");
            return;
        }

        Pedido actual = salida;

        System.out.println("=== COLA DE PEDIDOS ===");

        while (actual != null) {

            System.out.println(actual.toString());

            actual = actual.siguiente;
        }
    }

    public void procesarPedidos() {

        if (isEmpty()) {
            System.out.println("No hay pedidos para procesar.");
            return;
        }

        int totalDespachados = 0;
        int totalCancelados = 0;

        System.out.println("=== PROCESANDO PEDIDOS ===");

        while (!isEmpty()) {

            Pedido actual = dequeue();

            if (actual.cancelado) {

                System.out.println("Pedido cancelado descartado: " +
                        actual.numeroPedido);

                totalCancelados++;

            } else {

                System.out.println("Despachando pedido:");
                System.out.println(actual);

                totalDespachados++;
            }
        }

        System.out.println("Total despachados: " + totalDespachados);
        System.out.println("Total cancelados: " + totalCancelados);
    }
}
