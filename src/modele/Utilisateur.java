package modele;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Utilisateurs", schema = "lebon2i", catalog = "")
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

    @OneToMany(mappedBy="utilisateur", cascade = {CascadeType.ALL})
    private List<Annonce> annonces;

    public Utilisateur() {

    }

    public Utilisateur(int idUtilisateurs, String prenom, String nom, Date dateNaissance, String adresse, String tel, String mail, String motDePasse, int admin, Ville ville) {
        this.idUtilisateurs = idUtilisateurs;
        this.prenom = prenom;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.tel = tel;
        this.mail = mail;
        this.motDePasse = motDePasse;
        this.admin = admin;
        this.ville = ville;
    }

    public Utilisateur(String prenom, String nom, Date dateNaissance, String adresse, String tel, String mail, String motDePasse, int admin, Ville ville) {
        this.prenom = prenom;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.tel = tel;
        this.mail = mail;
        this.motDePasse = motDePasse;
        this.admin = admin;
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "idUtilisateurs=" + idUtilisateurs +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", adresse='" + adresse + '\'' +
                ", tel='" + tel + '\'' +
                ", mail='" + mail + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", admin=" + admin +
                ", ville=" + ville +
                ", annonces=" + annonces +
                '}';
    }
}
