package modele;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Criteres", schema = "LeBon2i", catalog = "")
@IdClass(CriteresEPK.class)
public class CriteresE {
    private int idCriteres;
    private String label;
    private String type;
    private int categoriesIdCategories;

    @Id
    @Column(name = "idCriteres")
    public int getIdCriteres() {
        return idCriteres;
    }

    public void setIdCriteres(int idCriteres) {
        this.idCriteres = idCriteres;
    }

    @Basic
    @Column(name = "label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Id
    @Column(name = "Categories_idCategories")
    public int getCategoriesIdCategories() {
        return categoriesIdCategories;
    }

    public void setCategoriesIdCategories(int categoriesIdCategories) {
        this.categoriesIdCategories = categoriesIdCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CriteresE criteresE = (CriteresE) o;
        return idCriteres == criteresE.idCriteres &&
                categoriesIdCategories == criteresE.categoriesIdCategories &&
                Objects.equals(label, criteresE.label) &&
                Objects.equals(type, criteresE.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCriteres, label, type, categoriesIdCategories);
    }
}
