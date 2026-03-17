/*Ejercicio 3: Control de Notas (Selección)
Objetivo: Gestionar las notas de un grupo, encontrar los valores extremos y ordenar la lista.
¿Qué debes hacer?
1. Entrada: Pide al usuario 5 notas (números decimales) por teclado.
2. Estadísticas: Recorre el arreglo para encontrar cuál es la nota más alta y cuál la más baja del grupo.
3. Ordenamiento: Ordena las notas de menor a mayor usando Selección (Selection Sort).
Ejemplo de lo que se debe ver en consola:
--- REGISTRO DE NOTAS ---
Ingrese nota del Estudiante 1: 3.5
Ingrese nota del Estudiante 2: 4.8
Ingrese nota del Estudiante 3: 2.0
... (hasta completar las 5) ...
--- INFORME ACADÉMICO ---
La nota más ALTA del grupo es: 4.8
La nota más BAJA del grupo es: 2.0
--- LISTA DE NOTAS ORDENADA (Menor a Mayor) ---
[2.0, 3.0, 3.5, 4.2, 4.8] */
/*pide */

import java.util.Scanner;

public class ejercicio3_repaso {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] notas = new double[5];

        System.out.println("--- REGISTRO DE NOTAS ---");
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Ingrese nota del Estudiante " + (i + 1) + ": ");
            notas[i] = sc.nextDouble();
        }

        double max = notas[0];
        double min = notas[0];
        for (double nota : notas) {
            if (nota > max) max = nota;
            if (nota < min) min = nota;
        }

        System.out.println("\n--- INFORME ACADÉMICO ---");
        System.out.println("La nota más ALTA del grupo es: " + max);
        System.out.println("La nota más BAJA del grupo es: " + min);

        // Ordenamiento por Selección
        for (int i = 0; i < notas.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < notas.length; j++) {
                if (notas[j] < notas[minIndex]) {
                    minIndex = j;
                }
            }
            double temp = notas[minIndex];
            notas[minIndex] = notas[i];
            notas[i] = temp;
        }

        System.out.println("\n--- LISTA DE NOTAS ORDENADA (Menor a Mayor) ---");
        System.out.print("[");
        for (int i = 0; i < notas.length; i++) {
            System.out.print(notas[i]);
            if (i < notas.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}

