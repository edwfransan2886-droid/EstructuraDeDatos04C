import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Código: ");
        int codigo = sc.nextInt();

        System.out.print("Semestre: ");
        int semestre = sc.nextInt();

        System.out.print("Promedio: ");
        double promedio = sc.nextDouble();

        System.out.print("Matriculado (true/false): ");
        boolean matriculado = sc.nextBoolean();

        System.out.println("\n=== Ficha del Estudiante ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Código: " + codigo);
        System.out.println("Semestre: " + semestre);
        System.out.println("Promedio: " + promedio);
        System.out.println("Matriculado: " + matriculado);

        sc.close();
    }
}
