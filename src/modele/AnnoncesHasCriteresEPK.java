package modele;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AnnoncesHasCriteresEPK implements Serializable {
    private int annoncesIdAnnonces;
    private int criteresIdCriteres;

    @Column(name = "Annonces_idAnnonces")
    @Id
    public int getAnnoncesIdAnnonces() {
        return annoncesIdAnnonces;
    }

    public void setAnnoncesIdAnnonces(int annoncesIdAnnonces) {
        this.annoncesIdAnnonces = annoncesIdAnnonces;
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
        AnnoncesHasCriteresEPK that = (AnnoncesHasCriteresEPK) o;
        return annoncesIdAnnonces == that.annoncesIdAnnonces &&
                criteresIdCriteres == that.criteresIdCriteres;
    }

    @Override
    public int hashCode() {
        return Objects.hash(annoncesIdAnnonces, criteresIdCriteres);
    }
}
