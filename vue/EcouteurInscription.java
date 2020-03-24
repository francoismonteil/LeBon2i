package vue;

import DAO.UtilisateurDao;
import DAO.VilleDao;
import JPA.JpaUtilisateurDao;
import JPA.JpaVilleDao;
import modele.Utilisateur;
import modele.Ville;

import java.text.ParseException;
import java.util.Collection;
import java.util.Date;

public class EcouteurInscription {
    private Inscription i;
    private UtilisateurDao utilisateurManager = new JpaUtilisateurDao();
    private VilleDao villeManager = new JpaVilleDao();

    public void displayVille(){
        Collection<Ville> Villes = villeManager.findAll(Ville.class);
        for (Ville ville: Villes) {
            i.combobox_ville.addItem(ville);
        }
    }

    EcouteurInscription(Inscription i){
        this.i = i;
    }

    public Inscription addUtilisateur(String prenom, String nom, Date date, String adresse, String tel, String mail, String mdp, Ville ville) throws ParseException {
        Utilisateur utilisateur = new Utilisateur(prenom, nom, date, adresse, tel, mail, mdp, 0, ville);
        utilisateurManager.create(utilisateur);
        return i;
    }
}
