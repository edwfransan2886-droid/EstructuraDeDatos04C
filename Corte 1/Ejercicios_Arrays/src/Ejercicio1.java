/*1. El Cajero del Supermercado (Inventario)
Un cajero escanea un producto con el código de barras 770123. El sistema tiene un arreglo desordenado con los códigos de los productos disponibles en la estantería actual.

El Problema: Debes recorrer la lista para verificar si el producto existe y en qué posición de la estantería se encuentra.
Algoritmo a usar: Búsqueda Lineal. Es el ideal porque los productos en la estantería no tienen un orden numérico específico. */

public class Ejercicio1 {
    public static void main(String[] args) {
        int[] productos = {123456, 654321, 770123, 987654, 321654};
        int codigoBuscado = 770123;
        int posicion = busquedaLineal(productos, codigoBuscado);

        if (posicion != -1) {
            System.out.println("Producto encontrado en la posición: " + posicion);
        } else {
            System.out.println("Producto no encontrado");
        }
    }
    public static int busquedaLineal(int[] arr, int valor) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == valor) {
                return i; 
            }
        }
        return -1; 
    }
}
