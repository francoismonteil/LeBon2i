package modele;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CategoriesEPK implements Serializable {
    private int idCategories;
    private int surCategoriesIdSurCategories;

    @Column(name = "idCategories")
    @Id
    public int getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(int idCategories) {
        this.idCategories = idCategories;
    }

    @Column(name = "SurCategories_idSurCategories")
    @Id
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
        CategoriesEPK that = (CategoriesEPK) o;
        return idCategories == that.idCategories &&
                surCategoriesIdSurCategories == that.surCategoriesIdSurCategories;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategories, surCategoriesIdSurCategories);
    }
}
