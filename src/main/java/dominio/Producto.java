package dominio;

public class Producto {

    int idProducto;
    String nombres;
    double precio;
    int stock;
    String estado;


    public Producto() {
    }

    public Producto(int idProducto, String nombres, double precio, int stock, String estado) {
        this.idProducto = idProducto;
        this.nombres = nombres;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
    }

    public Producto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(String nombres, double precio, int stock, String estado) {
        this.nombres = nombres;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombres='" + nombres + '\'' +
                ", precio=" + precio +
                ", stock='" + stock + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
