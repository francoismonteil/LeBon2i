package test;

import DAO.AnnonceDao;
import JPA.JpaAnnonceDao;
import modele.Annonce;

public class Test2 {
    public static void main(String[] args) {
        System.out.println("Lancement du test2...");
        System.out.println("Init des modèles...");
        Annonce a = new Annonce();
        AnnonceDao annonceManager = new JpaAnnonceDao();
        annonceManager.create(a);
    }
}
