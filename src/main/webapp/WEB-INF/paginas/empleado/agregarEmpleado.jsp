<div class="modal fade" id="agregarEmpleadoModal">
    <div class="modal-dialog  modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Empleado</h5>
                <button class="close" data-dismiss="modal">
                    <span>&Chi;</span>
                </button>
            </div>


            <form action="${pageContext.request.contextPath}/ServletEmpleado?accion=insertar" method="POST"
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
                        <label for="telefono">Telefono</label>
                        <input type="text" class="form-control" name="telefono" required>
                    </div>
                    <div class="form-group">
                        <label for="estado">Estado</label>
                        <input type="text" class="form-control" name="estado" required>
                    </div>
                    <div class="form-group">
                        <label for="usuario">Usuario</label>
                        <input type="text" class="form-control" name="usuario" required>
                    </div>

                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
            </form>
        </div>
    </div>
</div>
