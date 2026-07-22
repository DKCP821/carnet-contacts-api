package project;

public class Main {
    public static void main(String[] args) {
        // 1. Instanciation d'un contact
        Contact nouveauContact = new Contact("Peniel", "0102030405", "peniel@test.com");

        // 2. Instanciation du DAO
        ContactDAO dao = new ContactDAO();

        // 3. Appel de la méthode d'ajout
        dao.ajouterContact(nouveauContact);
    }
}
