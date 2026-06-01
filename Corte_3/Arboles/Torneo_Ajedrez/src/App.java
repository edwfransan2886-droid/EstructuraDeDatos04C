/*4. Torneo de Ajedrez (Sistema de Rankings ELO)
Una plataforma de ajedrez en línea gestiona el ranking ELO de sus jugadores en un BST. A medida que los jugadores completan partidas, su ELO se actualiza y se reinsertan en el árbol. El director del torneo necesita obtener la lista de jugadores que clasifican a la siguiente ronda, es decir, todos aquellos cuyo ELO se encuentre dentro de un rango específico.

La Clase Jugador (Nodo): Debe contener elo (int, clave del BST), nombreUsuario (String), pais (String) y partidasJugadas (int).
El Problema: Para la ronda de clasificación, el director fija un rango mínimo y máximo de ELO (por ejemplo, entre 1800 y 2200). Todos los jugadores en ese rango deben ser listados de menor a mayor ELO para armar los emparejamientos.
Reto: Implementa el método listarEnRango(int eloMin, int eloMax) que recorra el árbol e imprima los datos de todos los jugadores cuyo elo esté dentro del rango [eloMin, eloMax] en orden ascendente. Usa la propiedad del BST para podar: si el nodo actual es menor que eloMin, solo explora el subárbol derecho; si es mayor que eloMax, solo explora el izquierdo. */

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        ArbolJugadores arbol = new ArbolJugadores();
        Scanner scanner = new Scanner(System.in);

        // Datos de prueba
        arbol.insertar(1700, "DragonChess", "Colombia", 120);
        arbol.insertar(2100, "KingMaster", "Argentina", 340);
        arbol.insertar(1850, "PawnHunter", "Mexico", 220);
        arbol.insertar(2300, "QueenAttack", "Brasil", 500);
        arbol.insertar(1950, "KnightForce", "Chile", 275);
        arbol.insertar(1600, "RookPower", "Peru", 90);

        int opcion;

        do {

            System.out.println("\n--- TORNEO DE AJEDREZ  ---");
            System.out.println("1. Ver ranking completo");
            System.out.println("2. Registrar jugador");
            System.out.println("3. Buscar jugador por ELO");
            System.out.println("4. Listar jugadores en rango");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    arbol.inOrden();

                    break;

                case 2:

                    System.out.print("ELO: ");
                    int elo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nombre de usuario: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Pais: ");
                    String pais = scanner.nextLine();

                    System.out.print("Partidas jugadas: ");
                    int partidas = scanner.nextInt();
                    scanner.nextLine();

                    arbol.insertar(elo, nombre, pais, partidas);

                    System.out.println("Jugador registrado");

                    break;

                case 3:

                    System.out.print("ELO a buscar: ");
                    int eloBuscar = scanner.nextInt();
                    scanner.nextLine();

                    Jugador encontrado = arbol.buscar(eloBuscar);

                    if (encontrado != null)
                        System.out.println("Jugador encontrado: " + encontrado);
                    else
                        System.out.println("Jugador no encontrado");

                    break;

                case 4:

                    System.out.print("ELO minimo: ");
                    int minimo = scanner.nextInt();

                    System.out.print("ELO maximo: ");
                    int maximo = scanner.nextInt();
                    scanner.nextLine();

                    arbol.listarEnRango(minimo, maximo);

                    break;

                case 5:

                    System.out.println("Saliendo");
                    break;

                default:

                    System.out.println("Opcion no valida");
            }

        } while (opcion != 5);

        scanner.close();
    }
}
