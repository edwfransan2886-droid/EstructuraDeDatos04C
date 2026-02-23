import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        String placa;
        int anio;
        int cilindraje;
        double precio;
        char inicialColor;
        boolean soatVigente;

        System.out.println("Digite la placa del vehiculo:");
        placa = entrada.nextLine();

        System.out.println("Digite el año de fabricacion:");
        anio = entrada.nextInt();

        System.out.println("Digite el cilindraje en cc:");
        cilindraje = entrada.nextInt();

        System.out.println("Digite el precio de compra:");
        precio = entrada.nextDouble();

        System.out.println("Digite la inicial del color:");
        inicialColor = entrada.next().charAt(0);

        System.out.println("Tiene SOAT vigente? (true/false):");
        soatVigente = entrada.nextBoolean();

        System.out.println(" ");
        System.out.println("Datos del vehiculo:");
        System.out.println("Placa: " + placa);
        System.out.println("Año: " + anio);
        System.out.println("Cilindraje: " + cilindraje + " cc");
        System.out.println("Precio: " + precio);
        System.out.println("Inicial del color: " + inicialColor);
        System.out.println("SOAT vigente: " + soatVigente);

        entrada.close();
    }
}
