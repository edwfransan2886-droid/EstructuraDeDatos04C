/*2. Buscador de Cédulas (Base de Datos Bancaria)
Un banco tiene una lista de 1.000 clientes organizados de forma estricta y ascendente por su número de cédula o ID.

El Problema: Un cliente llega a la ventanilla y da su número. El sistema debe encontrar sus datos de la manera más rápida posible (en pocos pasos).
Algoritmo a usar: Búsqueda Binaria. Como los datos ya están ordenados, este algoritmo permitirá encontrar al cliente dividiendo la lista a la mitad en cada paso. */

import java.util.Scanner;
public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] cedulas = new int[1000];
        for (int i = 0; i < cedulas.length; i++) {
            cedulas[i] = 100000 + i; 
        }

        System.out.print("Ingrese el número de cédula del cliente: ");
        int cedulaBuscada = scanner.nextInt();

        int indice = busquedaBinaria(cedulas, cedulaBuscada);
        if (indice != -1) {
            System.out.println("Cliente encontrado en el índice: " + indice);
        } else {
            System.out.println("Cliente no encontrado.");
        }

        scanner.close();
    }

    public static int busquedaBinaria(int[] arr, int objetivo) {
        int izquierda = 0;
        int derecha = arr.length - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            if (arr[medio] == objetivo) {
                return medio; 
            } else if (arr[medio] < objetivo) {
                izquierda = medio + 1; 
            } else {
                derecha = medio - 1; 
            }
        }
        return -1; 
    }
}


