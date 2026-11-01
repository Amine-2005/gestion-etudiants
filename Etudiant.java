public class Etudiant {
    private int id;
    private String numero;
    private String nom;
    private String prenom;
    private String email;

    public Etudiant(int id, String numero, String nom, String prenom, String email) {
        this.id = id;
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public Etudiant(String numero, String nom, String prenom, String email) {
        this(0, numero, nom, prenom, email);
    }

    public int getId() { return id; }
    public String getNumero() { return numero; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getEmail() { return email; }

    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return id + " | " + numero + " | " + nom + " " + prenom + " | " + email;
    }
}
