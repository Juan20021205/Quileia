package com.Quileia.Model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.Quileia.Model.Bean.turistaBean;
import com.Quileia.Utiles.connectionDB;

public class turistaDAO {

	Connection conn;
	PreparedStatement statement;
	ResultSet set;
	String sql;
	int row;
	
	public int addTurist(turistaBean turista) throws SQLException {
		row = 0;
		sql = "insert into turista (Nombre,Fecha_de_Nacimiento,Identificacion,Tipo_de_Identificacion,Frecuencia_de_Viaje,"
				+ "Presupuesto_de_viaje,Usa_tarjeta_de_credito) values (?,?,?,?,?,?,?)";
		
		try {
			
			conn =  connectionDB.getConnection();
			statement = conn.prepareStatement(sql);
			
			statement.setString(1, turista.getNombre());
			statement.setDate(2, turista.getFechaNacimiento());
			statement.setString(3, turista.getIdentificacion());
			statement.setString(4, turista.getTipoIdentificacion());
			statement.setInt(5, turista.getFrecuenciaViaje());
			statement.setDouble(6, turista.getDestino());
			statement.setInt(7, turista.getTarjetaCredito());
			
			row = statement.executeUpdate();
			statement.close();
			
		} 
		catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			conn.close();
		}
		
		return row;
	}	
	
	public List<?> List() throws SQLException {
		
		List<turistaBean> turista = new ArrayList<>();
		sql="SELECT * FROM turista";
		try {
			conn = connectionDB.getConnection(); 
			statement = conn.prepareStatement(sql); 
			set = statement.executeQuery();
			
			while(set.next()) {
				turistaBean bean = new turistaBean();
				bean.setNombre(set.getString("Nombre"));
				bean.setIdentificacion(set.getString("Identificacion"));
				
				turista.add(bean);
			}
			
			statement.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		
		return turista;
	}
	
	public turistaBean queryIdent(String ident) throws SQLException {
		
		turistaBean bean = new turistaBean();
		sql = "SELECT * FROM turista WHERE Identificacion=?;";
		try {
			conn = connectionDB.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, ident);
			set = statement.executeQuery();
			while(set.next()) {
				
				bean.setNombre(set.getString("Nombre"));
				bean.setFechaNacimiento(set.getDate("Fecha_de_Nacimiento"));
				bean.setIdentificacion(set.getString("Identificacion"));
				bean.setTipoIdentificacion(set.getString("Tipo_de_Identificacion"));
				bean.setFrecuenciaViaje(set.getInt("Frecuencia_de_Viaje"));
				bean.setPresupuesto(set.getDouble("Presupuesto_de_viaje"));
				bean.setTarjetaCredito(set.getInt("Usa_tarjeta_de_credito"));
				bean.setDestino(set.getInt("Destino"));
				bean.setFechaViaje(set.getDate("Fecha_de_viaje"));
			}
			
			statement.close();
			
		}catch(Exception e) {
			System.out.println("Consulta no exitosa de editar " +e.getMessage());
		}
		finally {
			conn.close();
		}
		
		return bean;
	}
	
	public String getDestino(int destino) throws SQLException {
		
		String Destino = "";
		sql = "SELECT Nombre FROM ciudad WHERE Id ="+ destino;
		
		try {
			
			conn = connectionDB.getConnection();
			statement = conn.prepareStatement(sql);
			set = statement.executeQuery();
			
			Destino = set.getString("Nombre");
			
			statement.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		
		
		return Destino;
		
	}
	
	public int update(turistaBean bean) {
		
		int row = 0;
		sql = "UPDATE turista SET Nombre = ?, Tipo_de_Identificacion = ?, "
				+ "Identificacion = ?, Frecuencia_de_Viaje = ?, Usa_tarjeta_de_credito = ?,"
				+ "Destino = ?, Presupuesto_de_viaje = ?, Fecha_de_Nacimiento = ?,"
				+ "Fecha_de_viaje = ? WHERE Identificacion ="+ bean.getIdentificacion();
		
		try {
			 conn = connectionDB.getConnection();
			 statement = conn.prepareStatement(sql);
			 statement.setString(1, bean.getNombre());
			 statement.setString(2, bean.getTipoIdentificacion());
			 statement.setString(3, bean.getIdentificacion());
			 statement.setInt(4, bean.getFrecuenciaViaje());
			 statement.setInt(5, bean.getTarjetaCredito());
			 if (bean.getDestino() == 0) {
				statement.setNull(6, Types.INTEGER);
			} else {
				statement.setInt(6, bean.getDestino());
			}
			 statement.setDouble(7, bean.getPresupuesto());
			 statement.setDate(8, bean.getFechaNacimiento());
			 statement.setDate(9, bean.getFechaViaje());
			
			 
			 row = statement.executeUpdate();
			 
			 statement.close();
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return row;
	}
	
	public int delete(String id) throws SQLException{
		
		sql="DELETE FROM turista WHERE Identificacion="+id;
		
		try {
			conn = connectionDB.getConnection();
			statement = conn.prepareStatement(sql);
			
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error al eliminar el turista" +e.getMessage());
		}
		finally {
			conn.close();
		}
		
		return row;
	}
	
	public int addHisory(String ident, int city, Date fechViaje) throws SQLException {
		
		sql = "INSERT INTO historial (Identificacion,IdCiudad,Fecha_Viaje) VALUES (?,?,?)";
		
		try {
			conn = connectionDB.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, ident);
			statement.setInt(2, city);
			statement.setDate(3, fechViaje);
			
			row = statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Error al agregar fecha al historial" +e.getMessage());
		}finally {
			conn.close();
		}
		
		return row;
	}
	
	public int verifyDoc(String doc) throws SQLException {
		
		sql="SELECT COUNT(*) AS documentos FROM turista WHERE Identificacion = ?";
		try {
			conn = connectionDB.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, doc);
			set = statement.executeQuery();
			while (set.next()) {
				row = set.getInt("documentos");
			}
			
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		
		return row;
	}
	
	public List<?> getHistory(String ident) throws SQLException{
		
		List<turistaBean> ciudades = new ArrayList<>();
		sql = "SELECT c.Nombre, h.Fecha_Viaje FROM historial AS h JOIN ciudad AS c ON h.IdCiudad = c.Id AND h.Identificacion = ?";
		try {
			conn = connectionDB.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, ident);
			set = statement.executeQuery();
			while (set.next()) {
				turistaBean bean = new turistaBean();
				bean.setNomDestino(set.getString("Nombre"));
				bean.setFechaViaje(set.getDate("Fecha_Viaje"));
				
				ciudades.add(bean);				
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return ciudades;
	}
	
	public int deleteHistory(String ident) throws SQLException {
		
		row = 0;
		sql = "DELETE FROM historial WHERE Identificacion =" + ident;
		
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
	
}
