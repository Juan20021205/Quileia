package com.Quileia.Model.Bean;

import java.sql.Date;

public class turistaBean {

	Date FechaNacimiento;
	Date FechaViaje;
	String Nombre;
	String Identificacion;
	String TipoIdentificacion;
	String NomDestino;
	Double Presupuesto;
	int FrecuenciaViaje;
	int Destino;
	int TarjetaCredito;

	public turistaBean() {
		super();
	}

	public turistaBean(String nombre, Date fechaNacimiento, String identificacion, String tipoIdentificacion,
			int frecuenciaViaje, Double presupuesto, int destino, int tarjetaCredito) {
		super();
		Nombre = nombre;
		FechaNacimiento = fechaNacimiento;
		Identificacion = identificacion;
		TipoIdentificacion = tipoIdentificacion;
		FrecuenciaViaje = frecuenciaViaje;
		Presupuesto = presupuesto;
		Destino = destino;
		TarjetaCredito = tarjetaCredito;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	public Date getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}

	public String getIdentificacion() {
		return Identificacion;
	}

	public void setIdentificacion(String identificacion) {
		Identificacion = identificacion;
	}

	public String getTipoIdentificacion() {
		return TipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		TipoIdentificacion = tipoIdentificacion;
	}

	public int getFrecuenciaViaje() {
		return FrecuenciaViaje;
	}

	public void setFrecuenciaViaje(int frecuenciaViaje) {
		FrecuenciaViaje = frecuenciaViaje;
	}

	public Double getPresupuesto() {
		return Presupuesto;
	}

	public void setPresupuesto(Double presupuesto) {
		Presupuesto = presupuesto;
	}

	public int getDestino() {
		return Destino;
	}

	public void setDestino(int destino) {
		Destino = destino;
	}

	public int getTarjetaCredito() {
		return TarjetaCredito;
	}

	public void setTarjetaCredito(int tarjetaCredito) {
		TarjetaCredito = tarjetaCredito;
	}

	public String getNomDestino() {
		return NomDestino;
	}

	public void setNomDestino(String nomDestino) {
		NomDestino = nomDestino;
	}

	public Date getFechaViaje() {
		return FechaViaje;
	}

	public void setFechaViaje(Date fechaViaje) {
		FechaViaje = fechaViaje;
	}
}
