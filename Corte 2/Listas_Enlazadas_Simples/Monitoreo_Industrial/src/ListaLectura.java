class ListaLecturas {
    private Lectura cabeza;

    public void insertarAlInicio(int idSensor, double temperatura, double presion, String hora) {
        Lectura nueva = new Lectura(idSensor, temperatura, presion, hora);
        nueva.siguiente = cabeza;
        cabeza = nueva;
    }
    public void mostrarTemperaturaMaxima() {
        if (cabeza == null) {
            System.out.println("No hay lecturas registradas.");
            return;
        }

        Lectura actual = cabeza;
        Lectura max = cabeza;

        while (actual != null) {
            if (actual.temperatura > max.temperatura) {
                max = actual;
            }
            actual = actual.siguiente;
        }
        System.out.println("\n--- Lectura con mayor temperatura ---");
        System.out.println("ID Sensor: " + max.idSensor);
        System.out.println("Temperatura: " + max.temperatura);
        System.out.println("Presion: " + max.presion);
        System.out.println("Hora: " + max.hora);
    }
}