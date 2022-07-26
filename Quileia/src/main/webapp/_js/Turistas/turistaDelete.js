const reference ="Turista?a=delete&id=";
function deleteTurist(id){
	var ident = id;
	var ref = $('#butDelete').attr('href');
	if(reference == ref){
		ref = ref + ident;
		$('#butDelete').attr('href',ref)		
	}else{
		ref = reference + ident;
		$('#butDelete').attr('href',ref)
	}
		console.log($('#butDelete').attr('href'));
}