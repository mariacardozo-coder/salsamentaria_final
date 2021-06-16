<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="es_CO"/> <!-- definnimos para formato en colombia -->

<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Productos</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                        <tr>
                            <td>Id</td>
                            <td>Nombres</td>
                            <td>Precio</td>
                            <td>Stock</td>
                            <td>Estado</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="producto" items="${productos}">
                            <tr>
                                <td>${producto.idProducto}</td>
                                <td>${producto.nombres}</td>
                                <td><fmt:formatNumber value="${producto.precio}" type="currency"/></td>
                                <!-- deefinimos el formato para modeda-->
                                <td>${producto.stock}</td>
                                <td>${producto.estado}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/ServletProducto?accion=encontrar&idProducto=${producto.idProducto}"
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
