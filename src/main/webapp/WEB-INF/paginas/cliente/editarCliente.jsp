<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/f90d3bf50d.js" crossorigin="anonymous"></script>

    <title>Editar Cliente</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/ServletCliente?accion=modificar&idCliente=${cliente.idCliente}"
      method="POST" class="was-validated">


    <section id="details">
        <div class="container">
            <div class="row">
                <div class="col">
                    <div class="card">
                        <div class="card-header">
                            <h4>Editar Cliente</h4>
                        </div>
                        <div class="card-body">
                            <div class="form-group">
                                <label for="documento">Documento</label>
                                <input type="text" class="form-control" name="documento" required
                                       value="${cliente.documento}">
                            </div>
                            <div class="form-group">
                                <label for="nombres">Nombre</label>
                                <input type="text" class="form-control" name="nombres" required
                                       value="${cliente.nombres}">
                            </div>
                            <div class="form-group">
                                <label for="direccion">Direccion</label>
                                <input type="text" class="form-control" name="direccion" required
                                       value="${cliente.direccion}">
                            </div>
                            <div class="form-group">
                                <label for="estado">Estado</label>
                                <input type="text" class="form-control" name="estado" required
                                       value="${cliente.estado}">
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="/WEB-INF/paginas/comunesCliente/botonesNavegacionEdicion.jsp"/>
    </section>
</form>
</body>
</html>
