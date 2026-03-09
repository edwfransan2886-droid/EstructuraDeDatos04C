/*1. El Podio de la Competencia
Algoritmo obligatorio: Ordenamiento por Selección (Selection Sort)

Contexto: Se ha realizado una carrera de 100 metros planos y el comité olímpico necesita determinar quiénes ganaron las medallas.
Detalle del ejercicio: El programa debe solicitar primero cuántos corredores participaron (ej. 5 a 10). Luego, debe pedir el tiempo en segundos (con decimales) de cada corredor.
Lógica de Selección: El algoritmo debe buscar el tiempo más bajo (el más rápido) en cada iteración y colocarlo al inicio.
Resultado esperado: El programa debe imprimir el arreglo totalmente ordenado y, adicionalmente, mostrar un mensaje claro indicando quién obtuvo el Oro (1er lugar), Plata (2do lugar) y Bronce (3er lugar). */

import java.util.Scanner;
public class Ejercicio_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el numero de corredores del 5 al 10: ");
        int numCorredores = scanner.nextInt();
        
        while (numCorredores < 5 || numCorredores > 10) {
            System.out.print("Numero invalido. Ingrese un número entre 5 y 10: ");
            numCorredores = scanner.nextInt();
        }
        
        double[] tiempos = new double[numCorredores];
        for (int i = 0; i < numCorredores; i++) {
            System.out.print("Ingrese el tiempo del corredor " + (i + 1) + " en segundos: ");
            tiempos[i] = scanner.nextDouble();
        }
        
        for (int i = 0; i < tiempos.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < tiempos.length; j++) {
                if (tiempos[j] < tiempos[minIndex]) {
                    minIndex = j;
                }
            }
       
            double temp = tiempos[i];
            tiempos[i] = tiempos[minIndex];
            tiempos[minIndex] = temp;
        }
        
        System.out.println("\nResultados:");
        for (int i = 0; i < tiempos.length; i++) {
            System.out.println("Corredor " + (i + 1) + ": " + tiempos[i] + " segundos");
        }
        if (tiempos.length >= 3) {
            System.out.println("\nMedallas:");
            System.out.println("Oro: " + tiempos[0] + " segundos");
            System.out.println("Plata: " + tiempos[1] + " segundos");
            System.out.println("Bronce: " + tiempos[2] + " segundos");
        } else {
            System.out.println("\nNo hay suficientes corredores");
        }
        
        scanner.close();
    }
}