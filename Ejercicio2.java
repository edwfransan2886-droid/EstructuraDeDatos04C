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
