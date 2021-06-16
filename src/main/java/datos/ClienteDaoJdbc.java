package datos;

import dominio.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoJdbc {

    private static final String SQL_SELECT = "select IdCliente,Documento, Nombre, Direccion,Estado from cliente";
    private static final String SQL_SELECT_BY_ID = "select IdCliente,Documento, Nombre, Direccion,Estado from cliente where IdCliente = ? ";
    private static final String SQL_INSERT = "INSERT INTO cliente (documento, nombre, direccion, estado) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE cliente SET documento = ? , nombre = ? , direccion = ? , estado = ?  WHERE IdCliente = ? ";
    private static final String SQL_DELETE = "DELETE from cliente WHERE IdCliente = ? ";


    public List<Cliente> Listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {

                int idCliente = rs.getInt("IdCliente");
                String documento = rs.getString("documento");
                String nombres = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String estado = rs.getString("estado");

                cliente = new Cliente(idCliente, documento, nombres, direccion, estado);
                clientes.add(cliente);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return clientes;
    }

    public Cliente encontrar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, cliente.getIdCliente());
            rs = stmt.executeQuery();
            rs.next();

            int idCliente = rs.getInt("IdCliente");
            String documento = rs.getString("documento");
            String nombres = rs.getString("nombre");
            String direccion = rs.getString("direccion");
            String estado = rs.getString("estado");

            cliente.setIdCliente(idCliente);
            cliente.setDocumento(documento);
            cliente.setNombres(nombres);
            cliente.setDireccion(direccion);
            cliente.setEstado(estado);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cliente;
    }

    public int insertarCliente(Cliente cliente) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, cliente.getDocumento());
            stmt.setString(2, cliente.getNombres());
            stmt.setString(3, cliente.getDireccion());
            stmt.setString(4, cliente.getEstado());

            rows = stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int actualizarCliente(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, cliente.getDocumento());
            stmt.setString(2, cliente.getNombres());
            stmt.setString(3, cliente.getDireccion());
            stmt.setString(4, cliente.getEstado());
            stmt.setInt(5, cliente.getIdCliente());

            rows = stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int eliminarCliente(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, cliente.getIdCliente());


            rows = stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;

    }

}
