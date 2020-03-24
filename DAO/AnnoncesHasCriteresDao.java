package DAO;

import modele.Annonce;
import modele.AnnoncesHasCriteres;

import java.util.Collection;

public interface AnnoncesHasCriteresDao extends Dao<AnnoncesHasCriteres> {
    public Collection<AnnoncesHasCriteres> findByAnnonce(Integer idAnnonce);
    public void deleteByAnnonce(Integer idAnnonce);
    public void clear();
}
