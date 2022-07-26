package com.Quileia.Controller.Turista;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Quileia.Model.Bean.ciudadBean;
import com.Quileia.Model.Bean.turistaBean;
import com.Quileia.Model.DAO.ciudadDAO;
import com.Quileia.Model.DAO.turistaDAO;

@WebServlet("/LoadUpdateTuristaData")
public class LoadUpdateTuristaDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	turistaBean bean = new turistaBean();
	ciudadBean ciuBean = new ciudadBean();
	turistaDAO dao = new turistaDAO();
	ciudadDAO ciuDao = new ciudadDAO();
    
    public LoadUpdateTuristaDataServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		LocalDate localDate = LocalDate.now();
		ZoneId systemTimeZone = ZoneId.systemDefault();
		ZonedDateTime zoneDateTime = localDate.atStartOfDay(systemTimeZone);
		Date todayDate = Date.from(zoneDateTime.toInstant());
		
		try {
			
			bean = dao.queryIdent(id);
			List<?> ciudades  = ciuDao.ciudadList();
			if (bean.getFechaViaje() != null) {
				if (bean.getFechaViaje().before(todayDate) ) {
					
					dao.addHisory(bean.getIdentificacion(), bean.getDestino(),bean.getFechaViaje());
					
					bean.setDestino(0);
					bean.setFechaViaje(null);
					
					dao.update(bean);
					
				}				
			}
			req.setAttribute("turista", bean);
			req.setAttribute("ciudades", ciudades);
			req.getRequestDispatcher("/_jsp/Turistas/turistaDetail.jsp").forward(req, resp);
			
			
		} catch (Exception e) {
			System.out.println("No existe información de ese turista");
		}
		
	}

}
