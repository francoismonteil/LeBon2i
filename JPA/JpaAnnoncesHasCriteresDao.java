package JPA;

import DAO.AnnonceDao;
import DAO.AnnoncesHasCriteresDao;
import modele.Annonce;
import modele.AnnoncesHasCriteres;
import org.hibernate.Session;

import java.util.Collection;

public class JpaAnnoncesHasCriteresDao extends JpaDao<AnnoncesHasCriteres> implements AnnoncesHasCriteresDao {
    @Override
    public Session getSession() {
        return super.getSession();
    }

    @Override
    public boolean create(AnnoncesHasCriteres obj) {
        return super.create(obj);
    }

    @Override
    public AnnoncesHasCriteres find(Class c, Integer id) {
        return super.find(c, id);
    }

    @Override
    public Collection<AnnoncesHasCriteres> findAll(Class c) {
        return super.findAll(c);
    }

    @Override
    public boolean update(AnnoncesHasCriteres obj) {
        return super.update(obj);
    }

    @Override
    public boolean delete(AnnoncesHasCriteres obj) {
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