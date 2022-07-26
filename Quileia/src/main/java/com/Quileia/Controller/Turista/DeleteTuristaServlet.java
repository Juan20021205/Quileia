package com.Quileia.Controller.Turista;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Quileia.Model.Bean.turistaBean;
import com.Quileia.Model.DAO.turistaDAO;

@WebServlet("/DeleteTurista")
public class DeleteTuristaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	turistaBean bean = new turistaBean();
	turistaDAO dao = new turistaDAO();
    
    public DeleteTuristaServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		bean.setIdentificacion(req.getParameter("id"));
		try {
			dao.deleteHistory(bean.getIdentificacion());
			dao.delete(bean.getIdentificacion());
			resp.sendRedirect("Turista?a=list");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
