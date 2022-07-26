<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Quileia</title>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.3/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.2/font/bootstrap-icons.css">
	</head>
	<body style="background: #e1dfdf;">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container-fluid">
				<div class="collapse navbar-collapse" id="navbarScroll">
					<ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" >
						<li class="nav-item">
							<a class="nav-link active" aria-current="page" href="Turista?a=list">Turistas</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="Ciudad?a=list">Ciudades</a>
						</li>
					</ul>
				</div>
			</div>
		</nav>
		<div class="container">
			<h4 class="mt-3">Tabla de ${localizacion}</h4>
			<button class="btn btn-dark mt-2 mb-3" data-bs-toggle="modal" onclick="${localizacion eq 'turista' ? 'addTurista()' : 'addCiudad()'}">Agregar</button>	
			<%		
      			if(request.getAttribute("localizacion") == "turista"){
      		 %>
			<%@include file="./Turistas/turistaTable.jsp" %>		
			<%	}else{ %>	
				<%@include file="./Ciudades/ciudadTable.jsp" %>
				
			<%	} %>
			<div class="modal fade" id="Forms" aria-hidden="true" aria-labelledby="exampleModalToggleLabel" tabindex="-1">
				<div class="modal-dialog modal-dialog-centered">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="title" >Formulario ${localizacion}</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
						</div>
      					<%
      						if(request.getAttribute("localizacion")  == "turista"){
      					 %>
						 			<%@include file="./Turistas/turistaForm.jsp" %>		
						<%	}else{ %>
				
									<%@include file="./Ciudades/ciudadForm.jsp" %>
				
						<%	} %>
					</div>
				</div>
			</div>			
			<div class="modal fade" id="delete" aria-hidden="true" aria-labelledby="exampleModalToggleLabel" tabindex="-1">
				<div class="modal-dialog modal-dialog-centered">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="title" >Eliminar ${localizacion}</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
						</div>
						<div class="modal-body">
				        	<p>¿Desea eliminar ${localizacion eq "ciudad"? "esta ciudad?" : "este turista?" }</p>
				        </div>
				        <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
					        <a id="butDelete" class="btn btn-danger" href="${localizacion eq 'ciudad'? 'Ciudad?a=delete&id=':'Turista?a=delete&id=' }">Eliminar</a>
				        </div>
					</div>
				</div>
			</div>
			<div class="modal fade" id="history" aria-hidden="true" aria-labelledby="exampleModalToggleLabel" tabindex="-1">
				<div class="modal-dialog modal-dialog-centered">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="title" >Historial ${localizacion}</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
						</div>
						<div class="modal-body">
				        	<table class="table table-striped">
								<thead>
									<tr id="nonData" style="display: none;">
										<th scope="col">No existe ningun registro</th>
									</tr>
									<tr id="hedHistory" style="display: none">
										<th scope="col">${localizacion eq "ciudad" ? 'Turista' : 'Ciudad'}</th>
										<th scope="col">Fecha del Viaje</th>
									</tr>
								</thead>
								<tbody id="bodHist">
								</tbody>
							</table>
				        </div>
					</div>
				</div>
			</div>
		</div>
		<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<script type="text/javascript" src="./_js/Ciudades/formularioCiudad.js"></script>
		<script type="text/javascript" src="./_js/Ciudades/eliminarCiudad.js"></script>
		<script type="text/javascript" src="./_js/Ciudades/ciudadHistory.js"></script>
		<script type="text/javascript" src="./_js/Turistas/formularioTurista.js"></script>
		<script type="text/javascript" src="./_js/Turistas/turistaDelete.js"></script>
		<script type="text/javascript" src="_js/Turistas/inputsRestrictions.js"></script>
		<script type="text/javascript" src="_js/Turistas/historialTurista.js"></script>
		
	</body>
</html>