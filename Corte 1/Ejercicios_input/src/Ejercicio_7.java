/*Ejercicio 7 — Arreglo compartido (inventario)
Pide al usuario 4 precios para llenar un arreglo precios[]. Crea preciosAuditoria = precios (misma referencia). Pide al usuario el índice y el nuevo precio para hacer una corrección desde preciosAuditoria. Muestra ambos arreglos y verifica que el cambio se refleja en los dos.

Datos de entrada: double × 4 precios, int índice, double nuevo precio */

import java.util.Scanner;
public class Ejercicio_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] precios = new double[4];
        for (int i = 0; i < precios.length; i++) {
            System.out.print("Ingrese el precio " + (i + 1) + ": ");
            precios[i] = scanner.nextDouble();
        }

        double[] preciosAuditoria = precios;

        System.out.print("Ingrese el índice a corregir (0-3): ");
        int indice = scanner.nextInt();

        System.out.print("Ingrese el nuevo precio: ");
        double nuevoPrecio = scanner.nextDouble();

        preciosAuditoria[indice] = nuevoPrecio;

        System.out.println("\nPrecios desde arreglo original:");
        for (int i = 0; i < precios.length; i++) {
            System.out.println("Precio " + (i + 1) + ": " + precios[i]);
        }

        System.out.println("\nPrecios desde arreglo auditoria:");
        for (int i = 0; i < preciosAuditoria.length; i++) {
            System.out.println("Precio " + (i + 1) + ": " + preciosAuditoria[i]);
        }

        System.out.println("\nEl cambio se refleja en ambos arreglos porque ambos apuntan a la misma referencia en memoria.");

        scanner.close();
    }
}
