/*4. Control de Acceso (Gimnasio)
Un gimnasio tiene una lista de códigos de acceso de los socios que pagaron la mensualidad. La lista está ordenada de menor a mayor.

El Problema: Cuando un socio digita su código, el sistema debe validar si el código está en la lista de "pagos al día". Si no está, se le niega la entrada.
Algoritmo a usar: Búsqueda Binaria. Es eficiente para buscar códigos numéricos en una lista que ya está organizada. */

import java.util.Scanner;
public class Ejercicio4 {   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] codigosAcceso = {1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 1010};
        System.out.print("Ingrese su codigo de acceso: ");
        int codigoIngresado = scanner.nextInt();

        boolean accesoPermitido = busquedaBinaria(codigosAcceso, codigoIngresado);
        if (accesoPermitido) {
            System.out.println("Acceso permitido");
        } else {
            System.out.println("Acceso denegado");
        }
        scanner.close();
    }
    public static boolean busquedaBinaria(int[] arr, int objetivo) {
        int izquierda = 0;
        int derecha = arr.length - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            if (arr[medio] == objetivo) {
                return true; 
            } else if (arr[medio] < objetivo) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1; 
            }
        }
        return false; 
    }
}
