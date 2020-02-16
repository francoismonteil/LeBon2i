package modele;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Categories", schema = "LeBon2i")
@IdClass(CategoriesEPK.class)
public class CategoriesE {
    private int idCategories;
    private String label;
    private int surCategoriesIdSurCategories;

    @Id
    @Column(name = "idCategories")
    public int getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(int idCategories) {
        this.idCategories = idCategories;
    }

    @Basic
    @Column(name = "label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Id
    @Column(name = "SurCategories_idSurCategories")
    public int getSurCategoriesIdSurCategories() {
        return surCategoriesIdSurCategories;
    }

    public void setSurCategoriesIdSurCategories(int surCategoriesIdSurCategories) {
        this.surCategoriesIdSurCategories = surCategoriesIdSurCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriesE that = (CategoriesE) o;
        return idCategories == that.idCategories &&
                surCategoriesIdSurCategories == that.surCategoriesIdSurCategories &&
                Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategories, label, surCategoriesIdSurCategories);
    }
}
