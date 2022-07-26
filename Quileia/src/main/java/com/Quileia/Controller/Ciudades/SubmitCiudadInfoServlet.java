package com.Quileia.Controller.Ciudades;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Quileia.Model.Bean.ciudadBean;
import com.Quileia.Model.DAO.ciudadDAO;

@WebServlet("/SubmitCiudadInfo")
public class SubmitCiudadInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ciudadDAO dao = new ciudadDAO();
	
    public SubmitCiudadInfoServlet() {
        super();
    }
    
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String Nombre = req.getParameter("nombreCiudad");
		int CantHabitantes = Integer.parseInt(req.getParameter("cantHabit"));
		String SitioMasTuristico = req.getParameter("lugTurist");
		String HotelMasReservado = req.getParameter("hotelmasReserv");
		
		ciudadBean bean = new ciudadBean(Nombre, CantHabitantes, SitioMasTuristico, HotelMasReservado);
		
		try {
			dao.addCity(bean);
			
			req.setAttribute("Action", "add");
			resp.sendRedirect("Ciudad?a=list");
		} catch (Exception e) {
			System.out.println("Error al ingesar la información");
		}
		
	}

}
