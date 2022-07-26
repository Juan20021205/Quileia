<c:forEach items="${ciudades}" var="ciudad">
	<div class="row">
		<div class="col">
			<div class="card">
				<div class="card-body d-flex justify-content-between align-items-center">
					${ciudad.getNombre()}
					<div>
						<a title="Historial" href="#history" class="me-3" data-bs-toggle="modal" onclick="ciudadHistory(${ciudad.getId()})"><i class="bi bi-clock-history" style="color: #000000; font-size: 21px"></i></a>
						<a title="Detalles" href="Ciudad?a=getToUpdate&id=${ciudad.getId()}" class="me-3"><i class="bi bi-exclamation-circle-fill" style="color: #000000; font-size: 21px"></i></a>
						<a title="Eliminar" href="#delete" data-bs-toggle="modal" class="me-3" onclick="deleteCiudad(${ciudad.getId()})"><i class="bi bi-x-circle-fill" style="color: #000000; font-size: 21px"></i></a>
					</div>
				</div>
			</div>
		</div>
	</div>      
</c:forEach>