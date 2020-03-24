package JPA;

import DAO.UtilisateurDao;
import modele.Utilisateur;
import org.hibernate.Session;

import java.util.Collection;

public class JpaUtilisateurDao extends JpaDao<Utilisateur> implements UtilisateurDao {
    private Class classUtilisateur = new Utilisateur().getClass();

    @Override
    public Session getSession() {
        return super.getSession();
    }

    @Override
    public boolean create(Utilisateur obj) {
        return super.create(obj);
    }

    @Override
    public Utilisateur find(Class c,Integer id) {
        return (Utilisateur)session.createQuery("SELECT c FROM Utilisateur AS c WHERE idUtilisateurs = " + id, c).getResultList().get(0);
    }

    @Override
    public boolean check(String mail, String mdp){
        long query = (long)session.createQuery("SELECT count(*) FROM Utilisateur WHERE mail = '" + mail + "' AND motDePasse = '" + mdp +"'").getResultList().get(0);
        if(query == 1){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Collection<Utilisateur> findAll(Class c) {
        return super.findAll(c);
    }

    @Override
    public boolean update(Utilisateur obj) {
        return super.update(obj);
    }

    @Override
    public boolean delete(Utilisateur obj) {
        return super.delete(obj);
    }

    @Override
    public boolean deleteAll() {
        return super.deleteAll();
    }

    @Override
    public void close() {
        super.close();
    }
}
