package com.Quileia.Model.Bean;

public class ciudadBean {

	String Nombre;
	String SitioMasTuristico;
	String HotelMasReservado;
	int CantHabitantes;
	int id;
	
	public ciudadBean() {
		super();
	}

	public ciudadBean(String nombre, int cantHabitantes, String sitioMasTuristico, String hotelMasReservado) {
		super();
		Nombre = nombre;
		CantHabitantes = cantHabitantes;
		SitioMasTuristico = sitioMasTuristico;
		HotelMasReservado = hotelMasReservado;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getCantHabitantes() {
		return CantHabitantes;
	}

	public void setCantHabitantes(int cantHabitantes) {
		CantHabitantes = cantHabitantes;
	}

	public String getSitioMasTuristico() {
		return SitioMasTuristico;
	}

	public void setSitioMasTuristico(String sitioMasTuristico) {
		SitioMasTuristico = sitioMasTuristico;
	}

	public String getHotelMasReservado() {
		return HotelMasReservado;
	}

	public void setHotelMasReservado(String hotelMasReservado) {
		HotelMasReservado = hotelMasReservado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
