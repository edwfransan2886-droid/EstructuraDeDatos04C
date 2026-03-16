/*¿Qué debes hacer?
1. Clase: Crea una clase Producto con: id (int), nombre (String), 
precio (double) y stock (int).
2. Entrada de Datos: Pide al usuario que ingrese los datos de 5 
productos por teclado y guárdalos en un arreglo Producto[] .
3. Ordenamiento: Usa Shell Sort para ordenar los productos de menor 
a mayor según su id .
4. Búsqueda: Pide un id al usuario y búscalo usando Búsqueda Binaria.
Ejemplo de lo que se debe ver en consola:
--- REGISTRO DE PRODUCTOS ---
Producto 1:
Ingrese ID: 105
Ingrese Nombre: Mouse
Ingrese Precio: 25.50
Ingrese Stock: 10
... (se repite hasta completar los 5 productos) ...
--- INVENTARIO ORDENADO POR ID (Shell Sort) ---
ID: 101 | Nombre: Laptop | Precio: 850.0 | Stock: 5
ID: 102 | Nombre: Teclado | Precio: 45.0 | Stock: 12
ID: 105 | Nombre: Mouse | Precio: 25.5 | Stock: 10
...
--- BÚSQUEDA DE PRODUCTO ---
Ingrese el ID a buscar: 102
>> PRODUCTO ENCONTRADO: Teclado - Precio: $45.0 - Stock: 12 */
import java.util.Scanner;

class producto {
    int id;
    String nombre;
    double precio;
    int stock;

}

public class ejercicio1_repaso {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        producto [] productos = new producto[5];

        System.out.println("--- REGISTRO DE PRODUCTOS ---");
        for (int i = 0; i < productos.length; i++) {
            productos[i] = new producto();
            System.out.println("Producto " + (i + 1));
            System.out.print("ID: ");
            productos[i].id = sc.nextInt();
            sc.nextLine();
            System.out.print("Nombre: ");
            productos[i].nombre = sc.nextLine();
            System.out.print("Precio: ");
            productos[i].precio = sc.nextDouble();
            System.out.print("Stock: ");
            productos[i].stock = sc.nextInt();
        }
        for (int gap=productos.length/2; gap>0; gap/=2) {
            for (int i=gap; i<productos.length; i++) {
                producto temp = productos[i];
                int j;
                for (j=i; j>=gap && productos[j-gap].precio > temp.precio; j-=gap) {
                    productos[j] = productos[j-gap];
                }
                productos[j] = temp;
            }
        }
        System.out.println("\n--- PRODUCTOS ORDENADOS POR ID ---");
        for (producto p : productos) {
            System.out.println("ID: " + p.id + ", Nombre: " + p.nombre +
             ", Precio: " + p.precio + ", Stock: " + p.stock);
        }
        System.out.println("\n--- BUSQUEDA DE PRODUCTO ---");
        System.out.print("Ingrese el ID del producto a buscar: ");
        int idBusqueda = sc.nextInt();
        boolean encontrado = false;
        for (producto p : productos) {
            if (p.id == idBusqueda) {
                System.out.println("Producto encontrado: ID: " + p.id + ", Nombre: " + p.nombre +
                 ", Precio: " + p.precio + ", Stock: " + p.stock);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Producto con ID " + idBusqueda + 
            " no encontrado.");
        }
    }
}