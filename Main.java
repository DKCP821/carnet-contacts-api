package project;

public class Main {
   /* public static void main(String[] args) {
        // 1. Instanciation d'un contact
        Contact nouveauContact = new Contact("Peniel", "0102030405", "peniel@test.com");

        // 2. Instanciation du DAO
        ContactDAO dao = new ContactDAO();

        // 3. Appel de la méthode d'ajout
        dao.ajouterContact(nouveauContact);
    }
    
    
    public static void main(String[] args) {
        ContactDAO dao = new ContactDAO();

        // Afficher la liste des contacts
        dao.listerContact();
    }*/
    
    
    public static void main(String[] args) {
        ContactDAO dao = new ContactDAO();

        // 1. On liste avant suppression
        System.out.println("--- Avant suppression ---");
        dao.listerContact();

        // 2. Supprimer le contact qui a l'ID 1 (remplace par un ID existant chez toi)
        dao.supprimerContact(1);

        // 3. On reliste pour verifier que c'est bien parti
        System.out.println("\n--- Apres suppression ---");
        dao.listerContact();
    }
}
