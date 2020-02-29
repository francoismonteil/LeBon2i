package modele;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "surCategories", schema = "lebon2i", catalog = "")
public class SurCategorie {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "IDSURCATEGORIES", nullable = false,insertable = false,updatable = false)
    private int idSurCategories;

    @Basic
    @Column(name = "LABEL")
    private String label;

    @OneToMany(mappedBy="surCategorie", cascade = {CascadeType.ALL})
    private List<Categorie> categories;

    public SurCategorie(int idSurCategories, String label) {
        this.idSurCategories = idSurCategories;
        this.label = label;
    }

    public SurCategorie(String label) {
        this.label = label;
    }
}
