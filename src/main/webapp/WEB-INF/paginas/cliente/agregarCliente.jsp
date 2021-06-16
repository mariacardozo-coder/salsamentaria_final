<div class="modal fade" id="agregarClienteModal">
    <div class="modal-dialog  modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Cliente</h5>
                <button class="close" data-dismiss="modal">
                    <span>&Chi;</span>
                </button>
            </div>


            <form action="${pageContext.request.contextPath}/ServletCliente?accion=insertar" method="POST"
                  class="was-validated">
                <div class="modal-body">

                    <div class="form-group">
                        <label for="documento">Documento</label>
                        <input type="text" class="form-control" name="documento" required>
                    </div>
                    <div class="form-group">
                        <label for="nombres">Nombres</label>
                        <input type="text" class="form-control" name="nombres" required>
                    </div>
                    <div class="form-group">
                        <label for="direccion">Direccion</label>
                        <input type="text" class="form-control" name="direccion" required>
                    </div>
                    <div class="form-group">
                        <label for="estado">Estado</label>
                        <input type="text" class="form-control" name="estado" required>
                    </div>


                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
            </form>
        </div>
    </div>
</div>
