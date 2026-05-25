/*3. Impresora Compartida (Red de Oficina)
En una oficina de arquitectura, varias computadoras comparten una única impresora de gran formato. Cada vez que alguien envía un documento, este se agrega al final de la cola de impresión. La impresora procesa los trabajos en el orden exacto en que fueron recibidos.

La Clase Documento (Nodo): Debe contener nombreArchivo (String), usuario (String), numeroPaginas (int) y esColor (boolean).
El Problema: Antes de imprimir, el jefe de oficina quiere saber cuántas páginas en total tiene la cola de impresión pendiente.
Reto: Implementa un método calcularPaginasTotales() que recorra la cola y retorne la suma de numeroPaginas de todos los documentos en espera, sin alterar la cola. */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ColaImpresion impresora = new ColaImpresion();
        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\n==============================================");
            System.out.println("             Cola de Impresion");
            System.out.println("==============================================");
            System.out.println("1. Agregar documento");
            System.out.println("2. Ver cola");
            System.out.println("3. Imprimir documento");
            System.out.println("4. Calcular paginas totales");
            System.out.println("0. Salir");
            System.out.println();
            System.out.print("Elige una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (opcion) {

                case 1:
                    System.out.print("Nombre del archivo: ");
                    String archivo = sc.nextLine();

                    System.out.print("Usuario: ");
                    String usuario = sc.nextLine();

                    System.out.print("Numero de paginas: ");
                    int paginas = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Es a color? (true/false): ");
                    boolean color = sc.nextBoolean();
                    sc.nextLine();

                    Documento nuevo = new Documento(archivo, usuario, paginas, color);

                    impresora.enqueue(nuevo);

                    System.out.println("Documento agregado a la cola");
                    break;

                case 2:
                    impresora.imprimir();
                    break;

                case 3:
                    Documento impreso = impresora.dequeue();

                    if (impreso != null) {
                        System.out.println("Documento impreso:");
                        System.out.println(impreso);
                    } else {
                        System.out.println("No hay documentos");
                    }
                    break;

                case 4:
                    int total = impresora.calcularPaginasTotales();

                    System.out.println("Total de paginas pendientes: " + total);
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