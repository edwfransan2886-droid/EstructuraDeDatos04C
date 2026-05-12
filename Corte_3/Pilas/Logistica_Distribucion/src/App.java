/*3. Logística de Distribución (Callejón sin Salida)
Un centro de logística urbana tiene un muelle de carga ubicado al final de un callejón muy estrecho. Los camiones de reparto entran uno tras otro y quedan "atrapados" en el orden de llegada. El último camión en entrar debe ser obligatoriamente el primero en salir para permitir que los demás se retiren.

La Clase Camion (Nodo): Debe contener placa (String), conductor (String) y cargaToneladas (double).
El Problema: El supervisor necesita saber cuánta carga total hay en el callejón sin mover los camiones físicamente (solo consultando la estructura).
Reto: Implementa un método que recorra la pila (sin destruirla permanentemente, o reconstruyéndola) y calcule la suma total de cargaToneladas de todos los camiones estacionados. */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        PilaCamiones callejon = new PilaCamiones();
        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\n==============================================");
            System.out.println("            Logistica de Distribucion");
            System.out.println("==============================================");
            System.out.println("1. Registrar camion");
            System.out.println("2. Ver camiones");
            System.out.println("3. Retirar camion del tope");
            System.out.println("4. Calcular carga total");
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

                    System.out.print("Conductor: ");
                    String conductor = sc.nextLine();

                    System.out.print("Carga en toneladas: ");
                    double carga = sc.nextDouble();
                    sc.nextLine();

                    Camion nuevo = new Camion(placa, conductor, carga);
                    callejon.push(nuevo);

                    System.out.println("Camion registrado");
                    break;

                case 2:
                    callejon.imprimir();
                    break;

                case 3:
                    Camion retirado = callejon.pop();

                    if (retirado != null) {
                        System.out.println("Camion retirado: " + retirado);
                    } else {
                        System.out.println("No hay camiones");
                    }
                    break;

                case 4:
                    double total = callejon.calcularCargaTotal();
                    System.out.println("Carga total en el callejon: " + total + " toneladas");
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
