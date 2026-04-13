/*3. Navegación de Pestañas de Navegador
Imagina un navegador donde puedes moverte entre pestañas abiertas.

La Clase Pestaña (Nodo): Debe contener tituloPagina (String), url (String) y horaApertura (String).
El Problema: Las pestañas se abren una tras otra. A veces el usuario quiere cerrar la pestaña actual y el foco debe pasar a la pestaña anterior.
Reto: Implementar el método cerrarPestanaActual(String url) que busque la pestaña por URL, la elimine de la lista y reconecte el nodo anterior con el siguiente correctamente (¡Cuidado con la Cabeza y la Cola!). */
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcion;

        Navegador navegador = new Navegador();
        Pestaña actual = null;

        do {
            System.out.println("\n==============================================");
            System.out.println("        Navegador de Pestanas");
            System.out.println("==============================================");
            System.out.println("  1- Abrir Pestaña");
            System.out.println("  2- Cerrar Pestaña por URL");
            System.out.println("  3- Mostrar Pestañas");
            System.out.println();
            System.out.println("  0- Salir");
            System.out.println();
            System.out.print("Elige una opcion: ");

            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                case 1:
                    sc.nextLine();
                    System.out.print("Ingrese titulo: ");
                    String titulo = sc.nextLine();

                    System.out.print("Ingrese URL: ");
                    String url = sc.nextLine();

                    System.out.print("Ingrese hora de apertura: ");
                    String hora = sc.nextLine();

                    Pestaña nueva = new Pestaña(titulo, url, hora);
                    navegador.abrirPestaña(nueva);
                    actual = nueva;
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Ingrese URL a cerrar: ");
                    String urlCerrar = sc.nextLine();

                    actual = navegador.cerrarPestanaActual(urlCerrar, actual);
                    break;

                case 3:
                    navegador.mostrarPestañas();
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