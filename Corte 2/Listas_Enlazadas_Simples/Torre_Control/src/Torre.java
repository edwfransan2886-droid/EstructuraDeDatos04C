import java.util.Scanner;

public class Torre {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TorreControl torre = new TorreControl();
        int opcion;

        do {
            System.out.println("\n=== TORRE DE CONTROL ===");
            System.out.println("1. Agregar vuelo");
            System.out.println("2. Reportar emergencia");
            System.out.println("3. Mostrar cola");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {

                case 1:
                    System.out.print("Numero de vuelo: ");
                    String numero = sc.nextLine();
                    System.out.print("Aerolinea: ");
                    String aerolinea = sc.nextLine();
                    System.out.print("Combustible restante: ");
                    int combustible = sc.nextInt();
                    System.out.print("Cantidad de pasajeros: ");
                    int pasajeros = sc.nextInt();
                    sc.nextLine();

                    torre.agregarVuelo(numero, aerolinea, combustible, pasajeros);
                    break;

                case 2:
                    System.out.print("Numero de vuelo en emergencia: ");
                    String emergencia = sc.nextLine();
                    torre.reportarEmergencia(emergencia);
                    break;

                case 3:
                    System.out.println("\n=== COLA DE VUELOS ===");
                    torre.mostrarCola();
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