package chill.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import chill.modele.Dessert;

public class DessertDAO extends ConnexionDAO {

	public DessertDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Dessert> selectDessert() {
		try(Connection c = getConnection(); Statement stmt = c.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT iddessert, nom FROM dessert");
			List<Dessert> dessert = new ArrayList<Dessert>();
			while (rs.next()) {
				dessert.add(new Dessert(rs.getInt("iddessert"), rs.getString("nom")));
			}
			return dessert;
		} catch (SQLException e) {
			throw new DAOException("");
		}
	}
	


}
