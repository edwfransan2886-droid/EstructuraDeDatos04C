public class run {
    public static void main(String[] args) {

        inventario inventario = new inventario();

        inventario.agregarProducto("Leche", 10, 2);   
        inventario.agregarProducto("Queso", 5, 7);    
        inventario.agregarProducto("Yogurt", 8, 1);   
        inventario.agregarProducto("Mantequilla", 4, 6); 
        inventario.agregarProducto("Crema", 6, 3);    

        System.out.println("=== INVENTARIO COMPLETO ===");
        inventario.mostrarInventario();

        System.out.println("\n=== FILTRADO ===");
        inventario.mostrarProductosPorVencer();
    }
}