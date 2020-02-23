package modele;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "annonces", schema = "lebon2i", catalog = "")
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

    @OneToMany(mappedBy="ANNONCES_IDANNONCES", cascade = {CascadeType.ALL})
    private List<AnnoncesHasCriteres> annoncesHasCriteres;

    public Annonce() {
    }
}
