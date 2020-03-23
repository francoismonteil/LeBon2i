package modele;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Annonces", schema = "lebon2i")
public class Annonce {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "IDANNONCES", nullable = false,insertable = false,updatable = false)
    private int idAnnonces;

    @Basic
    @Column(name = "TITRE")
    private String titre;

    @Basic
    @Column(name = "DESCRIPTION")
    private String description;

    @Basic
    @Column(name = "PRIX")
    private float prix;

    @Basic
    @Column(name = "IMAGE")
    private String image;

    @ManyToOne
    @JoinColumn(name="UTILISATEURS_IDUTILISATEURS",referencedColumnName = "IDUTILISATEURS",nullable = true)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name="CATEGORIES_IDCATEGORIES",referencedColumnName = "IDCATEGORIES",nullable = true)
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name="VILLES_IDVILLES",referencedColumnName = "IDVILLES",nullable = true)
    private Ville ville;

    @OneToMany(mappedBy="annonces", cascade = {CascadeType.ALL})
    private List<AnnoncesHasCriteres> annoncesHasCriteres;

    public Annonce(){

    }
    public Annonce(String titre, String description, float prix, String image, Utilisateur utilisateur, Categorie categorie, Ville ville) {
        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.image = image;
        this.utilisateur = utilisateur;
        this.categorie = categorie;
        this.ville = ville;
    }

    public Annonce(int idAnnonces, String titre, String description, float prix, String image, Utilisateur utilisateur, Categorie categorie, Ville ville) {
        this.idAnnonces = idAnnonces;
        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.image = image;
        this.utilisateur = utilisateur;
        this.categorie = categorie;
        this.ville = ville;
    }

    public int getIdAnnonces() {
        return idAnnonces;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public float getPrix() {
        return prix;
    }

    public String getImage() {
        return image;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public Ville getVille() {
        return ville;
    }

    public List<AnnoncesHasCriteres> getAnnoncesHasCriteres() {
        return annoncesHasCriteres;
    }

    public void setIdAnnonces(int idAnnonces) {
        this.idAnnonces = idAnnonces;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return this.titre;
    }
}
