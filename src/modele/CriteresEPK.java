package modele;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CriteresEPK implements Serializable {
    private int idCriteres;
    private int categoriesIdCategories;

    @Column(name = "idCriteres")
    @Id
    public int getIdCriteres() {
        return idCriteres;
    }

    public void setIdCriteres(int idCriteres) {
        this.idCriteres = idCriteres;
    }

    @Column(name = "Categories_idCategories")
    @Id
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
        CriteresEPK that = (CriteresEPK) o;
        return idCriteres == that.idCriteres &&
                categoriesIdCategories == that.categoriesIdCategories;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCriteres, categoriesIdCategories);
    }
}
