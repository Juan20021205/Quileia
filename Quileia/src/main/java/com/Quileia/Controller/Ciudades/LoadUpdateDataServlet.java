package com.Quileia.Controller.Ciudades;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Quileia.Model.Bean.ciudadBean;
import com.Quileia.Model.DAO.ciudadDAO;

@WebServlet("/LoadUpdateData")
public class LoadUpdateDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ciudadBean bean = new ciudadBean();
	ciudadDAO dao = new ciudadDAO();
	
    public LoadUpdateDataServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		bean.setId(Integer.parseInt(req.getParameter("id")));
		try {
			
			bean = dao.queryId(bean.getId());
			
			req.setAttribute("ciudad", bean);
			req.getRequestDispatcher("/_jsp/Ciudades/ciudadDetail.jsp").forward(req, resp);
			
		} catch (Exception e) {
			System.out.println("No existe información de esa ciudad");
		}
	}

}
