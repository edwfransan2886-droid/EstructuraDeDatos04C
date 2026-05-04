public class Pagina {
    String url;
    String titulo;
    int visitas;

    Pagina siguiente;

    public Pagina(String url, String titulo) {
        this.url = url;
        this.titulo = titulo;
        this.visitas = 1;
        this.siguiente = null;
    }
}