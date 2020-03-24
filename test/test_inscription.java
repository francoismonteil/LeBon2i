package test;

import vue.Connexion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class test_inscription {
<<<<<<< HEAD
    public static void main(String[] args) {
        //UtilisateurDao utilisateurManager = new JpaUtilisateurDao();
        //Utilisateur utilisateur = utilisateurManager.find(Utilisateur.class, 1);
        Connexion fenetre = new Connexion();
=======
    public static void main(String[] args) throws ParseException {
        UtilisateurDao utilisateurManager = new JpaUtilisateurDao();
        Utilisateur utilisateur = utilisateurManager.find(Utilisateur.class, 1);
        MesAnnonces mesAnnonces = new MesAnnonces(utilisateur);
>>>>>>> 7409c46399d2b721f6f24583d95929991c65b3d5
    }
}
