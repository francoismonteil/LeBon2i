package JPA;

import DAO.AnnonceDao;
import modele.Annonce;
import modele.Categorie;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collection;

public class JpaAnnonceDao extends JpaDao<Annonce> implements AnnonceDao {
    private Class classAnnonce = new Annonce().getClass();

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
        return (Annonce)session.createQuery("SELECT c FROM Annonce AS c WHERE idAnnonces = " + id, c).getResultList().get(0);
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

    public int updateAnnonce(Annonce annonce){
        Transaction tnx = session.beginTransaction();
        String SQL = "UPDATE "+ classAnnonce.getName()+" as c ";
        SQL += " SET titre = :titre, description = :description, prix = :prix, image = :image, categorie = :categorie ";
        SQL += " WHERE idAnnonces = :id";
        Query query = session.createQuery(SQL);
        query.setParameter("titre", annonce.getTitre());
        query.setParameter("description", annonce.getDescription());
        query.setParameter("prix", annonce.getPrix());
        query.setParameter("image", null);
        query.setParameter("categorie", annonce.getCategorie());
        query.setParameter("id", annonce.getIdAnnonces());
        int id = query.executeUpdate();
        tnx.commit();
        return id;
    }


    public Collection<Annonce> findByUtilisateur(Integer idUtilisateur) {
        return session.createQuery("SELECT c"
                + " FROM " + classAnnonce.getName() + " AS c " +
                "WHERE c.utilisateur =" + idUtilisateur
        ).getResultList();
    }

}
