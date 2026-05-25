import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ColaPeaje peaje = new ColaPeaje();
        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\n==============================================");
            System.out.println("             Peaje Inteligente");
            System.out.println("==============================================");
            System.out.println("1. Registrar vehiculo");
            System.out.println("2. Ver fila de vehiculos");
            System.out.println("3. Cobrar vehiculo");
            System.out.println("4. Cerrar turno");
            System.out.println("0. Salir");
            System.out.println();
            System.out.print("Elige una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (opcion) {

                case 1:
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();

                    System.out.print("Tipo de vehiculo: ");
                    String tipo = sc.nextLine();

                    System.out.print("Tarifa: ");
                    double tarifa = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Es exento? (true/false): ");
                    boolean exento = sc.nextBoolean();
                    sc.nextLine();

                    Vehiculo nuevo = new Vehiculo(placa, tipo, tarifa, exento);

                    peaje.enqueue(nuevo);

                    System.out.println("Vehiculo agregado a la fila");
                    break;

                case 2:
                    peaje.imprimir();
                    break;

                case 3:
                    Vehiculo atendido = peaje.dequeue();

                    if (atendido != null) {
                        System.out.println("Vehiculo procesado:");
                        System.out.println(atendido);
                    } else {
                        System.out.println("No hay vehiculos");
                    }
                    break;

                case 4:
                    peaje.cerrarTurno();
                    break;

                case 0:
                    System.out.println("Saliendo");
                    break;

                default:
                    System.out.println("Opcion no valida");
            }

        } while (opcion != 0);

        sc.close();
    }
}
