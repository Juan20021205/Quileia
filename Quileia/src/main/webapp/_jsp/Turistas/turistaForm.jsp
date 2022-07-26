<form class="m-4" action="SubmitTuristaInfo" method="post">
    <div class="modal-body">
        <div class="row">
            <label class="form-label" for="nombre">Nombre Completo</label>
            <input class="form-control" type="text" name="nombre" id="nombre" style="width:95%;margin-left:10px;">
            <div class="col">
                <label class="form-label mt-3" for="tipoId">Tipo de identificacion</label>
                <input class="form-control" type="text" name="tipoId" id="tipoId">
                <label class="form-label mt-3" for="FrecViaje">Frecuencia de viajes al Mes</label>
                <input class="form-control" type="number" name="FrecViaje" id="FrecViaje">
                <label class="form-label mt-3" for="Presupuesto">Presupuesto</label>
                <input class="form-control" type="number" name="Presupuesto" id="Presupuesto">
            </div>
            <div class="col">
                <label class="form-label mt-3" for="NId">No. Identificacion</label>
                <input class="form-control" type="text" name="NId" id="NId">
                <label class="form-label mt-3" for="fechaNac">Fecha de naciemieto</label>
                <input class="form-control" type="date" name="fechaNac" id="fechaNac">
                <label class="form-label mt-3" for="tarjeta">¿Usa tarjeta?</label>
                <select class="form-select" name="tarjeta" aria-label="Default select example">
				  <option selected></option>
				  <option value="1">Si</option>
				  <option value="0">No</option>
				</select>
            </div>
        </div>
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
        <button type="submit" class="btn btn-primary">Guardar</button>
    </div>
</form>