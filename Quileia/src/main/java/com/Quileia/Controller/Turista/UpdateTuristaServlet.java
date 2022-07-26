package com.Quileia.Controller.Turista;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Quileia.Model.Bean.turistaBean;
import com.Quileia.Model.DAO.turistaDAO;

@WebServlet("/UpdateTurista")
public class UpdateTuristaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	turistaBean bean = new turistaBean();
	turistaDAO dao = new turistaDAO();
     
    public UpdateTuristaServlet() {
        super();
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d,dV;
		String nombre = req.getParameter("nombre");
		String tipoId = req.getParameter("tipoId");
		String NumId = req.getParameter("NId");
		int FrecViaj = Integer.parseInt(req.getParameter("FrecViaje"));
		int tarjeta = Integer.parseInt(req.getParameter("tarjeta"));
		int destino = Integer.parseInt(req.getParameter("destino"));
		double presupuesto = Double.parseDouble(req.getParameter("Presupuesto"));
		
		try {
			d = formato.parse(req.getParameter("fechaNac"));
			Date fecha = new Date(d.getTime());
			Date fechaViaje;
			
			if (destino == 0) {
				fechaViaje = null;
			}else {
				dV = formato.parse(req.getParameter("FechaViaj"));
				fechaViaje = new Date(dV.getTime());
			}
			
			bean.setNombre(nombre);
			bean.setTipoIdentificacion(tipoId);
			bean.setIdentificacion(NumId);
			bean.setFrecuenciaViaje(FrecViaj);
			bean.setTarjetaCredito(tarjeta);
			bean.setDestino(destino);
			bean.setPresupuesto(presupuesto);
			bean.setFechaViaje(fechaViaje);
			bean.setFechaNacimiento(fecha);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		dao.update(bean);
		
		resp.sendRedirect("Turista?a=list");
	}

}
