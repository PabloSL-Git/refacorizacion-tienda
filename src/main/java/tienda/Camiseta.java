package tienda;

public class Camiseta {

    private double precio;
    private int stock;

    public Camiseta(double precio, int stock) {
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
