public class Galeria {
    Fotografia cabeza;
    Fotografia cola;

    public Galeria() {
        this.cabeza = null;
        this.cola = null;
    }

    public void agregarFoto(Fotografia foto) {
        if (cabeza == null) {
            cabeza = foto;
            cola = foto;
        } else {
            cola.siguiente = foto;
            foto.anterior = cola;
            cola = foto;
        }
    }

    public Fotografia siguiente(Fotografia actual) {
        if (actual.siguiente == null) {
            System.out.println("No hay mas fotos adelante");
            return actual;
        }
        return actual.siguiente;
    }

    public Fotografia anterior(Fotografia actual) {
        if (actual.anterior == null) {
            System.out.println("No hay mas fotos atras");
            return actual;
        }
        return actual.anterior;
    }

    public void reproducirGaleria() {
        if (cabeza == null) {
            System.out.println("Galeria vacia");
            return;
        }

        System.out.println("Recorrido hacia adelante:");
        Fotografia temp = cabeza;
        while (temp != null) {
            System.out.println(temp.nombreArchivo + " | " + temp.tamanoMB + "MB | " + temp.resolucion);
            if (temp.siguiente == null) break;
            temp = temp.siguiente;
        }

        System.out.println("\nRecorrido hacia atras:");
        while (temp != null) {
            System.out.println(temp.nombreArchivo + " | " + temp.tamanoMB + "MB | " + temp.resolucion);
            temp = temp.anterior;
        }
    }
}
