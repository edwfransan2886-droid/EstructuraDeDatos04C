import java.util.Scanner;

public class Spotify {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaReproduccion lista = new ListaReproduccion();

        int opcion;

        do {
            System.out.println("\n--- SPOTIFY LITE ---");
            System.out.println("1. Agregar cancion al final");
            System.out.println("2. Agregar cancion después de la actual");
            System.out.println("3. Mostrar lista");
            System.out.println("4. Mostrar duracion total");
            System.out.println("5. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                case 2:
                    System.out.print("Titulo: ");
                    String titulo = sc.nextLine();
                    System.out.print("Artista: ");
                    String artista = sc.nextLine();
                    System.out.print("Duracion: ");
                    int duracion = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Genero: ");
                    String genero = sc.nextLine();

                    if (opcion == 1) {
                        lista.agregarAlFinal(titulo, artista, duracion, genero);
                    } else {
                        lista.agregarDespuesActual(titulo, artista, duracion, genero);
                    }

                    System.out.println("Cancion agregada");
                    break;

                case 3:
                    lista.mostrarLista();
                    break;

                case 4:
                    lista.mostrarDuracionTotal();
                    break;

                case 5:
                    System.out.println("Saliendo");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 5);

        sc.close();
    }
}