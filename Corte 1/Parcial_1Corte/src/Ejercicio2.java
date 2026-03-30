import java.util.Scanner;
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
public class Ejercicio2 {
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
    public static int busqueda(Libro[] libros, int codigo) {
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
    public static Libro MenosPaginas(Libro[] libros) {
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
        for (int i = 0; i < 5; i++) {
            System.out.println("Libro " + (i + 1));

            System.out.print("Codigo: ");
            int codigo = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Titulo: ");
            String titulo = sc.nextLine();

            System.out.print("Paginas: ");
            int paginas = sc.nextInt();

            libros[i] = new Libro(codigo, titulo, paginas);
        }

        insertionSort(libros);
        System.out.println("\nLibros ordenados por codigo:");
        for (Libro l : libros) {
            System.out.println(l.codigo + " - " + l.titulo + " - " + l.paginas + " paginas");
        }
        System.out.print("\nIngrese codigo que busca: ");
        int codigoBuscar = sc.nextInt();

        int pos = busqueda(libros, codigoBuscar);
        if (pos != -1) {
            System.out.println("Libro encontrado: " + libros[pos].titulo);
        } else {
            System.out.println("Libro no encontrado.");
        }
        Libro menor = MenosPaginas(libros);
        System.out.println("\nLibro con menos paginas:");
        System.out.println(menor.titulo + " " + menor.paginas + " paginas");
        sc.close();
    }
} 
    

