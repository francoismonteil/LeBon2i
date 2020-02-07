package modele;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SurCategories", schema = "LeBon2i", catalog = "")
public class SurCategoriesE {
    private int idSurCategories;
    private String label;

    @Id
    @Column(name = "idSurCategories")
    public int getIdSurCategories() {
        return idSurCategories;
    }

    public void setIdSurCategories(int idSurCategories) {
        this.idSurCategories = idSurCategories;
    }

    @Basic
    @Column(name = "label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SurCategoriesE that = (SurCategoriesE) o;
        return idSurCategories == that.idSurCategories &&
                Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSurCategories, label);
    }
}
