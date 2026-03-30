public class MainTorre {
    public static void main(String[] args) {

        TorreControl torre = new TorreControl();

        torre.agregarVuelo("AV101", "Avianca", 50, 180);
        torre.agregarVuelo("LA202", "Latam", 30, 150);
        torre.agregarVuelo("IB303", "Iberia", 8, 200); // prioridad automática
        torre.agregarVuelo("AA404", "American Airlines", 25, 170);

        System.out.println("=== COLA ORIGINAL ===");
        torre.mostrarCola();

        System.out.println("\n=== EMERGENCIA ===");
        torre.reportarEmergencia("LA202");

        System.out.println("\n=== COLA ACTUALIZADA ===");
        torre.mostrarCola();
    }
}