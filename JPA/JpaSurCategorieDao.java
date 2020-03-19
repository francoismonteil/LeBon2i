package JPA;

import DAO.AnnonceDao;
import DAO.SurCategorieDao;
import modele.Annonce;
import modele.SurCategorie;
import org.hibernate.Session;

import java.util.Collection;

public class JpaSurCategorieDao extends JpaDao<SurCategorie> implements SurCategorieDao {
    @Override
    public Session getSession() {
        return super.getSession();
    }

    @Override
    public boolean create(SurCategorie obj) {
        return super.create(obj);
    }

    @Override
    public SurCategorie find(Class c, Integer id) {
        return super.find(c, id);
    }

    @Override
    public Collection<SurCategorie> findAll(Class c) {
        return super.findAll(c);
    }

    @Override
    public boolean update(SurCategorie obj) {
        return super.update(obj);
    }

    @Override
    public boolean delete(SurCategorie obj) {
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
