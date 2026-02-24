/*Un almacén tiene un arreglo con el stock de 5 productos. El sistema de ventas y el sistema de reportes apuntan al mismo arreglo.

Crea el arreglo stockAlmacen con valores iniciales.
Asigna stockReportes = stockAlmacen.
Simula una venta reduciendo el stock de un producto desde stockReportes.
Muestra que stockAlmacen también cambió y explica en comentarios por qué. */

public class Ejercicio7 {

    public static void main(String[] args) {

        int[] stockAlmacen = {10, 20, 30, 40, 50};
        int[] stockReportes = stockAlmacen;

        System.out.println("Stock en el almacén: ");
        for (int i = 0; i < stockAlmacen.length; i++) {
            System.out.println("Producto " + (i + 1) + ": " + stockAlmacen[i]);
        }

        stockReportes[1] -= 5; 

        System.out.println("\nDespués de la venta...");

        System.out.println("Stock en el almacén: ");
        for (int i = 0; i < stockAlmacen.length; i++) {
            System.out.println("Producto " + (i + 1) + ": " + stockAlmacen[i]);
        }

        // En Java, los arreglos son objetos y cuando asignamos stockReportes = stockAlmacen, ambas variables apuntan al mismo arreglo en memoria. 
        // Por lo tanto, cualquier cambio realizado a través de stockReportes también afecta a stockAlmacen, ya que ambos hacen referencia al mismo objeto. 
        // Esto es un ejemplo de comportamiento por referencia.
    }
}
