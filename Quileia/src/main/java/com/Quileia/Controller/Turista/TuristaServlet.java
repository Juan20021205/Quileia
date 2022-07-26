package com.Quileia.Controller.Turista;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Turista")
public class TuristaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TuristaServlet() {
        super();
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("a");
		
		switch (action) {
		case "list":
				resp.sendRedirect("TuristaList");
			break;
		case "getToUpdate":
				req.getRequestDispatcher("LoadUpdateTuristaData").forward(req, resp);
			break;
		case "delete":
				req.getRequestDispatcher("DeleteTurista").forward(req, resp);
			break;
		case "restrictions":
				req.getRequestDispatcher("InputRestriction").forward(req, resp);
			break;
		case "history":
				req.getRequestDispatcher("TuristaHistory").forward(req, resp);
			break;
		default:
			resp.sendRedirect("index.jsp");
			break;
		}
	}
}
