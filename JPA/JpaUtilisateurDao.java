package JPA;

import DAO.AnnonceDao;
import DAO.UtilisateurDao;
import modele.Annonce;
import modele.Critere;
import modele.Utilisateur;
import org.hibernate.Session;

import javax.rmi.CORBA.Util;
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
        //return super.find(c, id);
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
