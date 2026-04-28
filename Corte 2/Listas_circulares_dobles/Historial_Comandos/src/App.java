import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Terminal terminal = new Terminal();
        int opcion;

        do {
            System.out.println("\n==============================================");
            System.out.println("               Historial de Comandos");
            System.out.println("==============================================");
            System.out.println("1. Agregar comando");
            System.out.println("2. Arriba");
            System.out.println("3. Abajo");
            System.out.println("4. Mostrar cursor");
            System.out.println("5. Eliminar actual");
            System.out.println("6. Mostrar historial");
            System.out.println("0. Salir");
            System.out.println();
            System.out.print("Elige una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese comando: ");
                    String texto = sc.nextLine();

                    System.out.print("Fue exitoso? (true/false): ");
                    boolean exitoso = sc.nextBoolean();
                    sc.nextLine();

                    System.out.print("Ingrese directorio: ");
                    String directorio = sc.nextLine();

                    terminal.agregarComando(texto, exitoso, directorio);
                    System.out.println("Comando agregado");
                    break;

                case 2:
                    System.out.println("Cursor hacia arriba");
                    terminal.arriba();
                    terminal.mostrarCursor();
                    break;

                case 3:
                    System.out.println("Cursor hacia abajo");
                    terminal.abajo();
                    terminal.mostrarCursor();
                    break;

                case 4:
                    System.out.println("Cursor actual");
                    terminal.mostrarCursor();
                    break;

                case 5:
                    System.out.println("Eliminacion de comando actual");
                    terminal.eliminarActual();
                    terminal.mostrarCursor();
                    break;

                case 6:
                    System.out.println("Historial completo:");
                    terminal.mostrarHistorial();
                    break;

                case 0:
                    System.out.println("Saliendo del programa");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 0);

        sc.close();
    }
}