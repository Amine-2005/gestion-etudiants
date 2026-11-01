# Gestion des étudiants

Application console en Java avec une base de données MySQL.

## Fonctionnalités

- Ajouter un étudiant
- Modifier un étudiant
- Supprimer un étudiant
- Rechercher par nom, prénom ou numéro
- Afficher la liste des étudiants

## Technologies

- Java
- MySQL (JDBC)

## Structure du projet

- `Main.java` : menu et interaction avec l'utilisateur
- `Etudiant.java` : classe représentant un étudiant
- `EtudiantDAO.java` : requêtes SQL (ajout, modification, suppression, recherche, liste)
- `DBConnection.java` : connexion à la base de données
- `schema.sql` : création de la base et de la table

## Installation

1. Démarrer MySQL (par exemple avec XAMPP).
2. Exécuter le fichier `schema.sql` (phpMyAdmin ou MySQL Workbench).
3. Télécharger le driver MySQL Connector/J (version Platform Independent) et placer le fichier `.jar` dans un dossier `lib`.
4. Si besoin, modifier l'utilisateur et le mot de passe dans `DBConnection.java`.
5. Lancer `Main.java`.

## Exemple

```
1. Ajouter un étudiant
2. Modifier un étudiant
3. Supprimer un étudiant
4. Rechercher un étudiant
5. Afficher la liste
0. Quitter
Choix :
```
