function deleteCiudad(id) {
	let hrf = $("#butDelete").attr("href");
	if(hrf === "Ciudad?a=delete&id="){
		$("#butDelete").attr("href",hrf+id);
	}else{
		hrf = "Ciudad?a=delete&id=";
		$("#butDelete").attr("href",hrf+id);		
	}
	$("#delete").modal("show");
}