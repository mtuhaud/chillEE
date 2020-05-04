package chill.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import chill.modele.Boisson;




public class BoissonDAO extends ConnexionDAO {

	public BoissonDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Boisson> selectBoisson() {
		try(Connection c = getConnection(); 
			Statement stmt = c.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT idboisson, nom FROM boisson");
			List<Boisson> boisson = new ArrayList<Boisson>();
			while (rs.next()) {
				boisson.add(new Boisson(rs.getInt("idboisson"), rs.getString("nom")));
			}
			return boisson;
		} catch (SQLException e) {
			throw new DAOException("");
		}
	}
	
//	public List<Boisson> selectStatut(int idboisson) {
//		try(Connection c = getConnection(); Statement stmt = c.createStatement()) {
//			ResultSet rs = stmt.executeQuery("SELECT idboisson, nom FROM boisson WHERE idboisson=" + idboisson);
//			List<Boisson> boisson = new ArrayList<Boisson>();
//			while (rs.next()) {
//				boisson.add(new Boisson(idboisson, rs.getString("nom")));
//			}
//			return boisson;
//		} catch(SQLException e) {
//			throw new DAOException("");
//		}
//	}

}
