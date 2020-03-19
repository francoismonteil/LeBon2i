package JPA;

import DAO.AnnonceDao;
import DAO.CategorieDao;
import modele.Annonce;
import modele.Categorie;
import modele.Critere;
import org.hibernate.Session;

import java.util.Collection;

public class JpaCategorieDao extends JpaDao<Categorie> implements CategorieDao {
    private Class classCategorie = new Categorie().getClass();

    @Override
    public Session getSession() {
        return super.getSession();
    }

    @Override
    public boolean create(Categorie obj) {
        return super.create(obj);
    }

    @Override
    public Categorie find(Class c, Integer id) {
        return super.find(c, id);
    }

    @Override
    public Collection<Categorie> findAll(Class c) {
        return super.findAll(c);
    }

    @Override
    public boolean update(Categorie obj) {
        return super.update(obj);
    }

    @Override
    public boolean delete(Categorie obj) {
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
    public Collection<Categorie> findBySurCategorie(Integer idSurCategorie){
        return session.createQuery("SELECT c"
                + " FROM " + classCategorie.getName() + " AS c " +
                "WHERE c.surCategorie =" + idSurCategorie
        ).getResultList();
    }
}
