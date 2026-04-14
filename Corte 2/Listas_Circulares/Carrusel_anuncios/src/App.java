/*2. Carrusel de Anuncios (Pantalla Digital)
Una tienda tiene una pantalla que muestra anuncios en rotación continua. Cuando termina el último anuncio, vuelve automáticamente al primero.

La Clase Anuncio (Nodo): Debe contener titulo (String), duracionSegundos (int), vecesRepetido (int) y categoria (String - ej: "Oferta", "Marca", "Evento").
El Problema: La pantalla necesita saber cuánto tiempo total lleva encendida y cuál es el anuncio que más veces se ha repetido.
Reto: Implementa el método reproducir(int ciclos) que simule ciclos pasadas completas por todos los anuncios, incrementando vecesRepetido en cada paso e imprimiendo qué anuncio está en pantalla. Al finalizar, muestra el anuncio más repetido y el tiempo total acumulado en pantalla. */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcion;

        Pantalla pantalla = new Pantalla();

        do {
            System.out.println("\n==============================================");
            System.out.println("   Carrusel de Anuncios");
            System.out.println("==============================================");
            System.out.println("1- agregarAnuncio");
            System.out.println("2- mostrarAnuncios");
            System.out.println("3- reproducir");
            System.out.println("0- Salir");
            System.out.println();
            System.out.print("Elige una opcion: ");

            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese titulo: ");
                    String titulo = sc.next();

                    System.out.print("Ingrese duracion en segundos: ");
                    int duracion = sc.nextInt();

                    System.out.print("Ingrese categoria: ");
                    String categoria = sc.next();

                    Anuncio nuevo = new Anuncio(titulo, duracion, categoria);
                    pantalla.agregarAnuncio(nuevo);
                    break;

                case 2:
                    pantalla.mostrarAnuncios();
                    break;

                case 3:
                    System.out.print("Ingrese cantidad de ciclos: ");
                    int ciclos = sc.nextInt();
                    pantalla.reproducir(ciclos);
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