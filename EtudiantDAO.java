import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDAO {

    public void ajouter(Etudiant e) throws SQLException {
        String sql = "INSERT INTO etudiant (numero, nom, prenom, email) VALUES (?, ?, ?, ?)";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, e.getNumero());
            ps.setString(2, e.getNom());
            ps.setString(3, e.getPrenom());
            ps.setString(4, e.getEmail());
            ps.executeUpdate();
        }
    }

    public boolean modifier(String numero, String nom, String prenom, String email) throws SQLException {
        String sql = "UPDATE etudiant SET nom = ?, prenom = ?, email = ? WHERE numero = ?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setString(3, email);
            ps.setString(4, numero);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean supprimer(String numero) throws SQLException {
        String sql = "DELETE FROM etudiant WHERE numero = ?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, numero);
            return ps.executeUpdate() > 0;
        }
    }

    public List<Etudiant> lister() throws SQLException {
        String sql = "SELECT * FROM etudiant ORDER BY nom";
        List<Etudiant> liste = new ArrayList<>();
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                liste.add(creer(rs));
            }
        }
        return liste;
    }

    public List<Etudiant> rechercher(String mot) throws SQLException {
        String sql = "SELECT * FROM etudiant WHERE nom LIKE ? OR prenom LIKE ? OR numero = ?";
        List<Etudiant> liste = new ArrayList<>();
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, "%" + mot + "%");
            ps.setString(2, "%" + mot + "%");
            ps.setString(3, mot);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    liste.add(creer(rs));
                }
            }
        }
        return liste;
    }

    private Etudiant creer(ResultSet rs) throws SQLException {
        return new Etudiant(
            rs.getInt("id"),
            rs.getString("numero"),
            rs.getString("nom"),
            rs.getString("prenom"),
            rs.getString("email")
        );
    }
}
