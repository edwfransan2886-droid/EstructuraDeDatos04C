public class run {
    public static void main(String[] args) {

        inventario inv = new inventario();

        inv.agregarProducto("Leche", 10, 2);
        inv.agregarProducto("Queso", 5, 7);
        inv.agregarProducto("Yogurt", 8, 1);
        inv.agregarProducto("Mantequilla", 4, 4);
        inv.agregarProducto("Crema", 6, 3);

        System.out.println("=== INVENTARIO ===");
        inv.mostrarInventario();

        System.out.println("\n=== POR VENCER ===");
        inv.mostrarProductosPorVencer();
    }
}