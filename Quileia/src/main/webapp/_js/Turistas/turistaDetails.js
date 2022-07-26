function selcDestino(){
	var destino = document.getElementById("destino").value;
	if(destino == 0){
		$('#FechaViaj').prop('disabled', true);
		$('#FechaViaj').css('border-bottom', "none");
		$("#FechaViaj").attr('value','00-00-0000');
	}else{
		$('#FechaViaj').prop('disabled', false);
		$('#FechaViaj').css('border-bottom', "1px solid #8f969c");
	}
	console.log($("#FechaViaj").attr('value'));
}

function editar(e){
	if(document.getElementById('butFrm').textContent == "Editar"){
		document.getElementById('butFrm').textContent = "Guardar";
		if(document.getElementById("destino").value == 0){
			$('#destino, #FrecViaje, #tarjeta, #nombre, #fechaNac, #tipoId, #NId, #Presupuesto').prop('disabled', false);
	    	$('#destino, #FrecViaje, #tarjeta, #nombre, #fechaNac, #tipoId, #NId, #Presupuesto').css('border-bottom', "1px solid #8f969c");			
		}else{
			$('#destino, #FrecViaje, #tarjeta, #nombre, #fechaNac, #tipoId, #NId, #Presupuesto, #FechaViaj').prop('disabled', false);
	    	$('#destino, #FrecViaje, #tarjeta, #nombre, #fechaNac, #tipoId, #NId, #Presupuesto, #FechaViaj').css('border-bottom', "1px solid #8f969c");
		}
    	$('#butCancel').css('display', "inline-block");
    	$('select').css('-moz-appearance', 'auto');
		e.preventDefault();
	}
}

function cancelEd(){
	document.getElementById('butFrm').textContent = 'Editar';
    $('#destino, #tarjeta, #nombre, #fechaNac, #tipoId, #NId, #FrecViaje, #Presupuesto, #FechaViaj').prop('disabled', true);
    $('#destino, #tarjeta, #nombre, #fechaNac, #tipoId, #NId, #FrecViaje, #Presupuesto, #FechaViaj').css('border-bottom', "none");
    $('select').css('-moz-appearance', 'none')
    $('#butCancel').css('display', "none");
    $('#butFrm').attr('type', 'button');
}

function resizeInput() {
    var valueLength = $(this).prop('value').length;
    if (valueLength > 0) {
        $(this).prop('size', valueLength);
    }
}

$('#nombre').on('keyup', resizeInput).each(resizeInput);