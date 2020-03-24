package test;

import DAO.UtilisateurDao;
import JPA.JpaUtilisateurDao;
import modele.Utilisateur;
import vue.MesAnnonces;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class test_mesAnnonces {
    public static void main(String[] args) throws ParseException {
        UtilisateurDao utilisateurManager = new JpaUtilisateurDao();
        Utilisateur utilisateur = utilisateurManager.find(Utilisateur.class, 1);
        MesAnnonces mesAnnonces = new MesAnnonces(utilisateur);
    }
}
