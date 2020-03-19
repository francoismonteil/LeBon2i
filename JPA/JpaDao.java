package JPA;

import DAO.Dao;
import modele.*;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;


public abstract class JpaDao<T> implements Dao<T> {

    protected static final SessionFactory ourSessionFactory;
    protected static Session session;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Annonce.class);
            configuration.addAnnotatedClass(AnnoncesHasCriteres.class);
            configuration.addAnnotatedClass(Categorie.class);
            configuration.addAnnotatedClass(Critere.class);
            configuration.addAnnotatedClass(SurCategorie.class);
            configuration.addAnnotatedClass(Utilisateur.class);
            configuration.addAnnotatedClass(ValeurPossible.class);
            configuration.addAnnotatedClass(Ville.class);
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
            session = ourSessionFactory.openSession();

        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    public Session getSession()
    {
        if (session == null)
        {
            session = ourSessionFactory.openSession();
            session.setFlushMode(FlushMode.ALWAYS);
        }
        return session;
    }
    @Override
    public boolean create(T obj) {
        Transaction tx = session.beginTransaction();
        session.save(obj);
        tx.commit();
        return false;
    }

    @Override
    public T find(Class c,Integer id) {

        //T obj = (T) session.find(c, id);
        T obj = (T) session.load(c,id);
        return(obj);
    }


    @Override
    public Collection<T> findAll(Class c) {
        return session.createQuery("SELECT c FROM " + c.getName() + " AS c", c).getResultList();
    }

    @Override
    public boolean update(T obj) {
        Transaction tx = session.beginTransaction();
        session.update(obj);
        session.refresh(obj);
        tx.commit();
        return true;
    }

    @Override
    public boolean delete(T obj) {
        return false;
    }

    @Override
    public boolean deleteAll() {
        return false;
    }

    @Override
    public void close() {
        session.close();
        ourSessionFactory.close();
    }

}
