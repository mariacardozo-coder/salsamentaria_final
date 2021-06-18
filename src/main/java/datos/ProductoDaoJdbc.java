package datos;

import dominio.Producto;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.Decoder;
import javax.websocket.Encoder;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDaoJdbc {

    private static final String SQL_SELECT = "SELECT IdProducto, Nombres,Foto,Descripcion ,Precio,Stock FROM producto";
    private static final String SQL_SELECT_BY_ID = "SELECT IdProducto, Nombres,Foto, Descripcion, Precio,Stock FROM producto WHERE IdProducto = ? ";
    private static final String SQL_INSERT = "INSERT INTO producto (Nombres, Precio,Stock, Estado) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE producto SET Nombres = ?, Precio= ?, Stock= ?, Estado= ? WHERE IdProducto= ?";
    private static final String SQL_DELETE = "DELETE FROM producto WHERE IdProducto = ?";

    public List<Producto> Listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Producto> Productos = new ArrayList<>();
        Producto Producto = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {

                int idProducto = rs.getInt("IdProducto");
                String nombres = rs.getString("Nombres");
                InputStream foto = rs.getBinaryStream("Foto");
                //Decoder.BinaryStream foto = (Decoder.BinaryStream) rs.getObject("Foto");
                String descripcion = rs.getString("Descripcion");
                double precio = rs.getDouble("Precio");
                int stock = rs.getInt("Stock");


                Producto = new Producto(idProducto, nombres, (InputStream) foto, descripcion, precio, stock);
                Productos.add(Producto);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return Productos;
    }

    public void listarImg(int id, HttpServletResponse response) throws SQLException {
        String sql = "select * from producto where IdProducto = " + id;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            outputStream = response.getOutputStream();
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs.next()) {
                inputStream = rs.getBinaryStream("Foto");
            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            int i = 0;
            while ((i = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
    }

    public Producto listarPorId(Producto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, producto.getIdProducto());
            rs = stmt.executeQuery();

            while (rs.next()) {

                int idProducto = rs.getInt("IdProducto");
                String nombres = rs.getString("Nombres");
                InputStream foto = rs.getBinaryStream("Foto");
                String descripcion = rs.getString("Descripcion");
                Double precio = rs.getDouble("Precio");
                int stock = rs.getInt("Precio");


                producto.setIdProducto(idProducto);
                producto.setNombres(nombres);
                producto.setFoto(foto);
                producto.setDescripcion(descripcion);
                producto.setPrecio(precio);
                producto.setStock(stock);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return producto;
    }
}
