package DAO;

import modele.Annonce;
import modele.Categorie;
import modele.Critere;

import java.util.Collection;
import java.util.List;

public interface CritereDao extends Dao<Critere> {
    public Collection<Critere> findByCategorie(Integer idCategorie);
}
