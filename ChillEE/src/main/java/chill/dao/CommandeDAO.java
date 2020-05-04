package chill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import chill.modele.Commande;
import chill.modele.Plat;

public class CommandeDAO extends ConnexionDAO {

	public CommandeDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void insertCommande(Commande commande) {
		String request = "INSERT INTO commande(idboisson, idplat, iddessert, numchambre, datecommande) VALUES (?, ?, ?, ?, ?)";

		try(Connection c = getConnection(); 
			PreparedStatement pstmt = c.prepareStatement(request,Statement.RETURN_GENERATED_KEYS)) {
			pstmt.setInt(1, commande.getBoisson().getIdBoisson());
			pstmt.setInt(2, commande.getPlat().getIdPlat());
			pstmt.setInt(3, commande.getDessert().getIdDessert());
			pstmt.setInt(4, commande.getNumChambre());
			pstmt.setString(5, commande.getDate());
			System.out.println(pstmt);
			int ligneAffectee = pstmt.executeUpdate();
			
	        if (ligneAffectee == 0) {
	            throw new SQLException("Echec de la création de la commande, pas de ligne affectée .");
	        }
	    // Pour recuperer l'id Auto increment dans MySQL    
        try (ResultSet rs = pstmt.getGeneratedKeys()) {
            if (rs.next()) {
                commande.setIdCommande(rs.getInt(1));
            }
            else {
                throw new SQLException("Echec de la création de la commande, pas d'ID obtenu.");
            }
        }       
	        
//			ResultSet rs = pstmt.getGeneratedKeys();
//			rs.next();
//			int idCommande = rs.getInt(1);
//			if (rs.next()) {
//			      System.out.println("clé: " + rs.getString(1));
//			}
		} catch(SQLException e) {
			throw new DAOException("");
		}
	}
	
//	public List<Commande> selectCommande() {
//		try(Connection c = getConnection(); Statement stmt = c.createStatement()) {
//			ResultSet rs = stmt.executeQuery("SELECT idplat, nom, composition FROM plat");
//			List<Plat> plat = new ArrayList<Plat>();
//			while (rs.next()) {
//				plat.add(new Plat(rs.getInt("idplat"), rs.getString("nom"), rs.getString("composition")));
//			}
//			return plat;
//		} catch (SQLException e) {
//			throw new DAOException("");
//		}
//	}
	
	
	public void deleteCommande(int id) {
		String request = "DELETE FROM commande WHERE idcommande = ?";
		
		try(Connection c = getConnection(); 
			PreparedStatement pstmt = c.prepareStatement(request)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			} catch(SQLException e) {
				throw new DAOException("");
			}

	}
	
	

}
