/*Ejercicio 2 — Calculadora de una tienda
Una tienda de barrio vende productos al por menor. El cajero necesita calcular:

Precio unitario de un producto (double)
Cantidad comprada (int)
Descuento aplicado en porcentaje (double)
Total a pagar después del descuento
Declara las variables, realiza el cálculo y muestra el resultado por consola.*/

import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        double precio;
        int cantidad;
        double descuento;
        double total;
        double totalFinal;

        System.out.println("Digite el precio del producto:");
        precio = entrada.nextDouble();

        System.out.println("Digite la cantidad comprada:");
        cantidad = entrada.nextInt();

        System.out.println("Digite el descuento en porcentaje:");
        descuento = entrada.nextDouble();

        total = precio * cantidad;
        totalFinal = total - (total * descuento / 100);

        System.out.println(" ");
        System.out.println("Total sin descuento: " + total);
        System.out.println("Total a pagar con descuento: " + totalFinal);
        
        entrada.close(); 
    }
}
