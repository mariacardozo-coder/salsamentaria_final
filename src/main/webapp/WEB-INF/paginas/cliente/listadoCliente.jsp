<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<section id="empleados">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Clientes</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                        <tr>
                            <td>Id</td>
                            <td>Documento</td>
                            <td>Nombres</td>
                            <td>Direccion</td>
                            <td>Estado</td>
                            <td>acciones</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="cliente" items="${clientes}">
                            <tr>
                                <td>${cliente.idCliente}</td>
                                <td>${cliente.documento}</td>
                                <td>${cliente.nombres}</td>
                                <td>${cliente.direccion}</td>
                                <td>${cliente.estado}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/ServletCliente?accion=encontrar&idCliente=${cliente.idCliente}"
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

<jsp:include page="/WEB-INF/paginas/cliente/agregarCliente.jsp"/>
