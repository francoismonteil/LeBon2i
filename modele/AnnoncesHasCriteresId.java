package modele;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AnnoncesHasCriteresId implements Serializable {
    @Column(name = "ANNONCES_IDANNONCES")
    private int annonceId;

    @Column(name = "CRITERES_IDCRITERES")
    private int critereId;

    public AnnoncesHasCriteresId(){
    }

    public AnnoncesHasCriteresId(int annonceId, int critereId){
        this.annonceId = annonceId;
        this.critereId = critereId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnnoncesHasCriteresId that = (AnnoncesHasCriteresId) o;
        return annonceId == that.annonceId &&
                critereId == that.critereId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(annonceId, critereId);
    }
}
