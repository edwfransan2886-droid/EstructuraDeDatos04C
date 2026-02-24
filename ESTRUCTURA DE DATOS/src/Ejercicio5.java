/*Ejercicio 5 — Conversor de unidades
Una aplicación de cocina necesita convertir unidades:

Declara una variable tazas (double) con la cantidad de tazas de un ingrediente.
Convierte a mililitros (1 taza = 236.588 ml) y guarda el resultado en otra variable.
Convierte también a litros.
Muestra las tres medidas por consola.*/

import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        double tazas;
        double mililitros;
        double litros;

        System.out.println("Digite la cantidad en tazas:");
        tazas = entrada.nextDouble();

        mililitros = tazas * 236.588;
        litros = mililitros / 1000;

        System.out.println(" ");
        System.out.println("Cantidad en tazas: " + tazas);
        System.out.println("Equivalente en mililitros: " + mililitros);
        System.out.println("Equivalente en litros: " + litros);

        entrada.close();
    }
}
