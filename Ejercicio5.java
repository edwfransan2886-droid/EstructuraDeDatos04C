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
