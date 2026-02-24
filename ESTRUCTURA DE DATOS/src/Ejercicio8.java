/*Ejercicio 8 — Historial de mensajes
Un chat guarda el último mensaje enviado. Se usan dos variables String:

ultimoMensaje = "Hola"
copiaTexto = ultimoMensaje
Luego copiaTexto se cambia a "¿Cómo estás?"
Muestra ambas variables y explica en un comentario por qué ultimoMensaje no cambió (inmutabilidad de String). */
public class Ejercicio8 {
    public static void main(String[] args) {

        String ultimoMensaje = "Hola";
        String copiaTexto = ultimoMensaje;

        System.out.println("Último mensaje: " + ultimoMensaje);
        System.out.println("Copia del mensaje: " + copiaTexto);

        copiaTexto = "¿Cómo estás?";

        System.out.println(" ");
        System.out.println("Después de cambiar copiaTexto...");

        System.out.println("Último mensaje: " + ultimoMensaje);
        System.out.println("Copia del mensaje: " + copiaTexto);

        // En Java, las cadenas de texto (String) son inmutables, lo que significa que no se pueden modificar una vez creadas. 
        // Cuando se asigna ultimoMensaje a copiaTexto, ambas variables apuntan al mismo objeto String en memoria. 
        // Sin embargo, al cambiar copiaTexto a "¿Cómo estás?", se crea un nuevo objeto String y copiaTexto ahora apunta a este nuevo objeto, mientras que ultimoMensaje sigue apuntando al original "Hola". 
        // Por eso, cambiar copiaTexto no afecta a ultimoMensaje.
    }
}