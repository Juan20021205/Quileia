package com.Quileia.Controller.Ciudades;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Quileia.Model.Bean.turistaBean;
import com.Quileia.Model.DAO.ciudadDAO;
import com.google.gson.Gson;

@WebServlet("/CiudadHistory")
public class CiudadHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	turistaBean bean = new turistaBean();
	ciudadDAO dao = new ciudadDAO();
   
    public CiudadHistoryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		try {
			List<?> turistas = dao.getHistory(id);
			resp.setContentType("aplication/json");
			
			resp.getWriter().println(new Gson().toJson(turistas));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
