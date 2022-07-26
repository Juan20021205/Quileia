package com.Quileia.Controller.Turista;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Quileia.Model.Bean.turistaBean;
import com.Quileia.Model.DAO.turistaDAO;
import com.google.gson.Gson;

@WebServlet("/TuristaHistory")
public class TuristaHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	turistaDAO dao = new turistaDAO();
	turistaBean bean = new turistaBean();
    
    public TuristaHistoryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			List<?> ciudades = dao.getHistory(req.getParameter("id"));
			resp.setContentType("aplication/json");
			
			resp.getWriter().println(new Gson().toJson(ciudades));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
