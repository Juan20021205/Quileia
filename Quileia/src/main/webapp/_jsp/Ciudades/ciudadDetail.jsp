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
        <link rel="stylesheet" href="_css/Ciudades/detailCiudad.css">
    </head>
    <body>
        <div class="container d-flex justify-content-center align-items-center">
            <div id="form" class="row justify-content-md-center ">
                <div class="card" id="card">
                    <form action="UpdateCiudadInfo?id=${ciudad.getId()}" method="post">
                        <div class="card-header">
                            <a href="Ciudad?a=list"><i class="bi bi-arrow-left"></i>Regresar</a>
                        </div>
                        <div class="card-body">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">
                                    <div class="col">
                                        <div class="row mt-2 mb-2">
                                            <div class="col">
                                                <div>
                                                    <label for="nombreCiudad">Ciudad: </label>
                                                </div>
                                                <div>
                                                    <label for="cantHabit">Habitantes: </label>
                                                </div>
                                                <div>
                                                    <label for="lugTurist">Lugar más Turistico: </label>
                                                </div>
                                                <div>
                                                    <label for="hotelmasReserv">Hotel más reservado: </label>
                                                </div>
                                            </div>
                                            <div class="col text-center">
                                                <div>
                                                    <input class="text-center" type="text" name="nombreCiudad" id="nombreCiudad" onkeypress="return keypress(event)" disabled value="${ciudad.getNombre()}">
                                                </div>
                                                <div>
                                                    <input class="text-center mt-4" type="number" name="cantHabit" id="cantHabit" min="1" onkeypress="return keypress(event)" disabled value="${ciudad.getCantHabitantes()}">
                                                </div>
                                                <div>
                                                    <input class="text-center mt-4" type="text" name="lugTurist" id="lugTurist" onkeypress="return keypress(event)" disabled value="${ciudad.getSitioMasTuristico()}">
                                                </div>
                                                <div>
                                                    <input class="text-center mt-4" type="text" name="hotelmasReserv" id="hotelmasReserv" onkeypress="return keypress(event)" disabled value="${ciudad.getHotelMasReservado()}">
                                                </div>
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
        <script type="text/javascript" src="./_js/Ciudades/formularioCiudad.js"></script>
        <script type="text/javascript" src="_js/Ciudades/ciudadDetail.js"></script>
    </body>
    </html>