package tienda;

import java.util.ArrayList;
import java.util.Scanner;

/**

 * 

 * - Eliminar la "Clase Dios" que es todo el main

 * - Eliminar números fijos introducidos en el código (no están dentro de variables).

 */

/**
 * refactor/encapsulate
 * Creado objeto producto e implementar cambios al programa para usarlo, creando
 * una lista unica
 * para los datos, metindo los datos iniciales, adaptando el programa a usar la
 * nueva lista.
 */

/**
 * refactor/singleton
 * Para mas visibilidad e convertido los ifs a un switch, ahora procedere a
 * implementar el singleton para el log, creando una clase y llamando metodos
 */

/**
 * refactor/numeros_fijos
 * Se añadira variable ofertaPorcentaje para aclarar origen y proposito
 */

/**
 * refactor/class_god
 * Separe el bulto del codigo en una clse metodos para mayor claridad del
 * programa,
 * ademas se añadiran anotaciones para aclarar proposito de codigo,
 * ademas se añadio otra variable que no se descubrio anteriormente,
 * cantidadOferta
 */

public class Tienda {
    public static final Scanner sc = new Scanner(System.in);

    public static ArrayList<Producto> productos = new ArrayList<>();

    public static void main(String[] args) {

        // Datos de prueba iniciales

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
            sc.nextLine();

            switch (op) {
                case 1 -> {
                    System.out.print("Nombre del producto: ");
                    String nombre = sc.nextLine();
                    sc.nextLine();

                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Stock inicial: ");
                    int stock = sc.nextInt();
                    sc.nextLine();

                    productos.add(new Producto(nombre, precio, stock));

                    System.out.println("Producto añadido correctamente.");

                }
                case 2 -> {

                    System.out.println("\n--- INVENTARIO ACTUAL ---");
                    if (productos.isEmpty()) {
                        System.out.println("No hay productos.");
                    } else {
                        for (int i = 0; i < productos.size(); i++) { // investiga e indica productos

                            System.out.println(i + ". " + productos.get(i).getNombre() + " - " +
                                    productos.get(i).getPrecio() + "€ - Stock: " + productos.get(i).getStock());
                        }
                    }

                }
                case 3 -> {

                    System.out.println("\n--- VENTA ---");
                    System.out.print("Introduzca nombre del producto a vender: ");
                    String prod = sc.next();

                    int pos = -1;
                    for (int i = 0; i < productos.size(); i++) {

                        if (productos.get(i).getNombre().equalsIgnoreCase(prod)) { // localiza producto
                            pos = i;
                            break;
                        }
                    }

                    Metodos.comprar(pos, productos); // metodo calcula compra

                }
                case 4 -> {

                    System.out.println("Saliendo...");
                    return;

                }
                default -> {
                    System.out.println("Opción no válida.");
                }
            }

        }

    }
}
