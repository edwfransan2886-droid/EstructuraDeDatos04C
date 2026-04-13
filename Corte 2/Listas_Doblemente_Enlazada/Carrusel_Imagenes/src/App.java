/* 1. Sistema de Control de Versiones (Undo/Redo)
Diseña un editor de texto muy simple que guarde el historial de cambios.

La Clase Cambio (Nodo): Debe contener texto (String) y tipoOperacion (String - ej: "Escribir", "Borrar").
El Problema: Cada vez que el usuario escribe algo, se agrega un nodo al final. El usuario puede deshacer 
(retroceder al nodo anterior) y rehacer (avanzar al nodo siguiente).
Reto: Implementa métodos deshacer() y rehacer() que muevan un puntero actual a través de la lista doble. */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcion;

        Galeria galeria = new Galeria();
        Fotografia fotoActual = null;

        do {
            System.out.println("\n==============================================");
            System.out.println("             Galeria de imagenes               ");
            System.out.println("==============================================");
            System.out.println("  1- Agregar Foto");
            System.out.println("  2- Siguiente Foto");
            System.out.println("  3- Foto Anterior");
            System.out.println("  4- Reproducir Galeria");
            System.out.println();
            System.out.println("  0- Salir");
            System.out.println();
            System.out.print("Elige una opcion: ");

            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                case 1:
                    sc.nextLine();
                    System.out.print("Ingrese nombre del archivo: ");
                    String nombre = sc.nextLine();

                    System.out.print("Ingrese tamaño: ");
                    double tamano = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Ingrese resolucion: ");
                    String resolucion = sc.nextLine();

                    Fotografia nueva = new Fotografia(nombre, tamano, resolucion);
                    galeria.agregarFoto(nueva);
                    fotoActual = nueva;
                    break;

                case 2:
                    if (fotoActual != null) {
                        System.out.println("Foto actual: " + fotoActual.nombreArchivo);
                        fotoActual = galeria.siguiente(fotoActual);
                        System.out.println("Ahora estas en: " + fotoActual.nombreArchivo);
                    } else {
                        System.out.println("No hay fotos.");
                    }
                    break;

                case 3:
                    if (fotoActual != null) {
                        System.out.println("Foto actual: " + fotoActual.nombreArchivo);
                        fotoActual = galeria.anterior(fotoActual);
                        System.out.println("Ahora estas en: " + fotoActual.nombreArchivo);
                    } else {
                        System.out.println("No hay fotos.");
                    }
                    break;

                case 4:
                    galeria.reproducirGaleria();
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