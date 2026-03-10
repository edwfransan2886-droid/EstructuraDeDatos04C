/*4. Registro Alfabético de Estudiantes
Algoritmo obligatorio: Ordenamiento por Inserción (Insertion Sort)

Contexto: El profesor necesita pasar asistencia y requiere que la lista de nombres ingresada en el sistema se ordene alfabéticamente de la A a la Z.
Detalle del ejercicio: El programa debe preguntar cuántos alumnos hay en clase y solicitar sus nombres (cadenas de texto).
Lógica de Texto: Se debe usar el método de Inserción adaptado para String.
Requisito técnico: El estudiante debe investigar y aplicar el método nombre1.compareToIgnoreCase(nombre2). Es vital explicar que si el resultado es mayor a 0, el primer nombre es alfabéticamente "mayor" que el segundo.
Resultado esperado: La lista de asistencia impresa en orden alfabético perfecto. */

import java.util.Scanner;
public class Ejercicio_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de alumnos: ");
        int cantidadAlumnos = scanner.nextInt();
        scanner.nextLine(); 
        String[] nombres = new String[cantidadAlumnos];
        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.print("Ingrese el nombre del alumno " + (i + 1) + ": ");
            nombres[i] = scanner.nextLine();
        }
        insertionSort(nombres);
        System.out.println("Lista de asistencia ordenada:");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }
        scanner.close();
    }
    public static void insertionSort(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            String key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].compareToIgnoreCase(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
