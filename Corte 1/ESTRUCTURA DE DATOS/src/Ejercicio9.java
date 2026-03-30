/*Un profesor tiene las notas de 4 estudiantes en un arreglo. El coordinador recibe una referencia al mismo arreglo para revisarlas.

El coordinador corrige la nota del estudiante 2 (índice 1) de 2.5 a 3.0.
Muestra que el arreglo del profesor también refleja el cambio.
Añade comentarios explicando el concepto de referencia en memoria. */

public class Ejercicio9 {
    public static void main(String[] args) {
        double[] notasProfesor = {2.5, 2.5, 2.5, 2.5};
        double[] notasCoordinador = notasProfesor;

        System.out.println("Notas del profesor: ");
        for (int i = 0; i < notasProfesor.length; i++) {
            System.out.println("Estudiante " + (i + 1) + ": " + notasProfesor[i]);
        }

        notasCoordinador[1] = 3.0;

        System.out.println("\nDespués de la corrección...");

        System.out.println("Notas del profesor: ");
        for (int i = 0; i < notasProfesor.length; i++) {
            System.out.println("Estudiante " + (i + 1) + ": " + notasProfesor[i]);
        }

        // En Java, los arreglos son objetos y cuando asignamos notasCoordinador = notasProfesor, ambas variables apuntan al mismo arreglo en memoria. 
        // Por lo tanto, cualquier cambio realizado a través de notasCoordinador también afecta a notasProfesor, ya que ambos hacen referencia al mismo objeto. 
        // Esto es un ejemplo de comportamiento por referencia.
    }
}
