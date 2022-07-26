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
        <link rel="stylesheet" href="_css/Turistas/detailTurista.css">
    </head>

    <body>
        <div class="container d-flex justify-content-center align-items-center">
            <div id="form" class="row justify-content-md-center ">
                <div class="card" id="card">
                    <form action="UpdateTurista" method="post">
                        <div class="card-header">
                            <a href="Turista?a=list"><i class="bi bi-arrow-left"></i>Regresar</a>
                        </div>
                        <div class="card-body">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">
                                    <div class="col">
                                        <div class="row mt-2 mb-2">
                                            <div class="col">
                                                <div>
                                                    <label for="nombre">Nombre: </label>
                                                </div>
                                                <div>
                                                    <label id="labFechaNac" for="fechaNac" style="margin-bottom: 2em;">Fecha de Nacimiento: </label>
                                                </div>
                                                <div>
                                                    <label for="tipoId">Tipo de Identificacion: </label>
                                                </div>
                                                <div>
                                                    <label id="labIdent" for="NId">Identificacion: </label>
                                                </div>
                                                <div>
                                                    <label for="FrecViaje">Frecuencia de Viaje: </label>
                                                </div>
                                                <div>
                                                    <label for="Presupuesto">Presupuesto de Viaje: </label>
                                                </div>
                                                <div>
                                                    <label for="tarjeta">¿Usa tarjeta?: </label>
                                                </div>
                                            </div>
                                            <div class="col text-center">
                                                <div>
                                                    <input type="text" id="nombre" name="nombre" class="text-center" value="${turista.getNombre()}" disabled>
                                                </div>
                                                <div>
                                                    <input type="date" id="fechaNac" name="fechaNac" class="text-center mt-3 mb-1" value="${turista.getFechaNacimiento()}" disabled onchange="fechaNacim('edit')">
                                                    <div id="FechaNacimiento"></div>
                                                </div>
                                                <div>
                                                    <input type="text" id="tipoId" name="tipoId" class="text-center mt-4" value="${turista.getTipoIdentificacion()}" disabled>
                                                </div>
                                                <div>
                                                    <input type="text" id="NId" name="NId" class="text-center mt-4" value="${turista.getIdentificacion()}" disabled onchange="docIdent('edit')">
                                                    <div id="DocIdentificacion"></div>
                                                </div>
                                                <div>
                                                    <input type="number" id="FrecViaje" name="FrecViaje" class="text-center mt-3" value="${turista.getFrecuenciaViaje()}" disabled>
                                                </div>
                                                <div>
                                                    <input type="number" id="Presupuesto" name="Presupuesto" class="text-center mt-4" value="${turista.getPresupuesto()}" disabled>
                                                </div>
                                                <div>
                                                    <select class="text-center mt-3" name="tarjeta" id="tarjeta" disabled>
														<option value="1" ${turista.getTarjetaCredito()== 1 ? 'selected':''}>Si</option>
														<option value="0" ${turista.getTarjetaCredito()== 0 ? 'selected':''}>No</option>
													</select>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <div class="row mt-2">
                                        <div class="col">
                                            <div>
                                                <label for="destino" class="form-label">Destino: </label>
                                            </div>
                                            <div>
                                                <label for="FechaViaj" class="form-label">Fecha de Viaje: </label>
                                            </div>
                                        </div>
                                        <div class="col text-center">
                                            <div>
                                                <select class="text-center" name="destino" id="destino" disabled onchange="selcDestino()">
                                                	<option value="0" ${turista.getDestino() == 0 ? 'selected':''}>Ninguno</option>
                                                	<c:forEach var="ciudad" items="${ciudades}">
                                                		<option value="${ciudad.getId()}"${turista.getDestino() == ciudad.getId() ? 'selected':''}>${ciudad.getNombre()}</option>
                                                	</c:forEach>
												</select>
                                            </div>
                                            <div>
                                                <input type="date" id="FechaViaj" name="FechaViaj" class="text-center mt-2" value="${turista.getFechaViaje()}" disabled>
                                                <div id="FechaViaje"></div>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div class="card-footer text-end">
                            <button type="button" id="butCancel" class="btn btn-secondary mt-2 mb-2" onclick="cancelEd()">Cancelar</button>
                            <button type="submit" id="butFrm" class="btn btn-primary mt-2 mb-2" onclick="editar(event)">Editar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script type="text/javascript" src="_js/Turistas/turistaDetails.js"></script>
        <script type="text/javascript" src="_js/Turistas/inputsRestrictions.js"></script>
    </body>

    </html>