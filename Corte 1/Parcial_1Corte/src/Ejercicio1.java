import java.util.Scanner;

public class Ejercicio1 {
    public static void seleccionSort(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            double temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
    }
    public static int busqueda(double[] arr, double valor) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == valor) {
                return i;
            }
        }
        return -1;
    }
    public static double Promedio(double[] arr) {
        double suma = 0;
        for (double num : arr) {
            suma += num;
        }
        return suma / arr.length;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] temperaturas = new double[7];

        System.out.println("Ingrese 7 temperaturas:");
        for (int i = 0; i < 7; i++) {
            System.out.print("Temperatura : ");
            temperaturas[i] = sc.nextDouble();
        }
        seleccionSort(temperaturas);
        System.out.println("\nTemperaturas ordenadas de mayor a menor:");
        for (double t : temperaturas) {
            System.out.print(t + " ");
        }

        System.out.print("\nIngrese la temperatura que busca: ");
        double buscar = sc.nextDouble();
        int posicion = busqueda(temperaturas, buscar);
        if (posicion != -1) {
            System.out.println("La temperatura se encuentra en la posicion: " + posicion);
        } else {
            System.out.println("Temperatura no encontrada.");
        }
        double promedio = Promedio(temperaturas);
        System.out.println("Promedio de temperaturas: " + promedio);

        sc.close();
    }
} 

