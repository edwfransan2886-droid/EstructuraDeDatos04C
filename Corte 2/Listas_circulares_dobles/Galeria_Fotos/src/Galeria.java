public class Galeria {
    Foto cabeza;
    Foto cola;
    Foto actual;

    public Galeria() {
        this.cabeza = null;
        this.cola = null;
        this.actual = null;
    }

    public void agregarFoto(String titulo, String fecha) {
        Foto nueva = new Foto(titulo, fecha);

        if (cabeza == null) {
            cabeza = nueva;
            cola = nueva;
            nueva.siguiente = nueva;
            nueva.anterior = nueva;
        } else {
            cola.siguiente = nueva;
            nueva.anterior = cola;
            nueva.siguiente = cabeza;
            cabeza.anterior = nueva;
            cola = nueva;
        }

        actual = nueva;
    }

    public void siguiente() {
        if (actual != null) {
            actual = actual.siguiente;
        }
    }

    public void anterior() {
        if (actual != null) {
            actual = actual.anterior;
        }
    }

    public void toggleFavorita() {
        if (actual != null) {
            actual.esFavorita = !actual.esFavorita;
        }
    }

    public void eliminarActual() {
        if (actual == null) return;

        if (cabeza == cola) {
            cabeza = null;
            cola = null;
            actual = null;
            return;
        }

        Foto eliminar = actual;

        eliminar.anterior.siguiente = eliminar.siguiente;
        eliminar.siguiente.anterior = eliminar.anterior;

        if (eliminar == cabeza) {
            cabeza = eliminar.siguiente;
        }

        if (eliminar == cola) {
            cola = eliminar.anterior;
        }

        actual = eliminar.siguiente;
    }

    public void mostrarActual() {
        if (actual == null) {
            System.out.println("No hay fotos");
            return;
        }

        System.out.println("Actual: " + actual.titulo + " | " + actual.fecha);
    }

    public void mostrarGaleria() {
        if (cabeza == null) {
            System.out.println("Galeria vacia");
            return;
        }

        Foto temp = cabeza;

        do {
            String marca = "";

            if (temp == actual) {
                marca += "[▶] ";
            }

            if (temp.esFavorita) {
                marca += "[★] ";
            }

            System.out.println(marca + temp.titulo + " | " + temp.fecha);

            temp = temp.siguiente;

        } while (temp != cabeza);
    }
}    

