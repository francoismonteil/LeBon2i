package test;

import DAO.UtilisateurDao;
import JPA.JpaUtilisateurDao;
import modele.Utilisateur;
import vue.MesAnnonces;

public class test_mesAnnonces {
    public static void main(String[] args) {
        UtilisateurDao utilisateurManager = new JpaUtilisateurDao();
        Utilisateur utilisateur = utilisateurManager.find(Utilisateur.class, 1);
        MesAnnonces mesAnnonces = new MesAnnonces(utilisateur);
    }
}
