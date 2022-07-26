package com.Quileia.WS.Implement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Quileia.Model.Bean.ciudadBean;
import com.Quileia.Model.DAO.ciudadDAO;
import com.Quileia.WS.app.CityListServiceProxy;
import com.Quileia.WS.app.CityResponse;
@WebServlet("/WSImplement")
public class WSImplementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ciudadDAO dao = new ciudadDAO();
	
    public WSImplementServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<CityResponse> WSCityList = null;
		List<ciudadBean> BeanCityList = null;
		List<String> CityNames = new ArrayList<String>();
		
		try {
			CityListServiceProxy service = new CityListServiceProxy();
			WSCityList = new ArrayList<CityResponse>(Arrays.asList(service.getCitys()));
			
			BeanCityList = dao.ciudadList();
			
			BeanCityList.forEach((c) -> {
				CityNames.add(c.getNombre());
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (WSCityList != null) {
			if (BeanCityList.size() > 0) {
				
				for (CityResponse WSCity : WSCityList) {
					
					try {
						if (CityNames.contains(WSCity.getNombre())) {
							ciudadBean bean = new ciudadBean();
							
							bean.setCantHabitantes(WSCity.getCantHabitantes());
							bean.setHotelMasReservado(WSCity.getHotelMasReservado());
							bean.setNombre(WSCity.getNombre());
							bean.setSitioMasTuristico(WSCity.getSitioMasTuristico());
							
							dao.WSUpdate(bean);							
						}else {
							ciudadBean bean = new ciudadBean();
							
							bean.setCantHabitantes(WSCity.getCantHabitantes());
							bean.setHotelMasReservado(WSCity.getHotelMasReservado());
							bean.setNombre(WSCity.getNombre());
							bean.setSitioMasTuristico(WSCity.getSitioMasTuristico());
							
							dao.addCity(bean);
						}
					} catch (Exception e) {
						System.out.println("Fallo en consulta");
					}
				}
				
			}
		}
	}

}
