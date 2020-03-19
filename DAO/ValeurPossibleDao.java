package DAO;

import modele.Annonce;
import modele.ValeurPossible;

import java.util.Collection;

public interface ValeurPossibleDao extends Dao<ValeurPossible> {
    public Collection<ValeurPossible> findByCritere(Integer idCritere);
}
