import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EtudiantDAO dao = new EtudiantDAO();
        int choix = -1;

        while (choix != 0) {
            System.out.println();
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Modifier un étudiant");
            System.out.println("3. Supprimer un étudiant");
            System.out.println("4. Rechercher un étudiant");
            System.out.println("5. Afficher la liste");
            System.out.println("0. Quitter");
            System.out.print("Choix : ");

            try {
                choix = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                choix = -1;
            }

            try {
                switch (choix) {
                    case 1:
                        System.out.print("Numéro : ");
                        String numero = sc.nextLine();
                        System.out.print("Nom : ");
                        String nom = sc.nextLine();
                        System.out.print("Prénom : ");
                        String prenom = sc.nextLine();
                        System.out.print("Email : ");
                        String email = sc.nextLine();
                        dao.ajouter(new Etudiant(numero, nom, prenom, email));
                        System.out.println("Étudiant ajouté.");
                        break;
                    case 2:
                        System.out.print("Numéro de l'étudiant : ");
                        String num = sc.nextLine();
                        System.out.print("Nouveau nom : ");
                        String n = sc.nextLine();
                        System.out.print("Nouveau prénom : ");
                        String p = sc.nextLine();
                        System.out.print("Nouvel email : ");
                        String em = sc.nextLine();
                        if (dao.modifier(num, n, p, em)) {
                            System.out.println("Étudiant modifié.");
                        } else {
                            System.out.println("Étudiant introuvable.");
                        }
                        break;
                    case 3:
                        System.out.print("Numéro de l'étudiant : ");
                        if (dao.supprimer(sc.nextLine())) {
                            System.out.println("Étudiant supprimé.");
                        } else {
                            System.out.println("Étudiant introuvable.");
                        }
                        break;
                    case 4:
                        System.out.print("Nom, prénom ou numéro : ");
                        afficher(dao.rechercher(sc.nextLine()));
                        break;
                    case 5:
                        afficher(dao.lister());
                        break;
                    case 0:
                        System.out.println("Au revoir.");
                        break;
                    default:
                        System.out.println("Choix invalide.");
                }
            } catch (SQLException e) {
                System.out.println("Erreur base de données : " + e.getMessage());
            }
        }
        sc.close();
    }

    private static void afficher(List<Etudiant> liste) {
        if (liste.isEmpty()) {
            System.out.println("Aucun étudiant trouvé.");
            return;
        }
        for (Etudiant e : liste) {
            System.out.println(e);
        }
    }
}
