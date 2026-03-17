/*Ejercicio 2: Competencia de Atletismo (Inserción)
Objetivo: Ingresar puntajes y organizarlos de mayor a menor para determinar el podio.
¿Qué debes hacer?
1. Entrada: Pide al usuario que ingrese 6 puntajes (números enteros) por teclado.
2. Ordenamiento: Usa Inserción (Insertion Sort) para ordenar los puntajes de mayor a menor.
3. Búsqueda: Pide un puntaje al usuario y búscalo usando Búsqueda Lineal. Indica en qué posición (lugar) de la
tabla quedó.
Ejemplo de lo que se debe ver en consola:
--- INGRESO DE PUNTAJES ---
Puntaje del Intento 1: 85
Puntaje del Intento 2: 98
Puntaje del Intento 3: 70
... (hasta llegar a 6) ...
--- TABLA DE RESULTADOS (De mayor a menor) ---
1° Lugar: 98
2° Lugar: 85
3° Lugar: 70
...
El promedio total de los puntajes fue: 84.3
--- BÚSQUEDA LINEAL ---
Ingrese puntaje a buscar: 85
>> El puntaje 85 se encuentra en el 2° lugar de la tabla.
 */

import java.util.Scanner;

public class ejercicio2_repaso {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] puntajes = new int[6];
        int suma = 0;

        System.out.println("--- INGRESO DE PUNTAJES ---");
        for (int i = 0; i < puntajes.length; i++) {
            System.out.print("Puntaje del Intento " + (i + 1) + ": ");
            puntajes[i] = scanner.nextInt();
            suma += puntajes[i];
        }

        // Ordenamiento por Inserción de mayor a menor
        for (int i = 1; i < puntajes.length; i++) {
            int key = puntajes[i];
            int j = i - 1;
            while (j >= 0 && puntajes[j] < key) {
                puntajes[j + 1] = puntajes[j];
                j--;
            }
            puntajes[j + 1] = key;
        }

        System.out.println("\n--- TABLA DE RESULTADOS ---");
        for (int i = 0; i < puntajes.length; i++) {
            System.out.println((i + 1) + " Lugar: " + puntajes[i]);
        }

        double promedio = (double) suma / puntajes.length;
        System.out.println("\nEl promedio total de los puntajes fue: " + promedio);

        System.out.println("\n--- BUSQUEDA LINEAL ---");
        System.out.print("Ingrese puntaje a buscar: ");
        int busqueda = scanner.nextInt();
        boolean encontrado = false;

        for (int i = 0; i < puntajes.length; i++) {
            if (puntajes[i] == busqueda) {
                System.out.println(" El puntaje " + busqueda + " se encuentra en el " + (i + 1) + "° lugar de la tabla.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println(">> El puntaje " + busqueda + " no se encuentra en la tabla.");
        }

        scanner.close();
    }
}