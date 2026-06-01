public class ArbolRepuestos {

    private Repuesto raiz;

    public ArbolRepuestos() {
        this.raiz = null;
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    private Repuesto insertar(Repuesto nodo,int codigoRef,String descripcion,String marca,int stock) {

        if (nodo == null)
            return new Repuesto(codigoRef, descripcion, marca, stock);

        if (codigoRef < nodo.codigoRef)
            nodo.izquierdo = insertar(nodo.izquierdo,codigoRef,descripcion,marca,stock);

        else if (codigoRef > nodo.codigoRef)
            nodo.derecho = insertar(nodo.derecho,codigoRef,descripcion,marca,stock);

        else
            System.out.println("Ya existe un repuesto con codigo " + codigoRef);

        return nodo;
    }

    public void insertar(int codigoRef,String descripcion,String marca,int stock) {

        raiz = insertar(raiz,codigoRef,descripcion,marca, stock);
    }


    private Repuesto buscar(Repuesto nodo, int codigoRef) {

        if (nodo == null)
            return null;

        if (codigoRef == nodo.codigoRef)
            return nodo;

        if (codigoRef < nodo.codigoRef)
            return buscar(nodo.izquierdo, codigoRef);
        else
            return buscar(nodo.derecho, codigoRef);
    }

    public Repuesto buscar(int codigoRef) {
        return buscar(raiz, codigoRef);
    }

    private void preOrden(Repuesto nodo) {

        if (nodo != null) {

            System.out.println("[" + nodo.codigoRef + "] " + nodo.descripcion + " - " + nodo.marca + " (" + nodo.stock + " uds)");

            preOrden(nodo.izquierdo);
            preOrden(nodo.derecho);
        }
    }

    public void backupPreOrden() {

        if (isEmpty()) {
            System.out.println("Arbol vacio.");
            return;
        }

        System.out.println("=== BACKUP DEL INVENTARIO ===");
        preOrden(raiz);
    }

    private int contarHojas(Repuesto nodo) {

        if (nodo == null)
            return 0;

        if (nodo.izquierdo == null && nodo.derecho == null)
            return 1;

        return contarHojas(nodo.izquierdo) + contarHojas(nodo.derecho);
    }

    public int contarHojas() {
        return contarHojas(raiz);
    }

    public void reporteRepuestosUnicos() {

        System.out.println("Cantidad de repuestos sin variantes relacionadas: " + contarHojas());
    }
}