import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        double temperatura;
        String nombreSensor;
        int numeroLectura;
        boolean enAlarma;

        System.out.println("Digite el nombre del sensor:");
        nombreSensor = entrada.nextLine();

        System.out.println("Digite la temperatura actual en Celsius:");
        temperatura = entrada.nextDouble();

        System.out.println("Digite el numero de lectura:");
        numeroLectura = entrada.nextInt();

        if (temperatura > 80) {
            enAlarma = true;
        } else {
            enAlarma = false;
        }

        System.out.println(" ");
        System.out.println("Estado del sensor:");
        System.out.println("Nombre: " + nombreSensor);
        System.out.println("Temperatura: " + temperatura + " °C");
        System.out.println("Numero de lectura: " + numeroLectura);
        System.out.println("En alarma: " + enAlarma);

        entrada.close();
    }
}