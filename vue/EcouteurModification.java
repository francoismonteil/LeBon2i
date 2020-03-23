package vue;

import DAO.*;
import JPA.*;
import modele.*;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

public class EcouteurModification extends Thread {
    private Modification a;
    // Instanciation du manager
    private SurCategorieDao surCategorieManager = new JpaSurCategorieDao();
    private CategorieDao categorieManager = new JpaCategorieDao();
    private CritereDao critereManager = new JpaCritereDao();
    private ValeurPossibleDao vpManager = new JpaValeurPossibleDao();
    private AnnonceDao annonceManager = new JpaAnnonceDao();
    private AnnoncesHasCriteresDao ahcManager = new JpaAnnoncesHasCriteresDao();

    private ArrayList<Critere> crits = new ArrayList<Critere>();
    private ArrayList<Object> valeurs = new ArrayList<Object>();

    private Annonce annonce;

    EcouteurModification(Modification a, Annonce annonce){
        this.a = a;
        this.annonce = annonce;
    }

    public void displaySurCategorie(int init){
        //Toutes les sur catégorie
        Collection<SurCategorie> surCategories = surCategorieManager.findAll(SurCategorie.class);
        for (SurCategorie surCat: surCategories) {
            a.combobox_surcategorie.addItem(surCat);
        }

        if (init == 1) {
            //Sur catégorie de l'annonce
            SurCategorie surCategorieA = this.annonce.getCategorie().getSurCategorie();
            a.combobox_surcategorie.setSelectedItem(surCategorieA);
        }
    }

    public void displayCategories(SurCategorie surCat, int init){
        a.combobox_categorie.removeAllItems();
        if(surCat != null) {
            Collection<Categorie> categories = categorieManager.findBySurCategorie(surCat.getIdSurCategories());
            for (Categorie cat : categories) {
                a.combobox_categorie.addItem(cat);
            }
            System.out.println("On affiche les catégorie " + categories.toString());
            if(init == 1) {
                a.combobox_categorie.setSelectedItem(this.annonce.getCategorie());
                System.out.println("On selectionne la catégorie de l'annonce : " + this.annonce.getCategorie());
            }
        }
    }

    public void displayCriteres(Categorie cat){
        a.zoneCrit.removeAll();
        crits.clear();
        valeurs.clear();
        if(cat != null) {
            Collection<Critere> criteres = critereManager.findByCategorie(cat.getIdCategories());
            if (criteres != null) {
                JLabel label_critere;
                for (Critere crit : criteres) {
                    label_critere = new JLabel(crit.getLabel());
                    label_critere.setPreferredSize(new Dimension(150, 30));
                    a.zoneCrit.add(label_critere);
                    crits.add(crit);
                    switch(crit.getType()){
                        case "ComboBox":
                            JComboBox<ValeurPossible> vpc = new JComboBox<ValeurPossible>();
                            vpc.setPreferredSize(new Dimension(250,30));
                            Collection<ValeurPossible> vps = vpManager.findByCritere(crit.getIdCriteres());
                            for (ValeurPossible vp:vps) {
                                vpc.addItem(vp);
                            }
                            if(cat == this.annonce.getCategorie()){
                                Collection<AnnoncesHasCriteres> ahcs = ahcManager.findByAnnonce(this.annonce.getIdAnnonces());
                                for (AnnoncesHasCriteres ahc:ahcs) {
                                    if(ahc.getCriteres() == crit){
                                        vpc.setSelectedItem(ahc);
                                    }
                                }
                            }
                            a.zoneCrit.add(vpc);
                            valeurs.add(vpc);
                            break;
                        default:
                            JTextField vpd = new JTextField();
                            vpd.setPreferredSize(new Dimension(250,30));
                            a.zoneCrit.add(vpd);
                            valeurs.add(vpd);
                            break;
                    }
                }

                System.out.println("On affiche les critères " + criteres.toString() + " de la catégorie " + cat.toString());
            }
        }
    }

    public Annonce addAnnonce(String titre, String description, float prix, String image, Utilisateur utilisateur, Categorie categorie, Ville ville) throws ParseException {
        Annonce annonce = new Annonce(titre, description, prix, image, utilisateur, categorie, ville);
        annonceManager.create(annonce);
        for(int ite=0;ite<crits.size();ite++){
            if(crits.get(ite).getType().equals("int")){
                JTextField value = (JTextField)valeurs.get(ite);
                float valueInt = Float.parseFloat(value.getText());
                AnnoncesHasCriteres ahc = new AnnoncesHasCriteres(annonce, crits.get(ite), valueInt);
                ahcManager.create(ahc);
            }else if(crits.get(ite).getType().equals("ComboBox")){
                JComboBox<ValeurPossible> value = (JComboBox<ValeurPossible>)valeurs.get(ite);
                ValeurPossible valueVp = (ValeurPossible)value.getSelectedItem();
                String valueString = Objects.requireNonNull(value.getSelectedItem()).toString();
                AnnoncesHasCriteres ahc = new AnnoncesHasCriteres(annonce, crits.get(ite), valueString);
                ahcManager.create(ahc);
            }else if(crits.get(ite).getType().equals("date")){
                JTextField value = (JTextField)valeurs.get(ite);
                Date valueDate = new SimpleDateFormat("dd/MM/yyyy").parse(value.getText());
                AnnoncesHasCriteres ahc = new AnnoncesHasCriteres(annonce, crits.get(ite), valueDate);
                ahcManager.create(ahc);
            }
        }
        return annonce;
    }
}
