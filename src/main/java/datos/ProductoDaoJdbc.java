package datos;

import dominio.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDaoJdbc {

    private static final String SQL_SELECT = "SELECT IdProducto, Nombres, Precio,Stock, Estado FROM producto";
    private static final String SQL_SELECT_BY_ID = "SELECT IdProducto, Nombres, Precio,Stock, Estado FROM producto WHERE IdProducto = ? ";
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
                double precio = rs.getDouble("Precio");
                int stock = rs.getInt("Stock");
                String estado = rs.getString("Estado");

                Producto = new Producto(idProducto, nombres, precio, stock, estado);
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
}
