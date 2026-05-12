/*4. Farmacia Automatizada (Dispensador Tubo LIFO)
En una farmacia de alta tecnología, los medicamentos de alta rotación se almacenan en tubos dispensadores verticales. El personal introduce las cajas por la parte superior y las retira de la misma forma (el último lote en llegar es el primero en ser despachado).

La Clase Medicamento (Nodo): Debe contener nombre (String), lote (String) y diasParaVencer (int).
El Problema: Por norma de seguridad, no se puede despachar un medicamento si le quedan menos de 10 días para vencer.
Reto: Implementa un método validarDespacho() que revise el medicamento en el tope. Si está a punto de vencer, debe ser retirado automáticamente y el sistema debe revisar el siguiente. El proceso se repite hasta que el tope sea un medicamento seguro o la pila quede vacía. */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        PilaFarmacia dispensador = new PilaFarmacia();
        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\n==============================================");
            System.out.println("             Farmacia Automatizada");
            System.out.println("==============================================");
            System.out.println("1. Ingresar medicamento");
            System.out.println("2. Ver dispensador");
            System.out.println("3. Despachar medicamento");
            System.out.println("4. Validar despacho");
            System.out.println("0. Salir");
            System.out.println();
            System.out.print("Elige una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (opcion) {

                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Lote: ");
                    String lote = sc.nextLine();

                    System.out.print("Dias para vencer: ");
                    int dias = sc.nextInt();
                    sc.nextLine();

                    Medicamento nuevo = new Medicamento(nombre, lote, dias);
                    dispensador.push(nuevo);

                    System.out.println("Medicamento agregado");
                    break;

                case 2:
                    dispensador.imprimir();
                    break;

                case 3:
                    Medicamento retirado = dispensador.pop();

                    if (retirado != null) {
                        System.out.println("Medicamento despachado: " + retirado);
                    } else {
                        System.out.println("Dispensador vacio");
                    }
                    break;

                case 4:
                    dispensador.validarDespacho();
                    break;

                case 0:
                    System.out.println("Saliendo");
                    break;

                default:
                    System.out.println("Opcion no valida");
            }

        } while (opcion != 0);

        sc.close();
    }
}
