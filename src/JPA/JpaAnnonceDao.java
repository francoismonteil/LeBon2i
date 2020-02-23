package JPA;

import DAO.AnnonceDao;
import modele.Annonce;
import org.hibernate.Session;

import java.util.Collection;

public class JpaAnnonceDao extends JpaDao<Annonce> implements AnnonceDao {
    @Override
    public Session getSession() {
        return super.getSession();
    }

    @Override
    public boolean create(Annonce obj) {
        return super.create(obj);
    }

    @Override
    public Annonce find(Class c, Integer id) {
        return super.find(c, id);
    }

    @Override
    public Collection<Annonce> findAll(Class c) {
        return super.findAll(c);
    }

    @Override
    public boolean update(Annonce obj) {
        return super.update(obj);
    }

    @Override
    public boolean delete(Annonce obj) {
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
