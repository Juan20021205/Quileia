function editar(e){
	if(document.getElementById('butFrm').textContent == "Editar"){
		document.getElementById('butFrm').textContent = "Guardar";
		$('#nombreCiudad, #cantHabit, #lugTurist, #hotelmasReserv').prop('disabled', false);
    	$('#nombreCiudad, #cantHabit, #lugTurist, #hotelmasReserv').css('border-bottom', "1px solid #8f969c");
    	$('#butCancel').css('display', "inline-block");
    	$('select').css('-moz-appearance', 'auto');
		e.preventDefault();
	}
}

function cancelEd(){
	document.getElementById('butFrm').textContent = 'Editar';
    $('#nombreCiudad, #cantHabit, #lugTurist, #hotelmasReserv').prop('disabled', true);
    $('#nombreCiudad, #cantHabit, #lugTurist, #hotelmasReserv').css('border-bottom', "none");
    $('#butCancel').css('display', "none");
    $('#butFrm').attr('type', 'button');
}

function resizeInput() {
    var valueLength = $(this).prop('value').length;
    if (valueLength > 0) {
        $(this).prop('size', valueLength);
    }
}

$('#nombreCiudad').on('keyup', resizeInput).each(resizeInput);