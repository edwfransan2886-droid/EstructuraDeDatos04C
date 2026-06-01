/*5. Control de Inventario (Almacén de Repuestos)
Un taller mecánico almacena los repuestos de su inventario en un BST organizado por código de referencia (un número entero único). Cuando un repuesto se agota, su nodo queda como hoja (no tiene hijos) porque no ha sido reemplazado por variantes. El administrador quiere saber cuántos repuestos son "únicos" (sin variantes relacionadas) y cuál es el recorrido completo del inventario en PreOrden para realizar una copia de seguridad del árbol.

La Clase Repuesto (Nodo): Debe contener codigoRef (int, clave del BST), descripcion (String), marca (String) y stock (int).
El Problema: El administrador necesita dos reportes: el primero lista todos los repuestos en PreOrden (para poder reconstruir el árbol en otro sistema con el mismo orden de inserción), y el segundo informa cuántos repuestos son hojas del árbol (sin variantes relacionadas).
Reto: Implementa backupPreOrden() que imprima todos los repuestos en recorrido PreOrden con el formato [codigoRef] descripcion - marca (stock uds). Implementa también reporteRepuestosUnicos() que use contarHojas() e imprima un mensaje indicando cuántos repuestos no tienen variantes relacionadas en el catálogo. */

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        ArbolRepuestos arbol = new ArbolRepuestos();
        Scanner scanner = new Scanner(System.in);

        // Datos de prueba
        arbol.insertar(500, "Filtro de aceite", "Bosch", 20);
        arbol.insertar(300, "Pastillas de freno", "Brembo", 15);
        arbol.insertar(700, "Bujia", "NGK", 40);
        arbol.insertar(200, "Correa", "Gates", 10);
        arbol.insertar(400, "Amortiguador", "Monroe", 8);
        arbol.insertar(600, "Radiador", "Valeo", 6);
        arbol.insertar(800, "Alternador", "Denso", 5);

        int opcion;

        do {

            System.out.println("\n--- CONTROL DE INVENTARIO (BST) ---");
            System.out.println("1. Ver backup PreOrden");
            System.out.println("2. Registrar repuesto");
            System.out.println("3. Buscar repuesto");
            System.out.println("4. Reporte de repuestos unicos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    arbol.backupPreOrden();

                    break;

                case 2:

                    System.out.print("Codigo: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Descripcion: ");
                    String descripcion = scanner.nextLine();

                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();

                    System.out.print("Stock: ");
                    int stock = scanner.nextInt();
                    scanner.nextLine();

                    arbol.insertar(codigo,descripcion,marca,stock);
                    System.out.println("Repuesto registrado");

                    break;

                case 3:

                    System.out.print("Codigo a buscar: ");
                    int codigoBuscar = scanner.nextInt();
                    scanner.nextLine();

                    Repuesto encontrado = arbol.buscar(codigoBuscar);

                    if (encontrado != null)
                        System.out.println("Repuesto encontrado: " + encontrado);
                    else
                        System.out.println("Repuesto no encontrado");

                    break;

                case 4:

                    arbol.reporteRepuestosUnicos();

                    break;

                case 5:

                    System.out.println("Saliendo");
                    break;

                default:

                    System.out.println("Opcion no valida");
            }

        } while (opcion != 5);

        scanner.close();
    }
}

