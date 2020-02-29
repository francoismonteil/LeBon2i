package JPA;

import DAO.AnnonceDao;
import DAO.VilleDao;
import modele.Annonce;
import modele.Ville;
import org.hibernate.Session;

import java.util.Collection;

public class JpaVilleDao extends JpaDao<Ville> implements VilleDao {
    @Override
    public Session getSession() {
        return super.getSession();
    }

    @Override
    public boolean create(Ville obj) {
        return super.create(obj);
    }

    @Override
    public Ville find(Class c, Integer id) {
        return super.find(c, id);
    }

    @Override
    public Collection<Ville> findAll(Class c) {
        return super.findAll(c);
    }

    @Override
    public boolean update(Ville obj) {
        return super.update(obj);
    }

    @Override
    public boolean delete(Ville obj) {
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
