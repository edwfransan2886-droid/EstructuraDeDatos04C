import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Galeria galeria = new Galeria();
        int opcion;

        do {
            System.out.println("\n==============================================");
            System.out.println("   Galeria de Fotos");
            System.out.println("==============================================");
            System.out.println("1. Agregar foto");
            System.out.println("2. Siguiente");
            System.out.println("3. Anterior");
            System.out.println("4. Marcar favorita");
            System.out.println("5. Eliminar actual");
            System.out.println("6. Mostrar galeria");
            System.out.println();
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (opcion) {

                case 1:
                    System.out.print("Titulo: ");
                    String titulo = sc.nextLine();

                    System.out.print("Fecha: ");
                    String fecha = sc.nextLine();

                    galeria.agregarFoto(titulo, fecha);
                    System.out.println("Foto agregada");
                    break;

                case 2:
                    System.out.println("Siguiente foto");
                    galeria.siguiente();
                    galeria.mostrarActual();
                    break;

                case 3:
                    System.out.println("Foto anterior");
                    galeria.anterior();
                    galeria.mostrarActual();
                    break;

                case 4:
                    galeria.toggleFavorita();
                    System.out.println("Estado de favorita cambiado");
                    break;

                case 5:
                    System.out.println("Eliminar foto actual");
                    galeria.eliminarActual();
                    break;

                case 6:
                    galeria.mostrarGaleria();
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
