public class App {
    public static void main(String[] args) {
        Tren tren = new Tren();

        tren.agregarVagon("Carbón", 20.5, "Colombia", "México");
        tren.agregarVagon("Acero", 35.0, "Brasil", "Argentina");
        tren.agregarVagon("Granos", 15.3, "Perú", "Chile");

        double total = tren.calcularPesoTotal();

        System.out.println("Peso total del tren: " + total + " toneladas");
    }
}