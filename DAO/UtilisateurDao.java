package DAO;

import modele.Utilisateur;

public interface UtilisateurDao extends Dao<Utilisateur> {
    boolean check(String mail, String mdp);
}
