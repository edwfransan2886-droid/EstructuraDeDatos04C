/*Ejercicio 9 — String inmutable
Pide al usuario su nombre. Asigna alias = nombre. Pide un nuevo alias. Muestra que nombre no cambió y explica la inmutabilidad de String con un mensaje en consola.

Datos de entrada: String nombre, String nuevo alias */

import java.util.Scanner;
public class Ejercicio_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        String alias = nombre;

        System.out.print("Ingrese un nuevo alias: ");
        alias = scanner.nextLine();

        System.out.println("\nnombre = " + nombre + "   no cambió, String es inmutable");
        System.out.println("alias  = " + alias + "   esta sí cambió");

        System.out.println("\nLos objetos String en Java son inmutables, lo que significa que una vez creado un String, su valor no puede ser cambiado. Cuando asignamos un nuevo valor a 'alias', en realidad estamos creando un nuevo objeto String en memoria, mientras que 'nombre' sigue apuntando al String original.");

        scanner.close();
    }
}