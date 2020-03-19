package modele;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Annonces_has_Criteres", schema = "lebon2i")
public class AnnoncesHasCriteres {

    @EmbeddedId
    private AnnoncesHasCriteresId id;

    @ManyToOne
    @MapsId("ANNONCES_IDANNONCES")
    //@JoinColumn(name="ANNONCES_IDANNONCES",referencedColumnName = "IDANNONCES",nullable = true)
    private Annonce annonce;


    @ManyToOne
    @MapsId("CRITERES_IDCRITERES")
    //@JoinColumn(name="CRITERES_IDCRITERES",referencedColumnName = "IDCRITERES",nullable = true)
    private Critere critere;

    @Basic
    @Column(name = "VALEURINT")
    private Float valeurInt;

    @Basic
    @Column(name = "VALEURTEXT")
    private String valeurText;

    @Basic
    @Column(name = "VALEURDATE")
    private Date valeurDate;

    public AnnoncesHasCriteres(){
    }

    public AnnoncesHasCriteres(Annonce annonce, Critere critere, float valeurInt) {
        this.annonce = annonce;
        this.critere = critere;
        this.id = new AnnoncesHasCriteresId(annonce.getIdAnnonces(), critere.getIdCriteres());
        this.valeurInt = valeurInt;
        this.valeurText = valeurText;
        this.valeurDate = valeurDate;
    }

    public AnnoncesHasCriteres(Annonce annonce, Critere critere, String valeurText) {
        this.annonce = annonce;
        this.critere = critere;
        this.id = new AnnoncesHasCriteresId(annonce.getIdAnnonces(), critere.getIdCriteres());
        this.valeurInt = valeurInt;
        this.valeurText = valeurText;
        this.valeurDate = valeurDate;
    }

    public AnnoncesHasCriteres(Annonce annonce, Critere critere,Date valeurDate) {
        this.annonce = annonce;
        this.critere = critere;
        this.id = new AnnoncesHasCriteresId(annonce.getIdAnnonces(), critere.getIdCriteres());
        this.valeurInt = valeurInt;
        this.valeurText = valeurText;
        this.valeurDate = valeurDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnnoncesHasCriteres that = (AnnoncesHasCriteres) o;
        return Objects.equals(annonce, that.annonce) &&
                Objects.equals(critere, that.critere);
    }

    @Override
    public int hashCode() {
        return Objects.hash(annonce, critere);
    }
}
