/* 3. Sensor de Temperatura (Control de Calidad)
Una máquina industrial registra la temperatura cada 10 minutos y guarda los datos en un arreglo.

El Problema: Al final del día, el supervisor quiere saber cuál fue la temperatura más alta registrada para asegurarse de que la máquina no se recalentó.
Algoritmo a usar: Búsqueda Lineal de Máximo. Debes recorrer todo el arreglo comparando cada valor para encontrar el mayor de todos.*/

public class Ejercicio3 {
    public static void main(String[] args) {

        double[] temperaturas = {
            65.5, 70.2, 68.9, 72.3, 75.0,
            74.6, 69.8, 71.4, 73.2, 76.5,
            78.1, 77.3, 74.0, 72.8, 70.5
        };

        double temperaturaMaxima = temperaturas[0];
        for (int i = 1; i < temperaturas.length; i++) {
            if (temperaturas[i] > temperaturaMaxima) {
                temperaturaMaxima = temperaturas[i];
            }
        }
        System.out.println("La temperatura mas alta registrada fue: " + temperaturaMaxima + " °C");
    }
}
