package com.Quileia.Controller.Turista;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Quileia.Model.DAO.turistaDAO;

@WebServlet("/InputRestriction")
public class InputRestrictionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	turistaDAO dao = new turistaDAO();
    
    public InputRestrictionServlet() {
        super();
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String place = req.getParameter("pl");
		resp.setContentType("text/html; charset=iso-8859-1");
		PrintWriter out = resp.getWriter();
		
		switch (place) {
		case "ident":
			
			String doc = req.getParameter("documento");
			try {
				int cant = dao.verifyDoc(doc);
				if(cant!=0) {
					out.println("Documento en uso");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			break;
		case "fechViaj":
			
			break;
		}
	}
}
