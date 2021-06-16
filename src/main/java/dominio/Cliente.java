package dominio;

public class Cliente extends Persona {

    int idCliente;
    String estado;
    String documento;
    String nombres;
    String direccion;



    public Cliente() {
    }

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(String documento) {
        this.documento = documento;
    }

    public Cliente(int idCliente, String documento, String nombres, String direccion, String estado) {
        this.idCliente = idCliente;
        this.estado = estado;
        this.documento = documento;
        this.nombres = nombres;
        this.direccion = direccion;
    }

    public Cliente(String documento, String nombres, String direccion, String estado) {
        this.estado = estado;
        this.documento = documento;
        this.nombres = nombres;
        this.direccion = direccion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", estado='" + estado + '\'' +
                ", documento='" + documento + '\'' +
                ", nombres='" + nombres + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
