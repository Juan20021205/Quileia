package com.Quileia.Controller.Ciudades;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ciudad")
public class CiudadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CiudadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getParameter("a");
		
		switch (action) {
		case "WSimpl":
				resp.sendRedirect("WSImplement");
			break;
		case "list":
				resp.sendRedirect("CiudadList");
			break;
		case "getToUpdate":
				req.getRequestDispatcher("LoadUpdateData").forward(req, resp);
			break;
		case "delete":
				req.getRequestDispatcher("DeleteCiudad").forward(req, resp);
			break;
		case "history":
				req.getRequestDispatcher("CiudadHistory").forward(req, resp);
			break;
		default:
				resp.sendRedirect("index.jsp");
			break;
		}
		
	}

}
