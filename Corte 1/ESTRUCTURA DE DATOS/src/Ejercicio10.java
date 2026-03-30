/*Una app tiene un objeto int[] configuracion = {1920, 1080, 60} (resolución y FPS).

Crea una copia real del arreglo (no una referencia) usando un nuevo arreglo y copiando elemento por elemento.
Modifica la copia y demuestra que el original no cambia.
Comenta la diferencia con la asignación directa. */

public class Ejercicio10 {
    public static void main(String[] args) {
        int[] configuracion = {1920, 1080, 60};
        int[] copiaConfiguracion = new int[configuracion.length];

        for (int i = 0; i < configuracion.length; i++) {
            copiaConfiguracion[i] = configuracion[i];
        }

        copiaConfiguracion[0] = 1280;
        copiaConfiguracion[1] = 720;
        copiaConfiguracion[2] = 30;

        System.out.println("Configuración original: ");
        for (int i = 0; i < configuracion.length; i++) {
            System.out.println("Resolución: " + configuracion[i]);
        }

        System.out.println("\nCopia de configuración: ");
        for (int i = 0; i < copiaConfiguracion.length; i++) {
            System.out.println("Resolución: " + copiaConfiguracion[i]);
        }

        // La diferencia entre asignar directamente y crear una copia real es que:
        // - Asignar directamente (configuracionCopia = configuracion) crea una referencia al mismo arreglo en memoria.
        // - Crear una nueva instancia y copiar elementos crea un nuevo arreglo con los mismos valores pero en una ubicación diferente en memoria.
    }
}
