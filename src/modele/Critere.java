package modele;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Criteres", schema = "lebon2i", catalog = "")
public class Critere {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "IDCRITERES", nullable = false,insertable = false,updatable = false)
    private int idCriteres;

    @Basic
    @Column(name = "LABEL")
    private String label;

    @Basic
    @Column(name = "TYPE")
    private String type;

    @ManyToOne
    @JoinColumn(name="CATEGORIES_IDCATEGORIES",referencedColumnName = "IDCATEGORIES",nullable = true)
    private Categorie categorie;

    @OneToMany(mappedBy="critere", cascade = {CascadeType.ALL})
    private List<AnnoncesHasCriteres> annoncesHasCriteres;

    @OneToMany(mappedBy="critere", cascade = {CascadeType.ALL})
    private List<ValeurPossible> valeurPossibles;

    public Critere(int idCriteres, String label, String type, Categorie categorie) {
        this.idCriteres = idCriteres;
        this.label = label;
        this.type = type;
        this.categorie = categorie;
    }

    public Critere(String label, String type, Categorie categorie) {
        this.label = label;
        this.type = type;
        this.categorie = categorie;
    }

    public int getIdCriteres() {
        return idCriteres;
    }

    public void setIdCriteres(int idCriteres) {
        this.idCriteres = idCriteres;
    }
}
