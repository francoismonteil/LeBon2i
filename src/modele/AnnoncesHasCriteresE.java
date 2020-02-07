package modele;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Annonces_has_Criteres", schema = "LeBon2i")
@IdClass(AnnoncesHasCriteresEPK.class)
public class AnnoncesHasCriteresE {
    private int annoncesIdAnnonces;
    private int criteresIdCriteres;
    private Float valeurInt;
    private String valeurText;
    private Date valeurDate;

    @Id
    @Column(name = "Annonces_idAnnonces")
    public int getAnnoncesIdAnnonces() {
        return annoncesIdAnnonces;
    }

    public void setAnnoncesIdAnnonces(int annoncesIdAnnonces) {
        this.annoncesIdAnnonces = annoncesIdAnnonces;
    }

    @Id
    @Column(name = "Criteres_idCriteres")
    public int getCriteresIdCriteres() {
        return criteresIdCriteres;
    }

    public void setCriteresIdCriteres(int criteresIdCriteres) {
        this.criteresIdCriteres = criteresIdCriteres;
    }

    @Basic
    @Column(name = "valeurInt")
    public Float getValeurInt() {
        return valeurInt;
    }

    public void setValeurInt(Float valeurInt) {
        this.valeurInt = valeurInt;
    }

    @Basic
    @Column(name = "valeurText")
    public String getValeurText() {
        return valeurText;
    }

    public void setValeurText(String valeurText) {
        this.valeurText = valeurText;
    }

    @Basic
    @Column(name = "valeurDate")
    public Date getValeurDate() {
        return valeurDate;
    }

    public void setValeurDate(Date valeurDate) {
        this.valeurDate = valeurDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnnoncesHasCriteresE that = (AnnoncesHasCriteresE) o;
        return annoncesIdAnnonces == that.annoncesIdAnnonces &&
                criteresIdCriteres == that.criteresIdCriteres &&
                Objects.equals(valeurInt, that.valeurInt) &&
                Objects.equals(valeurText, that.valeurText) &&
                Objects.equals(valeurDate, that.valeurDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(annoncesIdAnnonces, criteresIdCriteres, valeurInt, valeurText, valeurDate);
    }
}
