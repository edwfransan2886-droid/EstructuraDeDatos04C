/*5. Fábrica de Pedidos (E-commerce)
Una tienda en línea recibe pedidos de manera continua. Cada pedido ingresa a una cola central de procesamiento. El sistema de bodega toma los pedidos en orden de llegada para preparar el envío. Si un pedido ya fue cancelado por el cliente, debe ser descartado automáticamente al momento de ser procesado.

La Clase Pedido (Nodo): Debe contener numeroPedido (String), cliente (String), totalPagar (double) y cancelado (boolean).
El Problema: La bodega necesita procesar solo los pedidos vigentes. Los cancelados deben ser eliminados sin ser despachados, pero registrados en un conteo.
Reto: Implementa un método procesarPedidos() que recorra y vacíe la cola. Para cada pedido: si cancelado = true, lo descarta e incrementa un contador de cancelados; si cancelado = false, lo "despacha" imprimiendo sus datos. Al finalizar, muestra el total despachado y el total cancelado. */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ColaPedidos tienda = new ColaPedidos();
        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\n==============================================");
            System.out.println("              Fabrica de Pedidos");
            System.out.println("==============================================");
            System.out.println("1. Registrar pedido");
            System.out.println("2. Ver cola de pedidos");
            System.out.println("3. Procesar un pedido");
            System.out.println("4. Procesar todos los pedidos");
            System.out.println("0. Salir");
            System.out.println();
            System.out.print("Elige una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (opcion) {

                case 1:
                    System.out.print("Numero de pedido: ");
                    String numero = sc.nextLine();

                    System.out.print("Cliente: ");
                    String cliente = sc.nextLine();

                    System.out.print("Total a pagar: ");
                    double total = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Pedido cancelado? (true/false): ");
                    boolean cancelado = sc.nextBoolean();
                    sc.nextLine();

                    Pedido nuevo = new Pedido(numero, cliente, total, cancelado);

                    tienda.enqueue(nuevo);

                    System.out.println("Pedido agregado");
                    break;

                case 2:
                    tienda.imprimir();
                    break;

                case 3:
                    Pedido procesado = tienda.dequeue();

                    if (procesado != null) {
                        System.out.println("Pedido procesado:");
                        System.out.println(procesado);
                    } else {
                        System.out.println("No hay pedidos");
                    }
                    break;

                case 4:
                    tienda.procesarPedidos();
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
