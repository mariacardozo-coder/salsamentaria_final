package dominio;

public class Empleado  {

    int idEmpleado;
    String documento;
    String nombres;
    String telefono;
    String estado;
    String usuario;



    public Empleado() {
    }

    public Empleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleado(int idEmpleado, String documento, String nombres, String telefono, String estado, String usuario) {
        this.idEmpleado = idEmpleado;
        this.documento = documento;
        this.nombres = nombres;
        this.telefono = telefono;
        this.estado = estado;
        this.usuario = usuario;
    }

    public Empleado(String documento, String nombres, String telefono, String estado, String usuario) {
        this.documento = documento;
        this.nombres = nombres;
        this.telefono = telefono;
        this.estado = estado;
        this.usuario = usuario;
    }

    public Empleado(String documento, String usuario) {
        this.documento = documento;
        this.usuario = usuario;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
