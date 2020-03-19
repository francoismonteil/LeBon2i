package modele;
import javax.persistence.*;
import javax.rmi.CORBA.Util;
import java.util.List;

@Entity
@Table(name = "Villes", schema = "lebon2i", catalog = "")
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

    @OneToMany(mappedBy="ville", cascade = {CascadeType.ALL})
    private List<Utilisateur> utilisateurs;

    @OneToMany(mappedBy="ville", cascade = {CascadeType.ALL})
    private List<Annonce> annonces;

    public Ville(){

    }
    public Ville(int idVilles, String codePostal, String nomVille) {
        this.idVilles = idVilles;
        this.codePostal = codePostal;
        this.nomVille = nomVille;
    }

    public Ville(String codePostal, String nomVille) {
        this.codePostal = codePostal;
        this.nomVille = nomVille;
    }

    @Override
    public String toString() {
        return "Ville{" +
                "idVilles=" + idVilles +
                ", codePostal='" + codePostal + '\'' +
                ", nomVille='" + nomVille + '\'' +
                ", utilisateurs=" + utilisateurs +
                ", annonces=" + annonces +
                '}';
    }
}
