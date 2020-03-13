package modele;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Categories", schema = "lebon2i", catalog = "")
public class Categorie {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "IDCATEGORIES", nullable = false,insertable = false,updatable = false)
    private int idCategories;

    @Basic
    @Column(name = "LABEL")
    private String label;

    @ManyToOne
    @JoinColumn(name="SURCATEGORIES_IDSURCATEGORIES",referencedColumnName = "IDSURCATEGORIES",nullable = true)
    private SurCategorie surCategorie;

    @OneToMany(mappedBy="categorie", cascade = {CascadeType.ALL})
    private List<Annonce> annonces;

    @OneToMany(mappedBy="categorie", cascade = {CascadeType.ALL})
    private List<Critere> criteres;

    public Categorie(int idCategories, String label, SurCategorie surCategorie) {
        this.idCategories = idCategories;
        this.label = label;
        this.surCategorie = surCategorie;
    }

    public Categorie() {
    }

    /**
     * @param label
     * @param surCategorie
     */
    public Categorie(String label, SurCategorie surCategorie) {
        this.label = label;
        this.surCategorie = surCategorie;
    }

    public int getIdCategories() {
        return idCategories;
    }

    public String getLabel() {
        return label;
    }

    public SurCategorie getSurCategorie() {
        return surCategorie;
    }

    public List<Annonce> getAnnonces() {
        return annonces;
    }

    public List<Critere> getCriteres() {
        return criteres;
    }

    @Override
    public String toString() {
        return label;
    }


}
