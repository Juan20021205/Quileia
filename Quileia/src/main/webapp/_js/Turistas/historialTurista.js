function turistaHistory(id){
	$.ajax({
		url:"Turista?a=history&id="+id,
		success: function(result){
			if(result.length == 0){
				$('#nonData').css('display','');
				$('#hedHistory').css('display','none');
			}else{
				$('#hedHistory').css('display','');
				$('#nonData').css('display','none');
				let filas = $('#history').find('tbody tr').length;
				if(filas == 0){
					result.forEach((datos)=>{
					var tbody = document.getElementById("bodHist");
					let row = document.createElement('tr');
					let destino = document.createElement('td');
					let fecha = document.createElement('td');
					destino.innerHTML = datos.NomDestino
					fecha.innerHTML = datos.FechaViaje
					
					row.appendChild(destino);
					row.appendChild(fecha);
					
					tbody.appendChild(row);
					})
				}				
			}
			
		}			
	})
	$("#history").modal("show");	
}
$("#history").on("hidden.bs.modal", function () {
    $('#bodHist').children().remove();
});