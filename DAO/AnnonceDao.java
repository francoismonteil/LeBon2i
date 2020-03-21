package DAO;

import modele.Annonce;
import modele.Categorie;

import java.util.Collection;

public interface AnnonceDao extends Dao<Annonce> {
    public Collection<Annonce> findByUtilisateur(Integer idUtilisateur);
}
