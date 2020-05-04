package chill.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import chill.modele.Plat;

public class PlatDAO extends ConnexionDAO {

	public PlatDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Plat> selectPlat() {
		try(Connection c = getConnection(); Statement stmt = c.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT idplat, nom, composition FROM plat");
			List<Plat> plat = new ArrayList<Plat>();
			while (rs.next()) {
				plat.add(new Plat(rs.getInt("idplat"), rs.getString("nom"), rs.getString("composition")));
			}
			return plat;
		} catch (SQLException e) {
			throw new DAOException("");
		}
	}
	


}
