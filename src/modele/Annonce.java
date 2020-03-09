package modele;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Annonces", schema = "lebon2i", catalog = "")
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

    @OneToMany(mappedBy="annonce", cascade = {CascadeType.ALL})
    private List<AnnoncesHasCriteres> annoncesHasCriteres;

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

    public void setIdAnnonces(int idAnnonces) {
        this.idAnnonces = idAnnonces;
    }

    @Override
    public String toString() {
        return "Annonce{" +
                "idAnnonces=" + idAnnonces +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                ", image='" + image + '\'' +
                ", utilisateur=" + utilisateur.toString() +
                ", categorie=" + categorie.toString() +
                ", ville=" + ville.toString() +
                ", annoncesHasCriteres=" + annoncesHasCriteres +
                '}';
    }
}
