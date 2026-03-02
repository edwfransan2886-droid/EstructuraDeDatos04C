/*Ejercicio 2 — Conversor de temperatura
Pide al usuario una temperatura en Celsius y conviértela a Fahrenheit y Kelvin.

Fórmulas:

F = (C × 9/5) + 32
K = C + 273.15
Dato de entrada: double temperatura en Celsius

Salida esperada:

25.0 °C = 77.0 °F = 298.15 K */


public class Ejercicio_2 {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Temperatura en Celsius: ");
        double celsius = sc.nextDouble();

        double fahrenheit = (celsius * 9/5) + 32;
        double kelvin = celsius + 273.15;

        System.out.printf("%.1f °C = %.1f °F = %.2f K\n", celsius, fahrenheit, kelvin);

        sc.close();
    } 
}

