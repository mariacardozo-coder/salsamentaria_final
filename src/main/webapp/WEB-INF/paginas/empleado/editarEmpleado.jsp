<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/f90d3bf50d.js" crossorigin="anonymous"></script>

    <title>Editar Empleado</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/ServletEmpleado?accion=modificar&idEmpleado=${empleado.idEmpleado}"
      method="POST" class="was-validated">


    <section id="details">
        <div class="container">
            <div class="row">
                <div class="col">
                    <div class="card">
                        <div class="card-header">
                            <h4>Editar Empleado</h4>
                        </div>
                        <div class="card-body">
                            <div class="form-group">
                                <label for="documento">Documento</label>
                                <input type="text" class="form-control" name="documento" required
                                       value="${empleado.documento}">
                            </div>
                            <div class="form-group">
                                <label for="nombre">Nombre</label>
                                <input type="text" class="form-control" name="nombres" required
                                       value="${empleado.nombres}">
                            </div>
                            <div class="form-group">
                                <label for="telefono">Telefono</label>
                                <input type="text" class="form-control" name="telefono" required
                                       value="${empleado.telefono}">
                            </div>
                            <div class="form-group">
                                <label for="estado">Estado</label>
                                <input type="text" class="form-control" name="estado" required
                                       value="${empleado.estado}">
                            </div>
                            <div class="form-group">
                                <label for="usuario">Usuario</label>
                                <input type="text" class="form-control" name="usuario" required
                                       value="${empleado.usuario}">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="/WEB-INF/paginas/comunesEmpleado/botonesNavegacionEdicion.jsp"/>
    </section>
</form>
</body>
</html>

