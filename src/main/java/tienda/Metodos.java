package tienda;

import java.util.ArrayList;
import java.util.Scanner;

public class Metodos {
    public static final Scanner sc = new Scanner(System.in);

    public static void comprar(int pos, ArrayList<Producto> productos) {

        double ofertaPorcentaje = 90;
        int cantidadOferta = 50;

        if (pos != -1) {
            System.out.println("Producto encontrado: " + productos.get(pos).getNombre());
            System.out.println("Precio: " + productos.get(pos).getPrecio() + "€ | Stock: "
                    + productos.get(pos).getStock());

            System.out.print("Cantidad a comprar: ");
            int cant = sc.nextInt();

            if (productos.get(pos).getStock() >= cant) {
                double total = cant * productos.get(pos).getPrecio();

                if (total > cantidadOferta) {
                    System.out.println("¡Oferta! Descuento aplicado por compra superior a 50€");
                    total = total * ofertaPorcentaje;
                }

                productos.get(pos).setStock(productos.get(pos).getStock() - cant);
                System.out.println("Venta realizada. Total a pagar: " + total + "€");

                Logger logger = Logger.getInstance();
                logger.log("Venta de " + cant + "x "
                        + productos.get(pos).getNombre()
                        + " realizada por " + total + "€");

            } else {
                System.out.println("Error: No hay suficiente stock.");
            }
        } else {
            System.out.println("Error: Producto no encontrado.");
        }

    }

}
