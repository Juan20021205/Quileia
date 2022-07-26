<form id="formCiudad" class="p-2" method="post" action="SubmitCiudadInfo" >
	<div class="modal-body">
		<label class="form-label" for="nombreCiudad">Nombre de la ciudad</label>
		<input class="form-control" type="text" name="nombreCiudad" id="nombreCiudad" onkeypress="return keypress(event)" required>
		<label class="form-label" for="cantHabit" >Cantidad de habitantes</label>
		<input class="form-control" type="number" name="cantHabit" id="cantHabit" min="1" onkeypress="return keypress(event)" required>
		<label class="form-label" for="lugTurist">Lugar más turistico</label>
		<input class="form-control" type="text" name="lugTurist" id="lugTurist" onkeypress="return keypress(event)" required>
		<label class="form-label" for="hotelmasReserv">Hotel más reservado</label>
		<input class="form-control" type="text" name="hotelmasReserv" id="hotelmasReserv" onkeypress="return keypress(event)" required>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
		<button type="submit" class="btn btn-primary">Guardar</button>
	</div>
</form>