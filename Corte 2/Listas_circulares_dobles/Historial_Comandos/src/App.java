/*2. Historial de Comandos de Terminal
Los terminales guardan un historial de comandos. Al presionar flecha arriba el usuario retrocede al comando anterior; flecha abajo avanza al más reciente. El historial es circular: después del más antiguo vuelve al más nuevo.

La Clase Comando (Nodo): Debe contener texto (String), exitoso (boolean — si ejecutó sin errores) y directorio (String — el path desde donde se ejecutó).
El Problema: El historial mantiene un puntero cursor al comando que se está consultando. Navegar con "arriba" mueve el cursor al anterior (anterior); "abajo" lo mueve al siguiente (siguiente). El usuario puede eliminar el comando actual (para borrar contraseñas escritas por error), y el cursor pasa automáticamente al siguiente.
Reto: Implementa los métodos arriba(), abajo(), mostrarCursor() y eliminarActual(). Simula: agrega 5 comandos, navega 3 veces hacia arriba, elimina el comando actual, navega una vez hacia abajo y muestra el historial completo con el cursor marcado. */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Terminal terminal = new Terminal();
        int opcion;

        do {
            System.out.println("\n==============================================");
            System.out.println("               Historial de Comandos");
            System.out.println("==============================================");
            System.out.println("1. Agregar comando");
            System.out.println("2. Arriba");
            System.out.println("3. Abajo");
            System.out.println("4. Mostrar cursor");
            System.out.println("5. Eliminar actual");
            System.out.println("6. Mostrar historial");
            System.out.println("0. Salir");
            System.out.println();
            System.out.print("Elige una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese comando: ");
                    String texto = sc.nextLine();

                    System.out.print("Fue exitoso? (true/false): ");
                    boolean exitoso = sc.nextBoolean();
                    sc.nextLine();

                    System.out.print("Ingrese directorio: ");
                    String directorio = sc.nextLine();

                    terminal.agregarComando(texto, exitoso, directorio);
                    System.out.println("Comando agregado");
                    break;

                case 2:
                    System.out.println("Cursor hacia arriba");
                    terminal.arriba();
                    terminal.mostrarCursor();
                    break;

                case 3:
                    System.out.println("Cursor hacia abajo");
                    terminal.abajo();
                    terminal.mostrarCursor();
                    break;

                case 4:
                    System.out.println("Cursor actual");
                    terminal.mostrarCursor();
                    break;

                case 5:
                    System.out.println("Eliminacion de comando actual");
                    terminal.eliminarActual();
                    terminal.mostrarCursor();
                    break;

                case 6:
                    System.out.println("Historial completo:");
                    terminal.mostrarHistorial();
                    break;

                case 0:
                    System.out.println("Saliendo del programa");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 0);

        sc.close();
    }
}

/*gestiona un historial de navegacion con listas simples y debe hacer lo siguiente: 3 archivos se llaman: Pagina.java, Historial.java y app.java debes hacer un menu con switch el cual visitar pagina:agregar al final con url,titulo y visitas int; buscar por url: vusca una pagina y aumenta su contador de visitas;ver historial: listar todas las paginas y mostrar el historial de visitas del usuario ;pagina top:mostrar la pagina con el mayor numero de visitas y por ultimo la validacion que no permita urls vacias y el contador de visitas debes iniciar en 1 */