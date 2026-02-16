package tienda;

public class Zapato {

    private double precio;
    private int stock;

    public Zapato(double precio, int stock) {
        this.precio = precio;
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
