package modele;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Annonces", schema = "LeBon2i", catalog = "")
@IdClass(AnnoncesEPK.class)
public class AnnoncesE {
    private int idAnnonces;
    private String titre;
    private String description;
    private Object prix;
    private String image;
    private int utilisateursIdUtilisateurs;
    private int categoriesIdCategories;
    private int villesIdVilles;

    @Id
    @Column(name = "idAnnonces")
    public int getIdAnnonces() {
        return idAnnonces;
    }

    public void setIdAnnonces(int idAnnonces) {
        this.idAnnonces = idAnnonces;
    }

    @Basic
    @Column(name = "titre")
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "prix")
    public Object getPrix() {
        return prix;
    }

    public void setPrix(Object prix) {
        this.prix = prix;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Id
    @Column(name = "Utilisateurs_idUtilisateurs")
    public int getUtilisateursIdUtilisateurs() {
        return utilisateursIdUtilisateurs;
    }

    public void setUtilisateursIdUtilisateurs(int utilisateursIdUtilisateurs) {
        this.utilisateursIdUtilisateurs = utilisateursIdUtilisateurs;
    }

    @Id
    @Column(name = "Categories_idCategories")
    public int getCategoriesIdCategories() {
        return categoriesIdCategories;
    }

    public void setCategoriesIdCategories(int categoriesIdCategories) {
        this.categoriesIdCategories = categoriesIdCategories;
    }

    @Id
    @Column(name = "Villes_idVilles")
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
        AnnoncesE annoncesE = (AnnoncesE) o;
        return idAnnonces == annoncesE.idAnnonces &&
                utilisateursIdUtilisateurs == annoncesE.utilisateursIdUtilisateurs &&
                categoriesIdCategories == annoncesE.categoriesIdCategories &&
                villesIdVilles == annoncesE.villesIdVilles &&
                Objects.equals(titre, annoncesE.titre) &&
                Objects.equals(description, annoncesE.description) &&
                Objects.equals(prix, annoncesE.prix) &&
                Objects.equals(image, annoncesE.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnnonces, titre, description, prix, image, utilisateursIdUtilisateurs, categoriesIdCategories, villesIdVilles);
    }
}
