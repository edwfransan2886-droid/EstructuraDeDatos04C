public class ArbolEmpleados {

    private Empleado raiz;

    public ArbolEmpleados() {
        this.raiz = null;
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    private Empleado insertar(Empleado nodo, long cedula, String nombreCompleto, String cargo, double salario) {

        if (nodo == null)
            return new Empleado(cedula, nombreCompleto, cargo, salario);

        if (cedula < nodo.cedula)
            nodo.izquierdo = insertar(nodo.izquierdo, cedula, nombreCompleto, cargo, salario);

        else if (cedula > nodo.cedula)
            nodo.derecho = insertar(nodo.derecho, cedula, nombreCompleto, cargo, salario);

        else
            System.out.println("Ya existe un empleado con cedula " + cedula);

        return nodo;
    }

    public void insertar(long cedula, String nombreCompleto, String cargo, double salario) {
        raiz = insertar(raiz, cedula, nombreCompleto, cargo, salario);
    }

    private Empleado buscar(Empleado nodo, long cedula) {

        if (nodo == null)
            return null;

        if (cedula == nodo.cedula)
            return nodo;

        if (cedula < nodo.cedula)
            return buscar(nodo.izquierdo, cedula);
        else
            return buscar(nodo.derecho, cedula);
    }

    public Empleado buscar(long cedula) {
        return buscar(raiz, cedula);
    }

    private void inOrden(Empleado nodo) {

        if (nodo != null) {

            inOrden(nodo.izquierdo);

            System.out.println(nodo);

            inOrden(nodo.derecho);
        }
    }

    public void inOrden() {

        if (isEmpty()) {
            System.out.println("Arbol vacio.");
            return;
        }

        System.out.println("=== EMPLEADOS ORDENADOS POR CEDULA ===");
        inOrden(raiz);
    }

    // ALTURA

    private int altura(Empleado nodo) {

        if (nodo == null)
            return -1;

        return 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));
    }

    public int altura() {
        return altura(raiz);
    }

    private int contarHojas(Empleado nodo) {

        if (nodo == null)
            return 0;

        if (nodo.izquierdo == null && nodo.derecho == null)
            return 1;

        return contarHojas(nodo.izquierdo) + contarHojas(nodo.derecho);
    }

    public int contarHojas() {
        return contarHojas(raiz);
    }


    public void buscarMinimo() {

        if (isEmpty()) {
            System.out.println("Arbol vacio.");
            return;
        }

        Empleado actual = raiz;

        while (actual.izquierdo != null) {
            actual = actual.izquierdo;
        }

        System.out.println("Empleado con menor cedula:");
        System.out.println(actual);
    }

    public void buscarMaximo() {

        if (isEmpty()) {
            System.out.println("Arbol vacio.");
            return;
        }

        Empleado actual = raiz;

        while (actual.derecho != null) {
            actual = actual.derecho;
        }

        System.out.println("Empleado con mayor cedula:");
        System.out.println(actual);
    }

    public void reporteEficiencia() {

        System.out.println("=== REPORTE DE EFICIENCIA ===");
        System.out.println("Altura del arbol: " + altura());
        System.out.println("Numero de hojas: " + contarHojas());
    }
}