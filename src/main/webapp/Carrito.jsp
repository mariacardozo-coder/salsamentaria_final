<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/f90d3bf50d.js" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">La Zipaquireña</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                <li class="nav-item">
                    <a class="nav-link" href="#">Ofertas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ServletProducto?accion=listar"> Seguir
                        Comprando</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Iniciar Sesion
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Action</a></li>
                        <li><a class="dropdown-item" href="#">Another action</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                </li>

            </ul>

        </div>
    </div>
</nav>

<div class="container mt-4">
    <h1>Carro</h1>
    <div class="row">

        <div class="col-sm-8">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>item</th>
                    <th>Nombres</th>
                    <th>Descripcion</th>
                    <th>Precio</th>
                    <th>Cant</th>
                    <th>Subtotal</th>
                    <th>Acciones</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="producto" items="${carrito}">
                    <tr>
                        <td>${producto.getItem()}</td>
                        <td>${producto.getNombres()}</td>
                        <td>${producto.getDescripcion()}
                        <img src="${pageContext.request.contextPath}/ServletIMG?id=${producto.getIdProducto()}" width="100" height="100"></td>
                        <td>${producto.getPrecioCompra()}</td>
                        <td>${producto.getCantidad()}</td>
                        <td>${producto.getSubTotal()}</td>
                        <td>
                            <a class="btn btn-danger" href="${pageContext.request.contextPath}/ServletCarrito?accion=Delete&idp=${producto.getIdProducto()}">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>


        <div class="col-sm-4">
            <div class="card">
                <div class="card-header">
                    <h3>Generar Compra</h3>
                </div>
                <div class="card-body">
                    <label>SubTotal</label>
                    <input type="text" value="${totalPagar}" readonly="" class="form-control">
                    <label>Descuento</label>
                    <input type="text" readonly="" class="form-control">
                    <label>Total a Pagar</label>
                    <input type="text" value="${totalPagar}" readonly="" class="form-control">
                </div>
                <div class="card-footer">
                    <a href="#" class="btn btn-info btn-block">Realizar Pago</a>
                    <a href="#" class="btn btn-danger btn-block">Generar Compra</a>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="js/funciones.js" type="text/javascript"></script>
</body>
</html>
