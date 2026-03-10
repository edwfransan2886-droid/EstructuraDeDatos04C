/*3. El Salto de Shell (Optimización de Datos)
Algoritmo obligatorio: Ordenamiento Shell (Shell Sort)

Contexto: Una empresa de logística maneja paquetes con diferentes pesos y necesita ordenarlos de forma más eficiente que el método de burbuja o inserción simple.
Detalle del ejercicio: Solicita al usuario el peso de N paquetes (se recomienda probar con al menos 10 para notar el efecto).
Lógica de Shell: Implementa el algoritmo usando el salto (gap) inicial de 
N
/
2
. El estudiante debe explicar en comentarios por qué este método es generalmente más rápido que la inserción simple al trabajar con elementos que están muy lejos de su posición final.
Resultado esperado: Mostrar el arreglo original y el arreglo final ordenado después de aplicar todas las fases de reducción de saltos. */

import java.util.Scanner;
public class Ejercicio_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de paquetes: ");
        int cantidadPaquetes = scanner.nextInt();
        double[] pesos = new double[cantidadPaquetes];

        for (int i = 0; i < cantidadPaquetes; i++) {
            System.out.print("Ingrese el peso del paquete " + (i + 1) + ": ");
            pesos[i] = scanner.nextDouble();
        }
        System.out.println("Pesos originales:");
        for (double peso : pesos) {
            System.out.print(peso + " ");
        }
        System.out.println();
        shellSort(pesos);
        System.out.println("Pesos ordenados:");
        for (double peso : pesos) {
            System.out.print(peso + " ");
        }
        scanner.close();
    }
    public static void shellSort(double[] arr) {
        int n = arr.length;
        for (int salto = n / 2; salto > 0; salto /= 2) {
            for (int i = salto; i < n; i++) {
                double temp = arr[i];
                int j;
                for (j = i; j >= salto && arr[j - salto] > temp; j -= salto) {
                    arr[j] = arr[j - salto];
                }
                arr[j] = temp;
            }
            System.out.print("Despues del salto " + salto + ": ");
            for (double num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
