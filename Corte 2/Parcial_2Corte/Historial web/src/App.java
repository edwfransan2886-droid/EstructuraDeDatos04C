import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Historial historial = new Historial();

        int opcion;

        do {
            System.out.println("\n==============================================");
            System.out.println("   Historial de Navegacion");
            System.out.println("==============================================");
            System.out.println("1. Visitar pagina");
            System.out.println("2. Buscar por URL");
            System.out.println("3. Ver historial");
            System.out.println("4. Pagina top");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese URL: ");
                    String url = sc.nextLine();

                    if (url.trim().isEmpty()) {
                        System.out.println("La URL esta vacia");
                        break;
                    }

                    System.out.print("Ingrese titulo: ");
                    String titulo = sc.nextLine();

                    historial.visitarPagina(url, titulo);
                    break;

                case 2:
                    System.out.print("Ingrese URL a buscar: ");
                    String urlBuscar = sc.nextLine();

                    historial.buscarPorUrl(urlBuscar);
                    break;

                case 3:
                    historial.verHistorial();
                    break;

                case 4:
                    historial.paginaTop();
                    break;

                case 0:
                    System.out.println("Saliendo");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 0);

        sc.close();
    }
}