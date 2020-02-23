package modele;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "utilisateurs", schema = "lebon2i", catalog = "")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "IDUTILISATEURS", nullable = false,insertable = false,updatable = false)
    private int idUtilisateurs;

    @Basic
    @Column(name = "PRENOM")
    private String prenom;

    @Basic
    @Column(name = "NOM")
    private String nom;

    @Basic
    @Column(name = "DATENAISSANCE")
    private Date dateNaissance;

    @Basic
    @Column(name = "ADRESSE")
    private String adresse;

    @Basic
    @Column(name = "TEL")
    private String tel;

    @Basic
    @Column(name = "MAIL")
    private String mail;

    @Basic
    @Column(name = "MOTDEAPSSE")
    private String motDePasse;

    @Basic
    @Column(name = "ADMIN")
    private int admin;

    @ManyToOne
    @JoinColumn(name="VILLES_IDVILLES",referencedColumnName = "IDVILLES",nullable = true)
    private Ville ville;

    @OneToMany(mappedBy="UTILISATEURS_IDUTILISATEURS", cascade = {CascadeType.ALL})
    private List<Annonce> annonces;

    public Utilisateur() {
    }
}
