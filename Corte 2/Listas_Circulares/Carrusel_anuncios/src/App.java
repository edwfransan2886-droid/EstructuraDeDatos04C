import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcion;

        Pantalla pantalla = new Pantalla();

        do {
            System.out.println("\n==============================================");
            System.out.println("   Carrusel de Anuncios");
            System.out.println("==============================================");
            System.out.println("1. agregarAnuncio");
            System.out.println("2. mostrarAnuncios");
            System.out.println("3. reproducir");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");

            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese titulo: ");
                    String titulo = sc.next();

                    System.out.print("Ingrese duracion en segundos: ");
                    int duracion = sc.nextInt();

                    System.out.print("Ingrese categoria: ");
                    String categoria = sc.next();

                    Anuncio nuevo = new Anuncio(titulo, duracion, categoria);
                    pantalla.agregarAnuncio(nuevo);
                    break;

                case 2:
                    pantalla.mostrarAnuncios();
                    break;

                case 3:
                    System.out.print("Ingrese cantidad de ciclos: ");
                    int ciclos = sc.nextInt();
                    pantalla.reproducir(ciclos);
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}