/*2. Catálogo Digital (Biblioteca Universitaria)
La biblioteca de la universidad organiza su colección de libros en un BST usando el ISBN como clave única. Cada vez que ingresa un libro nuevo, se inserta automáticamente en el árbol. El sistema debe poder confirmar si un ISBN ya existe antes de registrar un nuevo ejemplar y listar toda la colección ordenada por ISBN.

La Clase Libro (Nodo): Debe contener isbn (long, clave del BST), titulo (String), autor (String) y anioPublicacion (int).
El Problema: Al final del semestre, el bibliotecario necesita imprimir el inventario completo ordenado de menor a mayor por ISBN para enviarlo a la sede central. También debe verificar si un ISBN específico ya existe en el catálogo antes de registrar una donación.
Reto: Implementa el método imprimirCatalogo() usando el recorrido InOrden para listar todos los libros en orden ascendente de ISBN (imprime isbn - titulo - autor). Además, implementa existeISBN(long isbn) que retorne true si el libro ya está registrado y false en caso contrario. */


import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        ArbolLibros catalogo = new ArbolLibros();
        Scanner scanner = new Scanner(System.in);

        catalogo.insertar(9781234, "Estructuras de Datos", "Juan Perez", 2020);
        catalogo.insertar(9785678, "Programacion Java", "Maria Gomez", 2022);
        catalogo.insertar(9781111, "Bases de Datos", "Carlos Ruiz", 2019);
        catalogo.insertar(9789999, "Algoritmos", "Ana Torres", 2021);

        int opcion;

        do {

            System.out.println("\n--- CATALOGO DIGITAL (BST) ---");
            System.out.println("1. Ver catalogo ordenado");
            System.out.println("2. Registrar libro");
            System.out.println("3. Buscar ISBN");
            System.out.println("4. Verificar si existe ISBN");
            System.out.println("5. Salir");
            System.out.println();
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    catalogo.imprimirCatalogo();
                    break;

                case 2:

                    System.out.print("ISBN: ");
                    long isbn = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Titulo: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();

                    System.out.print("Anio de publicacion: ");
                    int anio = scanner.nextInt();
                    scanner.nextLine();

                    catalogo.insertar(isbn, titulo, autor, anio);

                    System.out.println("Libro registrado correctamente");

                    break;

                case 3:

                    System.out.print("ISBN a buscar: ");
                    long isbnBuscar = scanner.nextLong();
                    scanner.nextLine();

                    Libro encontrado = catalogo.buscar(isbnBuscar);

                    if (encontrado != null)
                        System.out.println("Libro encontrado: " + encontrado);
                    else
                        System.out.println("Libro no encontrado");

                    break;

                case 4:

                    System.out.print("ISBN a verificar: ");
                    long isbnExiste = scanner.nextLong();
                    scanner.nextLine();

                    if (catalogo.existeISBN(isbnExiste))
                        System.out.println("El ISBN ya existe en el catalogo");
                    else
                        System.out.println("El ISBN no esta registrado");

                    break;

                case 5:

                    System.out.println("Saliendo del sistema");
                    break;

                default:

                    System.out.println("Opcion no valida");
            }

        } while (opcion != 5);

        scanner.close();
    }
}