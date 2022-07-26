package com.Quileia.Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Quileia.Model.Bean.ciudadBean;
import com.Quileia.Model.Bean.turistaBean;
import com.Quileia.Utiles.connectionDB;

public class ciudadDAO {
	
	Connection conn;
	PreparedStatement statement;
	ResultSet set;
	String sql;
	int row;
	
	public int addCity(ciudadBean ciudad) throws SQLException {
		
		row = 0;
		sql = "insert into ciudad (Nombre,Cantidad_de_Habitantes,Sitio_mas_Turistico,Hotel_mas_reservado) values (?,?,?,?)";
		
		try {
			
			conn =  connectionDB.getConnection();
			statement = conn.prepareStatement(sql);
			
			statement.setString(1, ciudad.getNombre());
			statement.setInt(2, ciudad.getCantHabitantes());
			statement.setString(3, ciudad.getSitioMasTuristico());
			statement.setString(4, ciudad.getHotelMasReservado());
			
			row = statement.executeUpdate();
			statement.close();
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally {
			conn.close();
		}
		
		return row;
	}
	
	public List<ciudadBean> ciudadList() throws SQLException {
		
		List<ciudadBean> ciudad = new ArrayList<>();
		sql="SELECT * FROM ciudad";
		
		try {
			conn = connectionDB.getConnection(); 
			statement = conn.prepareStatement(sql); 
			set = statement.executeQuery();
			
			while(set.next()) {
				ciudadBean bean = new ciudadBean();
				bean.setId(set.getInt("Id"));
				bean.setNombre(set.getString("Nombre"));
				bean.setCantHabitantes(set.getInt("Cantidad_de_Habitantes"));
				bean.setSitioMasTuristico(set.getString("Sitio_mas_Turistico"));
				bean.setHotelMasReservado(set.getString("Hotel_mas_reservado"));
				
				ciudad.add(bean);
			}
			
			statement.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		
		return ciudad;
	}
	public ciudadBean queryId(int id) throws SQLException {
		
		ciudadBean bean = new ciudadBean();
		sql = "SELECT * FROM ciudad WHERE Id=" + id;
		
		try {
			conn = connectionDB.getConnection();
			statement = conn.prepareStatement(sql); 
			set = statement.executeQuery();
			
			while(set.next()) {
				
				bean.setId(set.getInt("Id"));
				bean.setNombre(set.getString("Nombre"));
				bean.setCantHabitantes(set.getInt("Cantidad_de_Habitantes"));
				bean.setSitioMasTuristico(set.getString("Sitio_mas_Turistico"));
				bean.setHotelMasReservado(set.getString("Hotel_mas_reservado"));
				
			}
			
			statement.close();
			
		}catch(Exception e) {
			System.out.println("Consulta no exitosa de editar" +e.getMessage());
		}
		finally {
			conn.close();
		}
		
		return bean;
	}
	
	public int update(ciudadBean bean) throws SQLException {
		
		row = 0;
		sql = "UPDATE ciudad SET Nombre = ?, Cantidad_de_Habitantes = ?, Sitio_mas_Turistico = ?, "
				+ "Hotel_mas_reservado = ? WHERE Id = ?";
		
		try {
			 conn = connectionDB.getConnection();
			 statement = conn.prepareStatement(sql);
			 statement.setString(1, bean.getNombre());
			 statement.setInt(2, bean.getCantHabitantes());
			 statement.setString(3, bean.getSitioMasTuristico());
			 statement.setString(4, bean.getHotelMasReservado());
			 statement.setInt(5, bean.getId());
			 
			 row = statement.executeUpdate();
			 
			 statement.close();
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		
		return row;
	}
	
	public int deleteHistory(int id) throws SQLException {
		
		row = 0;
		sql = "DELETE FROM historial WHERE IdCiudad =" + id;
		
		try {
			
			conn = connectionDB.getConnection();
			statement = conn.prepareStatement(sql);
			
			row = statement.executeUpdate();
			statement.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		
		return row;
	}
	
	public int delete(int id) throws SQLException{
		
		row = 0;
		sql="DELETE FROM ciudad WHERE Id="+id;
		
		try {
			conn = connectionDB.getConnection();
			statement = conn.prepareStatement(sql);
			
			row = statement.executeUpdate();
			statement.close();
		} catch (Exception e) {
			System.out.println("Error al eliminar el cliente" +e.getMessage());
		}finally {
			conn.close();
		}
		
		return row;
	}
	
	public List<?> getHistory(int ident) throws SQLException{
		
		List<turistaBean> turistas = new ArrayList<>();
		sql = "SELECT t.Nombre, h.Fecha_Viaje FROM historial AS h JOIN turista AS t ON "
				+ "h.Identificacion = t.Identificacion AND h.IdCiudad = ?";
		
		try {
			conn = connectionDB.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setInt(1, ident);
			set = statement.executeQuery();
			while (set.next()) {
				turistaBean bean = new turistaBean();
				bean.setNomDestino(set.getString("Nombre"));
				bean.setFechaViaje(set.getDate("Fecha_Viaje"));
				
				turistas.add(bean);				
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return turistas;
	}
	
	public int WSUpdate(ciudadBean bean) throws SQLException {
		
		row = 0;
		sql = "UPDATE ciudad SET  Cantidad_de_Habitantes = ?, Sitio_mas_Turistico = ?,Hotel_mas_reservado = ? WHERE Nombre = ?";
		
		try {
			conn = connectionDB.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setInt(1, bean.getCantHabitantes());
			statement.setString(2, bean.getSitioMasTuristico());
			statement.setString(3, bean.getHotelMasReservado());
			statement.setString(4, bean.getNombre());
			 
			row = statement.executeUpdate();
			 
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		
		return row;
	}

}
