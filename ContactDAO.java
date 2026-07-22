package project;

import java.sql.Connection ;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
				System.out.println("erreur de l'ajout ");
			}
	}
	
}
