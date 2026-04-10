package Presentacion;



import Entidad.Producto;
import Service.ProductoService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductoService service = new ProductoService();
        int opcion;

        do {
            System.out.println("-- INVENTARIO --");
            System.out.println("1. Registrar");
            System.out.println("2. Listar");
            System.out.println("3. Buscar");
            System.out.println("4. Actualizar");
            System.out.println("5. Eliminar");
            System.out.println("0. Salir");

            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();

                
                    double precio = 0;
                    boolean valido = false;

                    while (!valido) {
                        try {
                            System.out.print("Precio: ");
                            String input = sc.next();
                            precio = Double.parseDouble(input.replace(",", "."));
                            valido = true;
                        } catch (Exception e) {
                            System.out.println("Ingrese un número válido");
                        }
                    }

                    service.registrarProducto(new Producto(id, nombre, cantidad, precio));
                    break;

                case 2:
                    service.listarProductos().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("ID: ");
                    Producto p = service.buscar(sc.nextInt());
                    System.out.println(p != null ? p : "No encontrado");
                    break;

                case 4:
                    System.out.print("ID: ");
                    int idAct = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nuevo nombre: ");
                    String nom = sc.nextLine();

                    System.out.print("Cantidad: ");
                    int cant = sc.nextInt();

                   
                    double prec = 0;
                    boolean valido2 = false;

                    while (!valido2) {
                        try {
                            System.out.print("Precio: ");
                            String input = sc.next();
                            prec = Double.parseDouble(input.replace(",", "."));
                            valido2 = true;
                        } catch (Exception e) {
                            System.out.println("Ingrese un número válido");
                        }
                    }

                    service.actualizarProducto(new Producto(idAct, nom, cant, prec));
                    break;

                case 5:
                    System.out.print("ID: ");
                    service.eliminarProducto(sc.nextInt());
                    break;
            }

        } while (opcion != 0);

        System.out.println("Programa finalizado");
    }
}

