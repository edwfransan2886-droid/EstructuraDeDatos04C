public class Historial {
    Pagina cabeza;

    public Historial() {
        this.cabeza = null;
    }

    public void visitarPagina(String url, String titulo) {

        if (url.trim().isEmpty()) {
            System.out.println("La URL no puede estar vacia");
            return;
        }

        Pagina nueva = new Pagina(url, titulo);

        if (cabeza == null) {
            cabeza = nueva;
        } else {
            Pagina actual = cabeza;

            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }

            actual.siguiente = nueva;
        }

        System.out.println("Pagina agregada al historial");
    }

    public void buscarPorUrl(String urlBuscar) {

        if (cabeza == null) {
            System.out.println("Historial vacio");
            return;
        }

        Pagina actual = cabeza;

        while (actual != null) {

            if (actual.url.equalsIgnoreCase(urlBuscar)) {
                actual.visitas++;
                System.out.println("Pagina encontrada:");
                System.out.println("Titulo: " + actual.titulo);
                System.out.println("URL: " + actual.url);
                System.out.println("Visitas: " + actual.visitas);
                return;
            }

            actual = actual.siguiente;
        }

        System.out.println("Pagina no encontrada");
    }

    public void verHistorial() {

        if (cabeza == null) {
            System.out.println("No hay paginas en el historial");
            return;
        }

        Pagina actual = cabeza;
        int totalVisitas = 0;

        System.out.println("=== Historial de Navegacion ===");

        while (actual != null) {
            System.out.println("Titulo: " + actual.titulo +
                    " | URL: " + actual.url +
                    " | Visitas: " + actual.visitas);

            totalVisitas += actual.visitas;
            actual = actual.siguiente;
        }

        System.out.println("Total de visitas del usuario: " + totalVisitas);
    }

    public void paginaTop() {

        if (cabeza == null) {
            System.out.println("Historial vacio");
            return;
        }

        Pagina actual = cabeza;
        Pagina top = cabeza;

        while (actual != null) {

            if (actual.visitas > top.visitas) {
                top = actual;
            }

            actual = actual.siguiente;
        }

        System.out.println("=== Pagina Top ===");
        System.out.println("Titulo: " + top.titulo);
        System.out.println("URL: " + top.url);
        System.out.println("Visitas: " + top.visitas);
    }
}