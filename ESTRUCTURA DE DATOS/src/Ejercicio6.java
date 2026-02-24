/*Ejercicio 6 — Turno en un banco
Un cajero de banco trabaja con el número del turno actual. Se crea una variable turnoActual y se asigna a turnoEnPantalla.

Demuestra con código que cambiar turnoEnPantalla no afecta a turnoActual (comportamiento por valor).
Explica en un comentario por qué ocurre esto. */

public class Ejercicio6 {
    public static void main(String[] args) {

        int turnoActual = 5;
        int turnoEnPantalla = turnoActual;

        System.out.println("Turno actual: " + turnoActual);
        System.out.println("Turno en pantalla: " + turnoEnPantalla);

        turnoEnPantalla = 10;

        System.out.println(" ");
        System.out.println("Después de cambiar turnoEnPantalla...");

        System.out.println("Turno actual: " + turnoActual);
        System.out.println("Turno en pantalla: " + turnoEnPantalla);

        // En Java, los tipos primitivos como int se pasan por valor, lo que significa que cuando asignamos turnoEnPantalla = turnoActual, se crea una copia del valor de turnoActual. 
        // Por lo tanto, cualquier cambio realizado a turnoEnPantalla no afecta a turnoActual, ya que son variables independientes con sus propios valores. 
        // Esto es un ejemplo de comportamiento por valor.
    }
}
