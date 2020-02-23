package modele;
import javax.persistence.*;

@Entity
@Table(name = "annonces_has_criteres", schema = "lebon2i", catalog = "")
public class AnnoncesHasCriteres {

    @ManyToOne
    @JoinColumn(name="ANNONCES_IDANNONCES",referencedColumnName = "IDANNONCES",nullable = true)
    private Annonce annonce;

    @ManyToOne
    @JoinColumn(name="CRITERES_IDCRITERES",referencedColumnName = "IDCRITERES",nullable = true)
    private Critere critere;

    @Basic
    @Column(name = "VALEURINT")
    private Float valeurInt;

    @Basic
    @Column(name = "VALEURTEXT")
    private Float valeurText;

    @Basic
    @Column(name = "VALEURDATE")
    private Float valeurDate;

    public AnnoncesHasCriteres() {
    }
}
