package JPA;

import DAO.AnnonceDao;
import DAO.CritereDao;
import modele.Annonce;
import modele.Categorie;
import modele.Critere;
import org.hibernate.Session;

import java.util.Collection;
import java.util.List;

public class JpaCritereDao extends JpaDao<Critere> implements CritereDao {

    private Class classCritere = new Critere().getClass();

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

    @Override
    public Collection<Critere> findByCategorie(Integer idCategorie){
        return session.createQuery("SELECT c"
                + " FROM " + classCritere.getName() + " AS c " +
                "WHERE c.categorie =" + idCategorie
        ).getResultList();
    }
}
