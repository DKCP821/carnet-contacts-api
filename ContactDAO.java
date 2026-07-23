package project;

import java.sql.Connection ;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException ;


public class ContactDAO {
	private final static String URL = "jdbc:mysql://localhost:3306/carnet_db";
	private final static String USER = "root";
	private final static String PASSWORD = "";
	
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL , USER ,PASSWORD);
	}
	
	public void ajouterContact (Contact contact) {
		String sql ="INSERT INTO  contacts (name , phone_number , email ) VALUES (? , ? , ?)";
		
		try (Connection conn = getConnection();
			PreparedStatement stmt =conn.prepareStatement(sql)){
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getPhoneNumber());
			stmt.setString(3, contact.getEmail());
			
			int rowsInserted = stmt.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("contact ajoute avec succes");
			}
			}catch(SQLException e ) {
				System.out.println("erreur de l'ajout " + e.getMessage());
			}
	}
	
	
	public void listerContact() {
		String sql = "SELECT * FROM contacts";
		
		try (Connection conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery()){
			System.out.println("\n--- LISTES DES CONTACTS ---");
			boolean aucunContact = true ;
			
			while (rs.next()) {
				aucunContact = false ;
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String phoneNumber = rs.getString("phone_number");
				String email = rs.getString("email");
				
				System.out.println("ID :" + id + "| Nom: " + name +" |Tel:" + phoneNumber +"| Email :"+ email);
			}
			if (aucunContact) {
				System.out.println("Aucun contact trouve dans la base de donnee");
			}
		}catch(SQLException e ) {
			System.out.println("erreuur lors de la recuperation des contacts " + e.getMessage());
		}
	
	}
	public void supprimerContact(int id) {
		String sql = "DELETE FROM contacts WHERE id = ?";
		
		try (Connection conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql)){
				
			stmt.setInt(1, id);
			int rowsDeleted = stmt.executeUpdate();
			
				
			if (rowsDeleted > 0) {
				System.out.println("le contact avec l'id "+ id + "a ete supprime");
			}else {
				System.out.println("aucun contact trouve avec l'id " + id );
			}
		}	catch(SQLException e ) {
			System.out.println("erreuur lors de la recuperation des contacts " + e.getMessage());
		}
	}
	
}
