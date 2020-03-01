package JPA;

import DAO.AnnonceDao;
import DAO.CritereDao;
import modele.Annonce;
import modele.Critere;
import org.hibernate.Session;

import java.util.Collection;

public class JpaCritereDao extends JpaDao<Critere> implements CritereDao {
    @Override
    public Session getSession() {
        return super.getSession();
    }

    @Override
    public boolean create(Critere obj) {
        return super.create(obj);
    }

    @Override
    public Critere find(Class c, Integer id) {
        return super.find(c, id);
    }

    @Override
    public Collection<Critere> findAll(Class c) {
        return super.findAll(c);
    }

    @Override
    public boolean update(Critere obj) {
        return super.update(obj);
    }

    @Override
    public boolean delete(Critere obj) {
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
