/*Ejercicio 2: Competencia de Atletismo (Inserción)
Objetivo: Ingresar puntajes y organizarlos de mayor a menor para determinar el podio.
¿Qué debes hacer?
1. Entrada: Pide al usuario que ingrese 6 puntajes (números enteros) por teclado.
2. Ordenamiento: Usa Inserción (Insertion Sort) para ordenar los puntajes de mayor a menor.
3. Búsqueda: Pide un puntaje al usuario y búscalo usando Búsqueda Lineal. Indica en qué posición (lugar) de la
tabla quedó.
Ejemplo de lo que se debe ver en consola:
--- INGRESO DE PUNTAJES ---
Puntaje del Intento 1: 85
Puntaje del Intento 2: 98
Puntaje del Intento 3: 70
... (hasta llegar a 6) ...
--- TABLA DE RESULTADOS (De mayor a menor) ---
1° Lugar: 98
2° Lugar: 85
3° Lugar: 70
...
El promedio total de los puntajes fue: 84.3
--- BÚSQUEDA LINEAL ---
Ingrese puntaje a buscar: 85
>> El puntaje 85 se encuentra en el 2° lugar de la tabla.
 */

import java.util.Scanner;

public class ejercicio2_repaso {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] puntajes = new int[6];
        int suma = 0;

        System.out.println("--- INGRESO DE PUNTAJES ---");
        for (int i = 0; i < puntajes.length; i++) {
            System.out.print("Puntaje del Intento " + (i + 1) + ": ");
            puntajes[i] = scanner.nextInt();
            suma += puntajes[i];
        }

        // Ordenamiento por Inserción de mayor a menor
        for (int i = 1; i < puntajes.length; i++) {
            int key = puntajes[i];
            int j = i - 1;
            while (j >= 0 && puntajes[j] < key) {
                puntajes[j + 1] = puntajes[j];
                j--;
            }
            puntajes[j + 1] = key;
        }

        System.out.println("\n--- TABLA DE RESULTADOS ---");
        for (int i = 0; i < puntajes.length; i++) {
            System.out.println((i + 1) + " Lugar: " + puntajes[i]);
        }

        double promedio = (double) suma / puntajes.length;
        System.out.println("\nEl promedio total de los puntajes fue: " + promedio);

        System.out.println("\n--- BUSQUEDA LINEAL ---");
        System.out.print("Ingrese puntaje a buscar: ");
        int busqueda = scanner.nextInt();
        boolean encontrado = false;

        for (int i = 0; i < puntajes.length; i++) {
            if (puntajes[i] == busqueda) {
                System.out.println(" El puntaje " + busqueda + " se encuentra en el " + (i + 1) + "° lugar de la tabla.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println(">> El puntaje " + busqueda + " no se encuentra en la tabla.");
        }

        scanner.close();
    }
}
/*Ahora haz un libro con coidgo (int),titulo (string) y paginas (int); pide datos de 5 libros y guardalos en libro[];
usa inserccion(insertion stort) para ordenar por codigo (ascendente); pide un codigo y buscalo con busqueda binaria,muestra su titulo;
indica el libro con menos paginas */

/*import java.util.Scanner;

class Libro {
    int codigo;
    String titulo;
    int paginas;

    public Libro(int codigo, String titulo, int paginas) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.paginas = paginas;
    }
}

public class Libreria {

    // Ordenamiento por inserción (por código ascendente)
    public static void insertionSort(Libro[] libros) {
        for (int i = 1; i < libros.length; i++) {
            Libro actual = libros[i];
            int j = i - 1;

            while (j >= 0 && libros[j].codigo > actual.codigo) {
                libros[j + 1] = libros[j];
                j--;
            }

            libros[j + 1] = actual;
        }
    }

    // Búsqueda binaria por código
    public static int busquedaBinaria(Libro[] libros, int codigo) {
        int inicio = 0;
        int fin = libros.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;

            if (libros[medio].codigo == codigo) {
                return medio;
            } else if (libros[medio].codigo < codigo) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;
    }

    // Libro con menos páginas
    public static Libro libroMenosPaginas(Libro[] libros) {
        Libro menor = libros[0];

        for (int i = 1; i < libros.length; i++) {
            if (libros[i].paginas < menor.paginas) {
                menor = libros[i];
            }
        }
        return menor;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Libro[] libros = new Libro[5];

        // Pedir datos
        for (int i = 0; i < 5; i++) {
            System.out.println("Libro " + (i + 1));

            System.out.print("Codigo: ");
            int codigo = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            System.out.print("Titulo: ");
            String titulo = sc.nextLine();

            System.out.print("Paginas: ");
            int paginas = sc.nextInt();

            libros[i] = new Libro(codigo, titulo, paginas);
        }

        // Ordenar por código
        insertionSort(libros);

        // Mostrar ordenados
        System.out.println("\nLibros ordenados por codigo:");
        for (Libro l : libros) {
            System.out.println(l.codigo + " - " + l.titulo + " - " + l.paginas + " paginas");
        }

        // Buscar libro
        System.out.print("\nIngrese codigo a buscar: ");
        int codigoBuscar = sc.nextInt();

        int pos = busquedaBinaria(libros, codigoBuscar);

        if (pos != -1) {
            System.out.println("Libro encontrado: " + libros[pos].titulo);
        } else {
            System.out.println("Libro no encontrado.");
        }

        // Libro con menos páginas
        Libro menor = libroMenosPaginas(libros);
        System.out.println("\nLibro con menos paginas:");
        System.out.println(menor.titulo + " (" + menor.paginas + " paginas)");

        sc.close();
    }
} */