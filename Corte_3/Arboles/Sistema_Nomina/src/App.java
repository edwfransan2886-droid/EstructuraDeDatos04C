/*3. Sistema de Nómina (Recursos Humanos)
Una empresa de logística administra a sus empleados en un BST organizado por número de cédula. El área de RRHH consulta frecuentemente el empleado con el menor y el mayor número de cédula para procesar los extremos de la nómina. También necesita conocer la altura del árbol para auditar si la estructura sigue siendo eficiente después de muchas incorporaciones.

La Clase Empleado (Nodo): Debe contener cedula (long, clave del BST), nombreCompleto (String), cargo (String) y salario (double).
El Problema: El sistema debe poder ubicar al empleado con la cédula más baja (el más antiguo en el registro) y al de cédula más alta (el más reciente), y también reportar la altura actual del árbol para verificar que las búsquedas siguen siendo eficientes.
Reto: Implementa buscarMinimo() y buscarMaximo(), que recorran el BST siguiendo siempre el subárbol izquierdo o derecho respectivamente hasta llegar a una hoja e impriman los datos del empleado encontrado. Implementa también reporteEficiencia() que imprima la altura actual del árbol y el número total de hojas (contarHojas()). */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        ArbolEmpleados arbol = new ArbolEmpleados();
        Scanner scanner = new Scanner(System.in);

        // Datos de prueba
        arbol.insertar(1001, "Juan Perez", "Gerente", 5500000);
        arbol.insertar(1005, "Maria Gomez", "Analista", 3200000);
        arbol.insertar(998, "Carlos Ruiz", "Supervisor", 4000000);
        arbol.insertar(1010, "Ana Torres", "Auxiliar", 2200000);
        arbol.insertar(995, "Luis Fernandez", "Coordinador", 4500000);
        arbol.insertar(1020, "Sofia Martinez", "Operador", 2100000);

        int opcion;

        do {
            System.out.println("\n--- SISTEMA DE NOMINA ---");
            System.out.println("1. Ver empleados ordenados por cedula");
            System.out.println("2. Insertar empleado");
            System.out.println("3. Buscar empleado por cedula");
            System.out.println("4. Buscar empleado con menor cedula");
            System.out.println("5. Buscar empleado con mayor cedula");
            System.out.println("6. Reporte de eficiencia");
            System.out.println("7. Salir");
            System.out.println();
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    arbol.inOrden();
                    break;

                case 2:

                    System.out.print("Cedula: ");
                    long cedula = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Nombre completo: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Cargo: ");
                    String cargo = scanner.nextLine();

                    System.out.print("Salario: ");
                    double salario = scanner.nextDouble();
                    scanner.nextLine();

                    arbol.insertar(cedula, nombre, cargo, salario);

                    System.out.println("Empleado registrado correctamente");

                    break;

                case 3:

                    System.out.print("Cedula a buscar: ");
                    long cedulaBuscar = scanner.nextLong();
                    scanner.nextLine();

                    Empleado encontrado = arbol.buscar(cedulaBuscar);

                    if (encontrado != null)
                        System.out.println("Empleado encontrado: " + encontrado);
                    else
                        System.out.println("Empleado no encontrado");

                    break;

                case 4:

                    arbol.buscarMinimo();

                    break;

                case 5:

                    arbol.buscarMaximo();

                    break;

                case 6:

                    arbol.reporteEficiencia();

                    break;

                case 7:

                    System.out.println("Saliendo del sistema");
                    break;

                default:

                    System.out.println("Opcion no valida");
            }

        } while (opcion != 7);
        
        scanner.close();
    }
}