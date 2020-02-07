package modele;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Valeurs_possibles", schema = "LeBon2i")
@IdClass(ValeursPossiblesEPK.class)
public class ValeursPossiblesE {
    private int idValeursPossibles;
    private Float valeurInt;
    private String valeurText;
    private int criteresIdCriteres;

    @Id
    @Column(name = "idValeurs_possibles")
    public int getIdValeursPossibles() {
        return idValeursPossibles;
    }

    public void setIdValeursPossibles(int idValeursPossibles) {
        this.idValeursPossibles = idValeursPossibles;
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

    @Id
    @Column(name = "Criteres_idCriteres")
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
        ValeursPossiblesE that = (ValeursPossiblesE) o;
        return idValeursPossibles == that.idValeursPossibles &&
                criteresIdCriteres == that.criteresIdCriteres &&
                Objects.equals(valeurInt, that.valeurInt) &&
                Objects.equals(valeurText, that.valeurText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idValeursPossibles, valeurInt, valeurText, criteresIdCriteres);
    }
}
