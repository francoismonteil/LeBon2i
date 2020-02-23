package modele;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories", schema = "lebon2i", catalog = "")
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

    @OneToMany(mappedBy="CATEGORIES_IDCATEGORIES", cascade = {CascadeType.ALL})
    private List<Annonce> annonces;

    @OneToMany(mappedBy="CATEGORIES_IDCATEGORIES", cascade = {CascadeType.ALL})
    private List<Critere> criteres;

    public Categorie() {
    }
}
