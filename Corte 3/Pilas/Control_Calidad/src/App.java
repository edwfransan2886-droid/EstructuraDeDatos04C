/*2. Control de Calidad (Línea de Ensamblaje)
Un brazo robótico en una fábrica de motores apila componentes siguiendo una secuencia precisa. Un sensor de visión artificial inspecciona cada pieza después de ser colocada.

La Clase Pieza (Nodo): Debe contener nombrePieza (String), numeroSerie (String) y esDefectuosa (boolean).
El Problema: Si el sensor detecta una pieza defectuosa, la línea de producción debe detenerse inmediatamente.
Reto: Crea un método limpiarHastaDefecto() que extraiga (pop) todas las piezas de la pila hasta encontrar la primera que tenga esDefectuosa = true. El método debe imprimir el nombre de todas las piezas "buenas" que tuvieron que ser retiradas y descartadas antes de llegar a la pieza fallida. */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Produccion linea = new Produccion();
        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\n==============================================");
            System.out.println("            Control de Calidad");
            System.out.println("==============================================");
            System.out.println("1. Agregar pieza");
            System.out.println("2. Ver pila");
            System.out.println("3. Limpiar hasta defecto");
            System.out.println("0. Salir");
            System.out.println();
            System.out.print("Elige una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (opcion) {

                case 1:
                    System.out.print("Nombre de la pieza: ");
                    String nombre = sc.nextLine();

                    System.out.print("Numero de serie: ");
                    String serie = sc.nextLine();

                    System.out.print("Es defectuosa? (true/false): ");
                    boolean defecto = sc.nextBoolean();
                    sc.nextLine();

                    Pieza nueva = new Pieza(nombre, serie, defecto);
                    linea.push(nueva);

                    System.out.println("Pieza agregada correctamente");
                    break;

                case 2:
                    linea.imprimir();
                    break;

                case 3:
                    linea.limpiarHastaDefecto();
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