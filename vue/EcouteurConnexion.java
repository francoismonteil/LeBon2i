package vue;

import DAO.UtilisateurDao;
import JPA.JpaUtilisateurDao;

public class EcouteurConnexion {

    private UtilisateurDao utilisateurManager = new JpaUtilisateurDao();

    private Connexion c;
    EcouteurConnexion(Connexion c){
        this.c = c;
    }

    public boolean getUtilisateur(String mail, String mdp){
        return utilisateurManager.check(mail,mdp);
    }
}
