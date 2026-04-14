public class Pantalla {
    Anuncio cabeza;
    Anuncio cola;

    public Pantalla() {
        this.cabeza = null;
        this.cola = null;
    }

    public void agregarAnuncio(Anuncio anuncio) {
        if (cabeza == null) {
            cabeza = anuncio;
            cola = anuncio;
            anuncio.siguiente = cabeza;
        } else {
            cola.siguiente = anuncio;
            anuncio.siguiente = cabeza;
            cola = anuncio;
        }
    }

    public void mostrarAnuncios() {
        if (cabeza == null) {
            System.out.println("No hay anuncios");
            return;
        }

        Anuncio actual = cabeza;
        do {
            System.out.println(actual.titulo + " | " + actual.duracionSegundos + "s | " + actual.categoria);
            actual = actual.siguiente;
        } while (actual != cabeza);
    }

    public void reproducir(int ciclos) {
        if (cabeza == null) {
            System.out.println("No hay anuncios");
            return;
        }

        int tiempoTotal = 0;
        Anuncio masRepetido = cabeza;

        for (int i = 0; i < ciclos; i++) {

            Anuncio temp = cabeza;

            do {
                System.out.println("Mostrando: " + temp.titulo);

                temp.vecesRepetido++;
                tiempoTotal += temp.duracionSegundos;

                if (temp.vecesRepetido > masRepetido.vecesRepetido) {
                    masRepetido = temp;
                }

                temp = temp.siguiente;

            } while (temp != cabeza);
        }

        System.out.println("\nAnuncio mas repetido: " + masRepetido.titulo + 
                           " (" + masRepetido.vecesRepetido + " veces)");

        System.out.println("Tiempo total acumulado: " + tiempoTotal + " segundos");
    }
}