package tienda;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * CÓDIGO CON CODESMELLING
 * 
 * TODO: Este código necesita un refactorización urgente.
 * - Eliminar la "Clase Dios" que es todo el main
 * - Usar programación orientada a objetos
 * - Eliminar números fijos introducidos en el código (no están dentro de variables).
 * - Mejorar la gestión de logs (Patrón Singleton).
 */

/**
 * refactor/encapsulate
 * Creado objeto producto e implementar cambios al programa para usarlo, creando
 * una lista unica
 * para los datos, metindo los datos iniciales, adaptando el programa a usar la
 * nueva lista.
 */

public class Tienda {

    public static ArrayList<Producto> productos = new ArrayList<>();

    public static void main(String[] args) {

        // Datos de prueba iniciales

        Scanner sc = new Scanner(System.in);
        productos.add(new Producto("Camiseta", 15.0, 10));
        productos.add(new Producto("Pantalón", 30.0, 5));
        productos.add(new Producto("Zapatos", 45.0, 2));

        while (true) {
            System.out.println("\n--- TIENDA ---");
            System.out.println("1. Añadir producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Realizar venta");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int op = sc.nextInt();

            if (op == 1) {
                System.out.print("Nombre del producto: ");
                String nombre = sc.next();

                System.out.print("Precio: ");
                double precio = sc.nextDouble();
                System.out.print("Stock inicial: ");
                int stock = sc.nextInt();

                productos.add(new Producto(nombre, precio, stock));

                System.out.println("Producto añadido correctamente.");

            } else if (op == 2) {
                System.out.println("\n--- INVENTARIO ACTUAL ---");
                if (productos.isEmpty()) {
                    System.out.println("No hay productos.");
                } else {
                    for (int i = 0; i < productos.size(); i++) {

                        System.out.println(i + ". " + productos.get(i).getNombre() + " - " +
                                productos.get(i).getPrecio() + "€ - Stock: " + productos.get(i).getStock());
                    }
                }

            } else if (op == 3) {
                System.out.println("\n--- VENTA ---");
                System.out.print("Introduzca nombre del producto a vender: ");
                String prod = sc.next();

                int pos = -1;
                for (int i = 0; i < productos.size(); i++) {

                    if (productos.get(i).getNombre().equalsIgnoreCase(prod)) {
                        pos = i;
                        break;
                    }
                }

                if (pos != -1) {
                    System.out.println("Producto encontrado: " + productos.get(pos).getNombre());
                    System.out.println("Precio: " + productos.get(pos).getPrecio() + "€ | Stock: "
                            + productos.get(pos).getStock());

                    System.out.print("Cantidad a comprar: ");
                    int cant = sc.nextInt();

                    if (productos.get(pos).getPrecio() >= cant) {
                        double total = cant * productos.get(pos).getPrecio();

                        // Hay números fijos que se utilizan en el código
                        if (total > 50) {
                            System.out.println("¡Oferta! Descuento aplicado por compra superior a 50€");
                            total = total * 0.90;
                        }

                        productos.get(pos).setPrecio(productos.get(pos).getStock() - cant); // Actualizar stock
                        System.out.println("Venta realizada. Total a pagar: " + total + "€");

                        // Debería ser Singleton
                        System.out.println("[LOG SYSTEM]: Venta de " + cant + "x "
                                + productos.get(pos).getNombre() + "registrada.");

                        if (productos.get(pos).getStock() < 3) {

                            System.out.println("[LOG SYSTEM]: ALERTA DE STOCK BAJO para "
                                    + productos.get(pos).getNombre());
                        }

                    } else {
                        System.out.println("Error: No hay suficiente stock.");
                    }
                } else {
                    System.out.println("Error: Producto no encontrado.");
                }

            } else if (op == 4) {
                System.out.println("Saliendo...");
                break;
            } else {
                System.out.println("Opción no válida.");
            }
        }
        sc.close();
    }
}
