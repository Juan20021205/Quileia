package com.Quileia.Controller.Ciudades;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Quileia.Model.Bean.ciudadBean;
import com.Quileia.Model.DAO.ciudadDAO;

@WebServlet("/UpdateCiudadInfo")
public class UpdateCiudadInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ciudadBean bean = new ciudadBean();
	ciudadDAO dao = new ciudadDAO();
    
    public UpdateCiudadInfoServlet() {
        super();
    }
    
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		bean.setNombre(req.getParameter("nombreCiudad"));
		bean.setCantHabitantes(Integer.parseInt(req.getParameter("cantHabit")));
		bean.setSitioMasTuristico(req.getParameter("lugTurist"));
		bean.setHotelMasReservado(req.getParameter("hotelmasReserv"));
		bean.setId(Integer.parseInt(req.getParameter("id")));
		
		try {
			dao.update(bean);
			
			resp.sendRedirect("Ciudad?a=list");
			
		} catch (Exception e) {
			System.out.println("Error al actualizar la información");
		}
		
		
		
	}

}
