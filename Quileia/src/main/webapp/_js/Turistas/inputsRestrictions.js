function fechaNacim(place){
	let date = new Date();
	var validarFechaNac = document.getElementById("FechaNacimiento");
	var nacimiento = document.getElementById("fechaNac").value;
	nacimiento = new Date(nacimiento);
	let bornDate = ((nacimiento.getDate() + 1)+ "-" + nacimiento.getMonth() + "-" + nacimiento.getFullYear());
	let todayDate = (date.getDate() + "-" + date.getMonth() + "-" + date.getFullYear());
	console.log(bornDate < todayDate);
	console.log(bornDate , todayDate);
	if(nacimiento > "01-01-0001"  && nacimiento != ""){
		validarFechaNac.className = "";
		
		$('#FechaNacimiento').html("");
		$('#FechaNacimiento').css('padding','0');
		if(place == "edit"){
			$('#labFechaNac').css('margin-bottom','2em');			
		}else{
			console.log(place);
		}
	}else{
		validarFechaNac.className = "alert alert-danger";
		$('#FechaNacimiento').html("Fecha incorrecta");
		$('#FechaNacimiento').css('padding','3px');
		if(place == "edit"){
			$('#FechaNacimiento').css('margin','0');
			$('#labFechaNac').css('margin-bottom','4em')			
		}else{
			console.log(place);
		}
	}
}

function docIdent(place){
	const documento = document.getElementById("NId").value;
	var validarDoc = document.getElementById("DocIdentificacion");
	$.ajax({
		url:"Turista?a=restrictions&pl=ident",
		data:{
			documento:documento
		},
		success: function(result){
			if(result ===""){
				validarDoc.className="";
				$("#DocIdentificacion").html(result);
				if(place == "edit"){
					$('#labIdent').css('margin-bottom','1.5em')			
				}else{
					console.log(place);
				}
			}else{
				validarDoc.className="alert alert-danger";
				$("#DocIdentificacion").html(result);
				$('#DocIdentificacion').css('padding','3px');
				if(place == "edit"){
					$('#DocIdentificacion').css('margin','0');
					$('#labIdent').css('margin-bottom','4em')			
				}else{
					console.log(place);
				}
			}		
		}			
	})		
}
	/*function stopDefAction(e) {
    	var validar = $("#validarC").attr('class')
    	var validarDocumento = $("#validarD").attr('class')
 	    if(validar !== "" || validarDocumento !== "" ) {
 	    	console.log();
 	    	 e.preventDefault();
 	    }
    	}*/