function keypress(e){
	let campo = e.originalTarget.id;
	let codigo = e.which;
	switch(campo){
		case "nombreCiudad":
			if(codigo >= 65 && codigo <= 90 || codigo >= 97 && codigo <= 122 || codigo == 241 || codigo == 209 || codigo == 32){
				return true;
			}else if(codigo == 225 || codigo == 193 || codigo == 233 || codigo == 201 || codigo == 237 || codigo == 205){
				return true;
			}else if(codigo == 243 || codigo == 211 || codigo == 250 || codigo == 218){
				return true;
			}else{
				return false;
			}
		case "cantHabit":
			if(codigo >= 48 && codigo <= 57){
				return true;
			}else{
				return false;
			}
		case "lugTurist":
			if(codigo >= 65 && codigo <= 90 || codigo >= 97 && codigo <=122 || codigo == 241 || codigo == 209 || codigo == 32){
				return true;
			}else if(codigo == 225 || codigo == 193 || codigo == 233 || codigo == 201 || codigo == 237 || codigo == 205){
				return true;
			}else if(codigo == 243 || codigo == 211 || codigo == 250 || codigo == 218){
				return true;
			}else{
				return false;
			}
		case "hotelmasReserv":
			if(codigo >= 65 && codigo <= 90 || codigo >= 97 && codigo <=122 || codigo == 241 || codigo == 209 || codigo == 32){
				return true;
			}else if(codigo == 225 || codigo == 193 || codigo == 233 || codigo == 201 || codigo == 237 || codigo == 205){
				return true;
			}else if(codigo == 243 || codigo == 211 || codigo == 250 || codigo == 218){
				return true;
			}else{
				return false;
			}
	}
}
function edit(id){
	$.ajax({
			url:"Ciudad?a=getToUpdate&id="+id,
			success: function(result){
				 $("#formCiudad").attr("action","UpdateCiudadInfo?id="+result.id);
				 $("#title").text("Editar ciudad");
				 $("#Forms").modal("show");
				 $("#nombreCiudad").val(result.Nombre);
				 $("#cantHabit").val(result.CantHabitantes);
				 $("#lugTurist").val(result.SitioMasTuristico);
				 $("#hotelmasReserv").val(result.HotelMasReservado);
			}
			
		})
}
function addCiudad(){
	 $("#formCiudad").attr("action","SubmitCiudadInfo");
	 $("#title").text("Formulario ciudad");
	 $("#Forms").modal("show");
	 $("#nombreCiudad").val("");
	 $("#cantHabit").val("");
	 $("#lugTurist").val("");
	 $("#hotelmasReserv").val("");
}