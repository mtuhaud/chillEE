package chill.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class ConnexionDAO {
	
//    private String url = "jdbc:mysql://localhost:8889/chillEE";
//    private String user = "root";
//    private String passwd = "root";
//    private static Connection connect;
	
	private DataSource dataSource;
	
	public ConnexionDAO() {
//	      try {
//	          connect = DriverManager.getConnection(url, user, passwd);
//	        } catch (SQLException e) {
//	          e.printStackTrace();
//	        } 
		
		try {
			Context envContext = InitialContext.doLookup("java:/comp/env");
			this.dataSource = (DataSource) envContext.lookup("chillEE");
			// this.dataSource = (DataSource) envContext.lookup("DSBDDMyNetflix");
		} catch(NamingException e) {
			throw new DAOException("Echec ici");
		}
	}
	
	protected Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	

	

}
