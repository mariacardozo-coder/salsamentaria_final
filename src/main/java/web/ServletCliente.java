package web;

import datos.ClienteDaoJdbc;
import dominio.Cliente;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion != null) {

            switch (accion) {
                case "listar":
                    this.listarCliente(request, response);
                    break;
                case "encontrar":
                    this.encontrarCliente(request, response);
                    break;
                case "eliminar":
                    this.eliminarCliente(request, response);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion != null) {

            switch (accion) {
                case "insertar":
                    this.insertarCliente(request, response);
                    break;
                case "modificar":
                    this.modificarCliente(request, response);
                    break;
            }
        }
    }


    public void listarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Cliente> clientes = new ClienteDaoJdbc().Listar();

        HttpSession sesion = request.getSession();//como para redirigis a clientes.jsp estamos usando sendRedirect debeeemos poner los setAttribute en el alcance de sesion para que se muestre la informacion de la BD
        sesion.setAttribute("clientes", clientes);
        //request.getRequestDispatcher("clientes.jsp").forward(request, response);  //este meetodo permite que al refrescar la pagina se duplique algun cliente por eso usamos mas bieen la linea de abajo con sendReedirect
        response.sendRedirect("clientes.jsp");
    }

    public void encontrarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        Cliente cliente1 = new Cliente(idCliente);
        Cliente cliente = new ClienteDaoJdbc().encontrar(cliente1);
        request.setAttribute("cliente", cliente);
        request.getRequestDispatcher("/WEB-INF/paginas/cliente/editarCliente.jsp").forward(request, response);

    }

    public void insertarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String documento = request.getParameter("documento");
        String nombres = request.getParameter("nombres");
        String direccion = request.getParameter("direccion");
        String estado = request.getParameter("estado");

        Cliente cliente = new Cliente(documento,nombres,direccion,estado);

        int registrosModificados = new ClienteDaoJdbc().insertarCliente(cliente);

        this.listarCliente(request, response);
    }

    public void modificarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String documento = request.getParameter("documento");
        String nombres = request.getParameter("nombres");
        String estado = request.getParameter("estado");
        String direccion = request.getParameter("direccion");

        //creamos el objeto cliente d ela clase modelo
        Cliente cliente;
        cliente = new Cliente(idCliente,documento, nombres, direccion,estado);

        int registrosModificados = new ClienteDaoJdbc().actualizarCliente(cliente);

        this.listarCliente(request, response);
    }


    public void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int idCliente = Integer.parseInt(request.getParameter("idCliente"));

        Cliente cliente = new Cliente(idCliente);

        int registrosModificados = new ClienteDaoJdbc().eliminarCliente(cliente);

        this.listarCliente(request, response);
    }
}
