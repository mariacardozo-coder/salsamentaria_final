<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<section id="empleados">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Empleados</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                        <tr>
                            <td>Id</td>
                            <td>Documento</td>
                            <td>Nombres</td>
                            <td>Telefono</td>
                            <td>Estado</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="empleado" items="${empleados}">
                            <tr>
                                <td>${empleado.idEmpleado}</td>
                                <td>${empleado.documento}</td>
                                <td>${empleado.nombres}</td>
                                <td>${empleado.telefono}</td>
                                <td>${empleado.estado}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/ServletEmpleado?accion=encontrar&idEmpleado=${empleado.idEmpleado}"
                                       class="btn btn-secondary">
                                        <i class="fas fa-angle-double-right"> Editar</i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/WEB-INF/paginas/empleado/agregarEmpleado.jsp"/>
