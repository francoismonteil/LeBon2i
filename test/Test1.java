package test;

import DAO.AnnoncesHasCriteresDao;
import DAO.CategorieDao;
import DAO.CritereDao;
import DAO.ValeurPossibleDao;
import JPA.JpaAnnoncesHasCriteresDao;
import JPA.JpaCategorieDao;
import JPA.JpaCritereDao;
import JPA.JpaValeurPossibleDao;
import modele.AnnoncesHasCriteres;
import modele.Categorie;
import modele.Critere;
import modele.ValeurPossible;

import java.util.Collection;

public class Test1 {
    public static void main(String[] args) {

        System.out.println("Coucou");

        // Instanciation du manager
        CategorieDao categorieManager = new JpaCategorieDao();

        // 1/ Récupérer toutes les catégories
        Collection<Categorie> categories = categorieManager.findAll(new Categorie().getClass());

        categories.forEach(categorie -> {
            System.out.println(categorie.getIdCategories());
        });
        // fin 1/

        // 2/ Récupération d'une catégorie par id
        Categorie categorie2 = categorieManager.find(new Categorie().getClass(), 1);

        //System.out.println(categorie2.getLabel());
        //System.out.println(categorie2.getSurCategorie().getLabel());
        // fin 2/

        // Instanciation du manager
        CritereDao critereManager = new JpaCritereDao();

        // 3/ Récupération de critères par catégorie
        Collection criteres = critereManager.findByCategorie(1);

        criteres.forEach(c -> {
            // je sais pas pq il faut cast en Critere mais il faut cast
            Critere critere2 = (Critere) c;
            //System.out.println(critere2.getLabel());
        });// fin 3/

        // Instanciation du manager
        ValeurPossibleDao vpManager = new JpaValeurPossibleDao();

        // 4/ Récupération des valeurs possibles par critere
        Collection<ValeurPossible> vps = vpManager.findByCritere(2);

        vps.forEach(vp -> {
            ValeurPossible vp2 = (ValeurPossible) vp;
            System.out.println(vp2.getIdValeursPossibles());
            System.out.println(vp2.getValeurInt());
            System.out.println(vp2.getValeurText());
        });// fin 4/

        // 5/ Récupération des annonceshascritere par annonces
        AnnoncesHasCriteresDao ahcManager = new JpaAnnoncesHasCriteresDao();

        Collection<AnnoncesHasCriteres> ahcs = ahcManager.findByAnnonce(4);

        //Collection<AnnoncesHasCriteres> ahcs = ahcManager.findAll(new AnnoncesHasCriteres().getClass());

        ahcs.forEach(annoncesHasCriteres -> {
            AnnoncesHasCriteres annoncesHasCriteres2 = (AnnoncesHasCriteres) annoncesHasCriteres;
            System.out.println(annoncesHasCriteres2.getAnnonces().getTitre());
        });// fin 5/
    }
}
