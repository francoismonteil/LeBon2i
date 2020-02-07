package modele;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AnnoncesEPK implements Serializable {
    private int idAnnonces;
    private int utilisateursIdUtilisateurs;
    private int categoriesIdCategories;
    private int villesIdVilles;

    @Column(name = "idAnnonces")
    @Id
    public int getIdAnnonces() {
        return idAnnonces;
    }

    public void setIdAnnonces(int idAnnonces) {
        this.idAnnonces = idAnnonces;
    }

    @Column(name = "Utilisateurs_idUtilisateurs")
    @Id
    public int getUtilisateursIdUtilisateurs() {
        return utilisateursIdUtilisateurs;
    }

    public void setUtilisateursIdUtilisateurs(int utilisateursIdUtilisateurs) {
        this.utilisateursIdUtilisateurs = utilisateursIdUtilisateurs;
    }

    @Column(name = "Categories_idCategories")
    @Id
    public int getCategoriesIdCategories() {
        return categoriesIdCategories;
    }

    public void setCategoriesIdCategories(int categoriesIdCategories) {
        this.categoriesIdCategories = categoriesIdCategories;
    }

    @Column(name = "Villes_idVilles")
    @Id
    public int getVillesIdVilles() {
        return villesIdVilles;
    }

    public void setVillesIdVilles(int villesIdVilles) {
        this.villesIdVilles = villesIdVilles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnnoncesEPK that = (AnnoncesEPK) o;
        return idAnnonces == that.idAnnonces &&
                utilisateursIdUtilisateurs == that.utilisateursIdUtilisateurs &&
                categoriesIdCategories == that.categoriesIdCategories &&
                villesIdVilles == that.villesIdVilles;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnnonces, utilisateursIdUtilisateurs, categoriesIdCategories, villesIdVilles);
    }
}
