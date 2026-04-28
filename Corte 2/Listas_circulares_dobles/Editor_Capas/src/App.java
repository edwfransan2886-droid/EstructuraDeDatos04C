/*3. Editor de Capas (Diseño Gráfico)
Los editores gráficos organizan el diseño en capas. El usuario navega a la capa superior (siguiente) o inferior (anterior) y puede ocultar o mostrar cada capa. La estructura es circular: después de la capa más alta vuelve a la más baja.

La Clase Capa (Nodo): Debe contener nombre (String), visible (boolean) y tipo (String — "fondo", "objeto", "texto").
El Problema: El editor mantiene un puntero capaActiva a la capa seleccionada. El usuario puede moverse entre capas, alternar la visibilidad de la activa y eliminarla (el foco pasa a la siguiente).
Reto: Implementa los métodos subirCapa(), bajarCapa(), toggleVisibilidad(), eliminarActiva() y mostrarCapas(). mostrarCapas() imprime todas las capas marcando la activa con [✓] e indicando si cada una es visible. Simula: crea 4 capas, activa la del medio, sube una vez, oculta la activa, elimínala y muestra el estado final.
 */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Editor editor = new Editor();
        int opcion;

        do {
            System.out.println("\n==============================================");
            System.out.println("   Editor de Capas");
            System.out.println("==============================================");
            System.out.println("1. Agregar capa");
            System.out.println("2. Subir capa");
            System.out.println("3. Bajar capa");
            System.out.println("4. Toggle visibilidad");
            System.out.println("5. Eliminar capa activa");
            System.out.println("6. Mostrar capas");
            System.out.println("0. Salir");
            System.out.println();
            System.out.print("Elige una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (opcion) {

                case 1:
                    System.out.print("Nombre de la capa: ");
                    String nombre = sc.nextLine();

                    System.out.print("Tipo (fondo/objeto/texto): ");
                    String tipo = sc.nextLine();

                    editor.agregarCapa(nombre, tipo);
                    System.out.println("Capa agregada");
                    break;

                case 2:
                    System.out.println("Subir capa");
                    editor.subirCapa();
                    editor.mostrarActiva();
                    break;

                case 3:
                    System.out.println("Bajar capa");
                    editor.bajarCapa();
                    editor.mostrarActiva();
                    break;

                case 4:
                    System.out.println("Cambiar visibilidad");
                    editor.toggleVisibilidad();
                    editor.mostrarActiva();
                    break;

                case 5:
                    System.out.println("Eliminar capa activa");
                    editor.eliminarActiva();
                    editor.mostrarActiva();
                    break;

                case 6:
                    editor.mostrarCapas();
                    break;

                case 0:
                    System.out.println("Salir");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 0);

        sc.close();
    }
}