package JPA;

import DAO.AnnonceDao;
import DAO.ValeurPossibleDao;
import modele.Annonce;
import modele.Critere;
import modele.ValeurPossible;
import org.hibernate.Session;

import java.util.Collection;

public class JpaValeurPossibleDao extends JpaDao<ValeurPossible> implements ValeurPossibleDao {

    private Class classValeurPossible = new ValeurPossible().getClass();

    @Override
    public Session getSession() {
        return super.getSession();
    }

    @Override
    public boolean create(ValeurPossible obj) {
        return super.create(obj);
    }

    @Override
    public ValeurPossible find(Class c, Integer id) {
        return super.find(c, id);
    }

    @Override
    public Collection<ValeurPossible> findAll(Class c) {
        return super.findAll(c);
    }

    @Override
    public boolean update(ValeurPossible obj) {
        return super.update(obj);
    }

    @Override
    public boolean delete(ValeurPossible obj) {
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
    public Collection<ValeurPossible> findByCritere(Integer idCritere){
        return session.createQuery("SELECT vp"
                + " FROM " + classValeurPossible.getName() + " AS vp " +
                "WHERE vp.critere =" + idCritere
        ).getResultList();
    }
}
