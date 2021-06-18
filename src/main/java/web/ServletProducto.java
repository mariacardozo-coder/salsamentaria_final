package web;

import datos.ProductoDaoJdbc;
import dominio.Producto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/ServletProducto")
public class ServletProducto extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "listar":
                    this.listarProducto(request, response);
                    break;
                default:
                    this.listarProducto(request, response);
            }

        } else {
            this.listarProducto(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    public void listarProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List productos = new ProductoDaoJdbc().Listar();
        HttpSession session = request.getSession();
        session.setAttribute("productos", productos);
        response.sendRedirect("productos.jsp");
    }
}
