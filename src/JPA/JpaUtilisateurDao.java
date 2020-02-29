package JPA;

import DAO.AnnonceDao;
import DAO.UtilisateurDao;
import modele.Annonce;
import modele.Utilisateur;
import org.hibernate.Session;

import java.util.Collection;

public class JpaUtilisateurDao extends JpaDao<Utilisateur> implements UtilisateurDao {
    @Override
    public Session getSession() {
        return super.getSession();
    }

    @Override
    public boolean create(Utilisateur obj) {
        return super.create(obj);
    }

    @Override
    public Utilisateur find(Class c, Integer id) {
        return super.find(c, id);
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
