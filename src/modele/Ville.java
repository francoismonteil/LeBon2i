package modele;
import javax.persistence.*;
import javax.rmi.CORBA.Util;
import java.util.List;

@Entity
@Table(name = "villes", schema = "lebon2i", catalog = "")
public class Ville {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "IDVILLES", nullable = false,insertable = false,updatable = false)
    private int idVilles;

    @Basic
    @Column(name = "CODEPOSTAL")
    private String codePostal;

    @Basic
    @Column(name = "NOMVILLE")
    private String nomVille;

    @OneToMany(mappedBy="VILLES_IDVILLES", cascade = {CascadeType.ALL})
    private List<Utilisateur> utilisateurs;

    @OneToMany(mappedBy="VILLES_IDVILLES", cascade = {CascadeType.ALL})
    private List<Annonce> annonces;

    public Ville() {
    }
}
