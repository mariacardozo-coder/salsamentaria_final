package web;

import datos.EmpleadoDaoJdbc;
import dominio.Empleado;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/ServletEmpleado")
public class ServletEmpleado extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "listar":
                    this.listarEmpleado(request, response);
                    break;
                case "encontrar":
                    this.encontrarEmpleado(request, response);
                    break;
                case "eliminar":
                    this.eliminarEmpleado(request, response);
                    break;
                default:
                    this.listarEmpleado(request, response);
            }
        } else {
            this.listarEmpleado(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarEmpleado(request, response);
                    break;
                case "modificar":
                    this.modificarEmpleado(request, response);
                    break;
                default:
                    this.listarEmpleado(request, response);
            }
        } else {
            this.listarEmpleado(request, response);
        }
    }

    public void listarEmpleado(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Empleado> empleados = new EmpleadoDaoJdbc().Listar();

        HttpSession sesion = request.getSession();  //como para redirigis a clientes.jsp estamos usando sendRedirect debeeemos poner los setAttribute en el alcance de sesion para que se muestre la informacion de la BD
        sesion.setAttribute("empleados", empleados);
        //request.getRequestDispatcher("clientes.jsp").forward(request, response);  //este meetodo permite que al refrescar la pagina se duplique algun cliente por eso usamos mas bieen la linea de abajo con sendReedirect
        response.sendRedirect("empleados.jsp");


//        List<Empleado> empleados = new EmpleadoDaoJdbc().Listar();
//        request.setAttribute("empleados", empleados);
//        request.getRequestDispatcher("empleados.jsp").forward(request, response);
    }

    public void encontrarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
        Empleado empleado1 = new Empleado(idEmpleado);
        Empleado empleado = new EmpleadoDaoJdbc().encontrar(empleado1);
        request.setAttribute("empleado", empleado);
        request.getRequestDispatcher("/WEB-INF/paginas/empleado/editarEmpleado.jsp").forward(request, response);

    }


    public void insertarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //recuperamos los datos del formulario agregarEmpleado.jsp
        String documento = request.getParameter("documento");
        String nombres = request.getParameter("nombres");
        String telefono = request.getParameter("telefono");
        String estado = request.getParameter("estado");
        String usuario = request.getParameter("usuario");


        //creamos el objeto empleado
        Empleado empleado = new Empleado(documento, nombres, telefono, estado, usuario);

        //pasamos el parametro al metodo insertarEmpleado
        int registrosModificados = new EmpleadoDaoJdbc().insertarEmpleado(empleado);

        this.listarEmpleado(request, response);


    }

    public void modificarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
        String documento = request.getParameter("documento");
        String nombres = request.getParameter("nombres");
        String telefono = request.getParameter("telefono");
        String estado = request.getParameter("estado");
        String usuario = request.getParameter("usuario");


        //creamos el objeto cliente de la clase modeelo
        Empleado empleado;
        empleado = new Empleado(idEmpleado, documento, nombres, telefono, estado, usuario);

        //modificamos el objeto cliente a la base de datos
        int registrosModificados = new EmpleadoDaoJdbc().actualizar(empleado);

        //redirigimos a accion por default
        this.listarEmpleado(request, response);

    }

    public void eliminarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));

        Empleado empleado = new Empleado(idEmpleado);

        int registrosModificados = new EmpleadoDaoJdbc().eliminar(empleado);

        this.listarEmpleado(request, response);
    }
}
