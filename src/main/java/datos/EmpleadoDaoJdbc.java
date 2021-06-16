package datos;

import dominio.Empleado;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDaoJdbc {

    private static final String SQL_LOGIN = "select IdEmpleado, Documento, Nombres, Telefono, Estado, Usuario from empleado where Documento = ? and Usuario= ?";
    private static final String SQL_SELECT = "select  IdEmpleado, Documento, Nombres, Telefono, Estado, Usuario FROM empleado";
    private static final String SQL_SELECT_BY_ID = "select IdEmpleado, Documento, Nombres, Telefono, Estado, Usuario FROM empleado WHERE IdEmpleado = ? ";
    private static final String SQL_INSERT = " INSERT INTO empleado ( Documento, Nombres, Telefono, Estado, Usuario) VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE empleado SET  Documento = ?, Nombres = ? , Telefono = ?, Estado = ? , Usuario = ?  WHERE IdEmpleado = ? ";
    private static final String SQL_DELETE = "Delete FROM empleado WHERE IdEmpleado = ?";

    public int loginEmpleado(Empleado empleado) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int r = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //iniciamos la conexxion
            conn = Conexion.getConnection();
            //inicializamos la variavle stmt
            stmt = conn.prepareStatement(SQL_LOGIN);
            stmt.setString(1, empleado.getDocumento());
            stmt.setString(2, empleado.getUsuario());
            rs = stmt.executeQuery();

            while (rs.next()) {

                r = r + 1;
                int IdEmpleado = rs.getInt("IdEmpleado");
                String Documento = rs.getString("Documento");
                String Nombres = rs.getString("Nombres");
                String Telefono = rs.getString("Telefono");
                String Estado = rs.getString("Estado");
                String Usuario = rs.getString("Usuario");

                empleado.setIdEmpleado(IdEmpleado);
                empleado.setDocumento(Documento);
                empleado.setNombres(Nombres);
                empleado.setTelefono(Telefono);
                empleado.setEstado(Estado);
                empleado.setUsuario(Usuario);

                if (r == 1) {
                    r = 1;
                } else {
                    r = 0;
                }

            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return r;
    }

    public List<Empleado> Listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Empleado empleado = null;
        List<Empleado> empleados = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {

                int idEmpleado = rs.getInt("IdEmpleado");
                String documento = rs.getString("Documento");
                String nombres = rs.getString("Nombres");
                String telefono = rs.getString("Telefono");
                String estado = rs.getString("Estado");
                String usuario = rs.getString("Usuario");


                empleado = new Empleado(idEmpleado,documento,nombres,telefono,estado,usuario);
                empleados.add(empleado);

            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return empleados;
    }

    public Empleado encontrar(Empleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            //iniciamos la conexxion
            conn = Conexion.getConnection();
            //inicializamos la variavle stmt
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, empleado.getIdEmpleado()); //definimos que sera el primer parametro y proporcionamos el atributo idCliente
            rs = stmt.executeQuery();
            rs.next(); //definimos que se posicione en el primeer registro encontrado
            //recuperamos los datos de la BD

            int idEmpleado = rs.getInt("IdEmpleado");
            String documento = rs.getString("Documento");
            String nombres = rs.getString("Nombres");
            String telefono = rs.getString("Telefono");
            String estado = rs.getString("Estado");
            String usuario = rs.getString("Usuario");

            empleado.setIdEmpleado(idEmpleado);
            empleado.setDocumento(documento);
            empleado.setNombres(nombres);
            empleado.setTelefono(telefono);
            empleado.setEstado(estado);
            empleado.setUsuario(usuario);


        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return empleado;
    }

    public int insertarEmpleado(Empleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, empleado.getDocumento());
            stmt.setString(2, empleado.getNombres());
            stmt.setString(3, empleado.getTelefono());
            stmt.setString(4, empleado.getEstado());
            stmt.setString(5, empleado.getUsuario());

            rows = stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizar(Empleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        //ResultSet rs = null;  // como el metodo No devuelve nada entonces no es necesario usar resultSet, el metodo solo inserta en la BD
        int rows = 0;

        try {
            //iniciamos la conexion
            conn = Conexion.getConnection();
            //iniciamos la variable stmt
            stmt = conn.prepareCall(SQL_UPDATE);


            stmt.setString(1, empleado.getDocumento());
            stmt.setString(2, empleado.getNombres());
            stmt.setString(3, empleado.getTelefono());
            stmt.setString(4, empleado.getEstado());
            stmt.setString(5, empleado.getUsuario());
            stmt.setInt(6, empleado.getIdEmpleado());

            rows = stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int eliminar(Empleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            //iniciamos la conexion
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, empleado.getIdEmpleado());

            rows = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

}
