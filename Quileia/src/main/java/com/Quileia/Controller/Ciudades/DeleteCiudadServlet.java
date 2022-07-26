package com.Quileia.Controller.Ciudades;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Quileia.Model.Bean.ciudadBean;
import com.Quileia.Model.DAO.ciudadDAO;

@WebServlet("/DeleteCiudad")
public class DeleteCiudadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ciudadBean bean = new ciudadBean();
	ciudadDAO dao = new ciudadDAO();
	
    public DeleteCiudadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		bean.setId(Integer.parseInt(req.getParameter("id")));
		
		try {
			dao.deleteHistory(bean.getId());
			dao.delete(bean.getId());
			resp.sendRedirect("Ciudad?a=list");
			
		} catch (Exception e) {
			System.out.println("Error al eliminar la informaci�n");
		}
		
	}

}
