package web;

import datos.ProductoDaoJdbc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/ServletIMG")
public class ServletIMG extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductoDaoJdbc productoDaoJdbc = new ProductoDaoJdbc();
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            productoDaoJdbc.listarImg(id, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
