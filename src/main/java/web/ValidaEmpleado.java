package web;

import datos.EmpleadoDaoJdbc;
import dominio.Empleado;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ValidaEmpleado")
public class ValidaEmpleado extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion != null) {

            switch (accion) {
                case "validar":
                    this.validarUsuario(request, response);
                    break;

            }
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    //************ metodo que valida el empleado *************************************
    public void validarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //recuperamos el id del cliente
        String documento = request.getParameter("txtNombres");
        String usuario = request.getParameter("txtPassword");
        //recuperamos el cliente con el metodo encontrar
        Empleado empleado = new Empleado(documento, usuario);//guardamos el id con el metodo que solo recibe el id del cliente en la capa de datos

        int empleadoA = new EmpleadoDaoJdbc().loginEmpleado(empleado); //pasamos el objeto que contieene el idCliente

        if (empleadoA == 1) {
            String jspEditar = "hola.jsp";
            request.getRequestDispatcher(jspEditar).forward(request, response);
        } else {
            String jspEditar = "index.jsp";
            request.getRequestDispatcher(jspEditar).forward(request, response);
        }

    }
}
