public class ArbolLibros {

    private Libro raiz;

    public ArbolLibros() {
        this.raiz = null;
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    private Libro insertar(Libro nodo, long isbn, String titulo, String autor, int anioPublicacion) {

        if (nodo == null)
            return new Libro(isbn, titulo, autor, anioPublicacion);

        if (isbn < nodo.isbn)
            nodo.izquierdo = insertar(nodo.izquierdo, isbn, titulo, autor, anioPublicacion);

        else if (isbn > nodo.isbn)
            nodo.derecho = insertar(nodo.derecho, isbn, titulo, autor, anioPublicacion);

        else
            System.out.println("Ya existe un libro con ISBN " + isbn);

        return nodo;
    }

    public void insertar(long isbn, String titulo, String autor, int anioPublicacion) {
        raiz = insertar(raiz, isbn, titulo, autor, anioPublicacion);
    }

    private Libro buscar(Libro nodo, long isbn) {

        if (nodo == null)
            return null;

        if (isbn == nodo.isbn)
            return nodo;

        if (isbn < nodo.isbn)
            return buscar(nodo.izquierdo, isbn);
        else
            return buscar(nodo.derecho, isbn);
    }

    public Libro buscar(long isbn) {
        return buscar(raiz, isbn);
    }

    public boolean existeISBN(long isbn) {
        return buscar(isbn) != null;
    }

    private void imprimirCatalogo(Libro nodo) {

        if (nodo != null) {

            imprimirCatalogo(nodo.izquierdo);

            System.out.println(nodo.isbn + " - " +nodo.titulo + " - " + nodo.autor);

            imprimirCatalogo(nodo.derecho);
        }
    }

    public void imprimirCatalogo() {

        if (isEmpty()) {
            System.out.println("Catalogo vacio.");
            return;
        }

        System.out.println("=== CATALOGO DE LIBROS ===");
        imprimirCatalogo(raiz);
    }
}