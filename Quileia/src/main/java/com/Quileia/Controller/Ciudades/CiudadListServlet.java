package com.Quileia.Controller.Ciudades;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Quileia.Model.DAO.ciudadDAO;

@WebServlet("/CiudadList")
public class CiudadListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ciudadDAO dao = new ciudadDAO();
    
    public CiudadListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			List<?> ciudades = dao.ciudadList();
			req.setAttribute("ciudades", ciudades);
			req.setAttribute("localizacion", "ciudad");
			req.setAttribute("Action", "add");
			req.getRequestDispatcher("/_jsp/header.jsp").forward(req, resp);
			
		} catch (Exception e) {
			System.out.println("Ciudades no encontrados"+e.getMessage());
		}
	}
}
