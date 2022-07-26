package com.Quileia.Controller.Turista;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Quileia.Model.Bean.turistaBean;
import com.Quileia.Model.DAO.turistaDAO;

@WebServlet("/SubmitTuristaInfo")
public class SubmitTuristaInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	turistaDAO dao = new turistaDAO();
    
    public SubmitTuristaInfoServlet() {
        super();
    }
    
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			
			java.util.Date d = formato.parse(req.getParameter("fechaNac"));
			
			String nombre = req.getParameter("nombre");
			String tipoId = req.getParameter("tipoId");
			String identificacion = req.getParameter("NId");
			int tarjeta = Integer.parseInt(req.getParameter("tarjeta"));
			int frecViaje = Integer.parseInt(req.getParameter("FrecViaje"));
			double presupuesto = Double.parseDouble(req.getParameter("Presupuesto"));
			Date fecha = new Date(d.getTime());
			
			turistaBean bean = new turistaBean(nombre, fecha, identificacion, tipoId, frecViaje, presupuesto, 0, tarjeta);
			
			dao.addTurist(bean);
			
			resp.sendRedirect("Turista?a=list");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
