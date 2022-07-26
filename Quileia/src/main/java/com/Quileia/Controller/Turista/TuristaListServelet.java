package com.Quileia.Controller.Turista;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Quileia.Model.DAO.turistaDAO;

@WebServlet("/TuristaList")
public class TuristaListServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	turistaDAO dao = new turistaDAO();
    
    public TuristaListServelet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			List<?> turistas = dao.List();
			req.setAttribute("turistas", turistas);
			req.setAttribute("localizacion", "turista");
			req.getRequestDispatcher("/_jsp/header.jsp").forward(req, resp);
			
		} catch (Exception e) {
			System.out.println("Turistas no encontrados"+e.getMessage());
		}
	}

}
