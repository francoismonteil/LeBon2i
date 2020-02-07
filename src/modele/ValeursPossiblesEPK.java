package modele;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ValeursPossiblesEPK implements Serializable {
    private int idValeursPossibles;
    private int criteresIdCriteres;

    @Column(name = "idValeurs_possibles")
    @Id
    public int getIdValeursPossibles() {
        return idValeursPossibles;
    }

    public void setIdValeursPossibles(int idValeursPossibles) {
        this.idValeursPossibles = idValeursPossibles;
    }

    @Column(name = "Criteres_idCriteres")
    @Id
    public int getCriteresIdCriteres() {
        return criteresIdCriteres;
    }

    public void setCriteresIdCriteres(int criteresIdCriteres) {
        this.criteresIdCriteres = criteresIdCriteres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValeursPossiblesEPK that = (ValeursPossiblesEPK) o;
        return idValeursPossibles == that.idValeursPossibles &&
                criteresIdCriteres == that.criteresIdCriteres;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idValeursPossibles, criteresIdCriteres);
    }
}
