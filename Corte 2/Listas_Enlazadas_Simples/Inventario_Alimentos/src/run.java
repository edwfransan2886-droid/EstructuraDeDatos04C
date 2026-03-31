import java.util.Scanner;

public class run {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventario inventario = new Inventario();
        int opcion;
        do {
            System.out.println("\n--- INVENTARIO DE LÁCTEOS ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Mostrar productos próximos a vencer (<5 días)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); 
            switch (opcion) {
                case 1:
                    System.out.print("Nombre del producto: ");
                    String nombre = sc.nextLine();
                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();
                    System.out.print("Dias para vencer: ");
                    int dias = sc.nextInt();
                    inventario.insertarProducto(nombre, cantidad, dias);
                    break;

                case 2:
                    inventario.mostrarInventario();
                    break;

                case 3:
                    inventario.productosProximosAVencer();
                    break;

                case 4:
                    System.out.println("Saliendo");
                    break;
                    
                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 4);

        sc.close();
    }
}