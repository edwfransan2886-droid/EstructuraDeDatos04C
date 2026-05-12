/*5. Ruta de Rescate (Espeleología Geológica)
Un equipo de rescatistas entra en una cueva inexplorada. Para no perderse, van dejando "Estaciones de Seguridad" representadas por una baliza que registra los datos del entorno.

La Clase Estacion (Nodo): Debe contener nombrePunto (String), profundidad (int) y nivelOxigeno (double).
El Problema: Para salir de la cueva, el equipo debe seguir las estaciones en el orden inverso al que fueron colocadas (de la más profunda a la entrada).
Reto: Implementa el método retrocederASuperficie(). Este debe mostrar el nombre de cada estación a medida que se desapila. Importante: Si en alguna estación el nivelOxigeno es inferior al 18%, el sistema debe imprimir una alerta de "Uso de Tanque de Emergencia Requerido" al pasar por ese punto. */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        PilaRescate cueva = new PilaRescate();
        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\n==============================================");
            System.out.println("                Ruta de Rescate");
            System.out.println("==============================================");
            System.out.println("1. Registrar estacion");
            System.out.println("2. Ver ruta actual");
            System.out.println("3. Retroceder a superficie");
            System.out.println("0. Salir");
            System.out.println();
            System.out.print("Elige una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (opcion) {

                case 1:
                    System.out.print("Nombre del punto: ");
                    String nombre = sc.nextLine();

                    System.out.print("Profundidad: ");
                    int profundidad = sc.nextInt();

                    System.out.print("Nivel de oxigeno: ");
                    double oxigeno = sc.nextDouble();
                    sc.nextLine();

                    Estacion nueva = new Estacion(nombre, profundidad, oxigeno);
                    cueva.push(nueva);

                    System.out.println("Estacion registrada");
                    break;

                case 2:
                    cueva.imprimir();
                    break;

                case 3:
                    cueva.retrocederASuperficie();
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