package web;

import datos.ProductoDaoJdbc;
import dominio.Carrito;
import dominio.Producto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ServletCarrito")
public class ServletCarrito extends HttpServlet {
    ProductoDaoJdbc productoDaoJdbc = new ProductoDaoJdbc();
    Producto producto = new Producto();
    List<Carrito> listaCarrito = new ArrayList<>();
    int item;
    double totalPagar = 0.0;
    int cantidad = 1;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "AgregarCarrito":
                    this.agregarProductoACarrito(request, response);
                    break;
                case "Carrito":
                    this.listarCarrito(request, response);
                    break;
                case "Comprar":
                    this.comprar(request, response);
                    break;
                case "Delete":
                    this.eliminarDeCarrito(request, response);
                    break;
                default:
                    this.listarCarrito(request, response);
            }

        } else {
            this.listarCarrito(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {


            }

        } else {

        }
    }

    public void agregarProductoACarrito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int posicion = 0;
        cantidad = 1;
        double subTotal = 0;
        int idProducto = Integer.parseInt(request.getParameter("id"));
        Producto producto1 = new Producto(idProducto);
        Producto producto = new ProductoDaoJdbc().listarPorId(producto1);
        //**************************************************************************************************************
        if (listaCarrito.size() > 0) {
            for (int i = 0; i < listaCarrito.size(); i++) {
                if (idProducto == listaCarrito.get(i).getIdProducto()) {
                    posicion = i; //posicion del producto en la lista
                }
            }
            if (idProducto == listaCarrito.get(posicion).getIdProducto()) {
                cantidad = listaCarrito.get(posicion).getCantidad() + cantidad;
                subTotal = listaCarrito.get(posicion).getPrecioCompra() * cantidad;
                listaCarrito.get(posicion).setCantidad(cantidad);
                listaCarrito.get(posicion).setSubTotal(subTotal);
               // request.getRequestDispatcher("ServletProducto?accion=listar").forward(request, response);

            } else {
                item += 1;
                Carrito car = new Carrito();
                car.setItem(item);
                car.setIdProducto(producto.getIdProducto());
                car.setNombres(producto.getNombres());
                car.setDescripcion(producto.getDescripcion());
                car.setPrecioCompra(producto.getPrecio());
                car.setCantidad(cantidad);
                car.setSubTotal(producto.getPrecio() * cantidad);
                listaCarrito.add(car);
                //request.getRequestDispatcher("ServletProducto?accion=listar").forward(request, response);
        //**************************************************************************************************************
            }
        } else {
            item += 1;
            Carrito car = new Carrito();
            car.setItem(item);
            car.setIdProducto(producto.getIdProducto());
            car.setNombres(producto.getNombres());
            car.setDescripcion(producto.getDescripcion());
            car.setPrecioCompra(producto.getPrecio());
            car.setCantidad(cantidad);
            car.setSubTotal(producto.getPrecio() * cantidad);
            listaCarrito.add(car);
            request.setAttribute("contador", listaCarrito.size());
            //request.getRequestDispatcher("ServletProducto?accion=listar").forward(request, response);

        }
        request.getRequestDispatcher("ServletProducto?accion=listar").forward(request, response);
    }

    public void listarCarrito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        totalPagar = 0.0;
        request.setAttribute("carrito", listaCarrito);
        for (int i = 0; i < listaCarrito.size(); i++) {
            totalPagar += listaCarrito.get(i).getSubTotal();
        }
        request.setAttribute("totalPagar", totalPagar);
        request.getRequestDispatcher("Carrito.jsp").forward(request, response);
    }

    public void comprar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        totalPagar = 0.0;
        int idProducto = Integer.parseInt(request.getParameter("id"));
        Producto producto1 = new Producto(idProducto);
        Producto producto = new ProductoDaoJdbc().listarPorId(producto1);
        item += 1;
        Carrito car = new Carrito();
        car.setItem(item);
        car.setIdProducto(producto.getIdProducto());
        car.setNombres(producto.getNombres());
        car.setDescripcion(producto.getDescripcion());
        car.setPrecioCompra(producto.getPrecio());
        car.setCantidad(cantidad);
        car.setSubTotal(producto.getPrecio() * cantidad);
        listaCarrito.add(car);
        for (int i = 0; i < listaCarrito.size(); i++) {
            totalPagar += listaCarrito.get(i).getSubTotal();//acumulador para el subtotal de la lista
        }
        request.setAttribute("carrito", listaCarrito);
        request.setAttribute("totalPagar", totalPagar);
        request.setAttribute("contador", listaCarrito.size());
        request.getRequestDispatcher("Carrito.jsp").forward(request, response);
    }

    public void eliminarDeCarrito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idproducto = Integer.parseInt(request.getParameter("idp"));
        for (int i = 0; i < listaCarrito.size(); i++) {
            if (listaCarrito.get(i).getIdProducto() == idproducto) ;
            listaCarrito.remove(i);
        }
        this.listarCarrito(request, response);

    }
}
