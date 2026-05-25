import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ColaPacientes urgencias = new ColaPacientes();
        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\n==============================================");
            System.out.println("   Urgencias Hospitalarias");
            System.out.println("==============================================");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Ver fila de pacientes");
            System.out.println("3. Atender paciente");
            System.out.println("4. Atender todos");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (opcion) {

                case 1:
                    System.out.print("Cedula: ");
                    String cedula = sc.nextLine();

                    System.out.print("Nombre completo: ");
                    String nombre = sc.nextLine();

                    System.out.print("Edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Sintoma principal: ");
                    String sintoma = sc.nextLine();

                    Paciente nuevo = new Paciente(cedula, nombre, edad, sintoma);

                    urgencias.enqueue(nuevo);

                    System.out.println("Paciente registrado.");
                    break;

                case 2:
                    urgencias.imprimir();
                    break;

                case 3:
                    Paciente atendido = urgencias.dequeue();

                    if (atendido != null) {
                        System.out.println("Paciente atendido:");
                        System.out.println(atendido);
                    } else {
                        System.out.println("No hay pacientes.");
                    }
                    break;

                case 4:
                    urgencias.atenderTodos();
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
