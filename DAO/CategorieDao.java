package DAO;

import modele.Annonce;
import modele.Categorie;
import modele.Critere;

import java.util.Collection;

public interface CategorieDao extends Dao<Categorie> {
    public Collection<Categorie> findBySurCategorie(Integer idSurCategorie);
}
