package test;

import DAO.*;
import JPA.*;
import modele.*;

import javax.rmi.CORBA.Util;
import java.util.Date;

public class InitBdd {
    public static void main(String[] args) {
        System.out.println("Lancement du test2...");
        System.out.println("Crétation des objets Java");

        SurCategorie surCategorie = new SurCategorie(
                "Véhicule"
        );

        Categorie categorie = new Categorie(
                "voiture",
                surCategorie
        );

        Ville ville = new Ville(
                "62300",
                "Lens"
        );

        Utilisateur utilisateur = new Utilisateur(
                "jean",
                "szturemski",
                new Date(),
                "test",
                "test",
                "test",
                "test",
                1,
                ville);

        Annonce a = new Annonce(
                "test",
                "test",
                1,
                "test.png",
                utilisateur,
                categorie,
                ville);

        Critere critere = new Critere(
                "nombre de portes",
                "test",
                categorie
        );

        ValeurPossible valeurPossible = new ValeurPossible(
                -1,
                null,
                critere
        );


        System.out.println("Crétation des manager de persistence");
        AnnonceDao annonceManager = new JpaAnnonceDao();
        AnnoncesHasCriteresDao annoncesHasCriteresManager = new JpaAnnoncesHasCriteresDao();
        CategorieDao categorieManager = new JpaCategorieDao();
        CritereDao critereManager = new JpaCritereDao();
        SurCategorieDao scManager = new JpaSurCategorieDao();
        UtilisateurDao uManager = new JpaUtilisateurDao();
        ValeurPossibleDao vlpManager = new JpaValeurPossibleDao();
        VilleDao villeManager = new JpaVilleDao();
        UtilisateurDao utilisateurManager= new JpaUtilisateurDao();

        System.out.println("Persistence des objets en bdd");
        scManager.create(surCategorie);
        categorieManager.create(categorie);
        villeManager.create(ville);
        utilisateurManager.create(utilisateur);
        annonceManager.create(a);
        critereManager.create(critere);
        vlpManager.create(valeurPossible);

        // Il faut que annonce et critere soit déjà en base
        AnnoncesHasCriteres ahc = new AnnoncesHasCriteres(
                a,
                critere,
                1,
                "test",
                new Date());
        annoncesHasCriteresManager.create(ahc);

    }
}
