class ListaReproduccion {
    private Cancion cabeza;
    private Cancion actual;

    public void agregarAlFinal(String titulo, String artista, int duracion, String genero) {
        Cancion nueva = new Cancion(titulo, artista, duracion, genero);

        if (cabeza == null) {
            cabeza = nueva;
            actual = nueva;
        } else {
            Cancion temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nueva;
        }
    }
    public void agregarDespuesActual(String titulo, String artista, int duracion, String genero) {
        if (actual == null) {
            System.out.println("No hay cancion actual");
            return;
        }
        Cancion nueva = new Cancion(titulo, artista, duracion, genero);
        nueva.siguiente = actual.siguiente;
        actual.siguiente = nueva;
    }
    public void mostrarLista() {
        Cancion temp = cabeza;
        while (temp != null) {
            System.out.println(temp.titulo + " - " + temp.artista + " (" + temp.duracionSegundos + "s)");
            temp = temp.siguiente;
        }
    }
    public void mostrarDuracionTotal() {
        int totalSegundos = 0;
        Cancion temp = cabeza;

        while (temp != null) {
            totalSegundos += temp.duracionSegundos;
            temp = temp.siguiente;
        }
        int minutos = totalSegundos / 60;
        int segundos = totalSegundos % 60;

        System.out.println("\nDuracion total: " + minutos + ":" + segundos);
    }
}