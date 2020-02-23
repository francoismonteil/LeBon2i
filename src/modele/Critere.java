package modele;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "criteres", schema = "lebon2i", catalog = "")
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

    @OneToMany(mappedBy="CRITERES_IDCRITERES", cascade = {CascadeType.ALL})
    private List<AnnoncesHasCriteres> annoncesHasCriteres;

    @OneToMany(mappedBy="CRITERES_IDCRITERES", cascade = {CascadeType.ALL})
    private List<ValeurPossible> valeurPossibles;

    public Critere() {
    }

}
