import java.util.Scanner;

public class Monitoreo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaLecturas lista = new ListaLecturas();

        int opcion;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Agregar lectura");
            System.out.println("2. Mostrar temperatura maxima");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese ID del sensor: ");
                    int id = sc.nextInt();
                    System.out.print("Ingrese temperatura: ");
                    double temp = sc.nextDouble();
                    System.out.print("Ingrese presion: ");
                    double presion = sc.nextDouble();
                    sc.nextLine(); 
                    System.out.print("Ingrese la hora: ");
                    String hora = sc.nextLine();
                    lista.insertarAlInicio(id, temp, presion, hora);
                    System.out.println("Lectura agregada correctamente");
                    break;

                case 2:
                    lista.mostrarTemperaturaMaxima();
                    break;

                case 3:
                    System.out.println("Saliendo del sistema");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 3);

        sc.close();
    }
}