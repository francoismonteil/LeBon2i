package modele;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Annonces_has_Criteres", schema = "lebon2i")
public class AnnoncesHasCriteres {

    @EmbeddedId
    private AnnoncesHasCriteresId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("Annonces_idAnnonces")
    //@JoinColumn(name="ANNONCES_IDANNONCES",referencedColumnName = "ANNONCEID",nullable = true)
    private Annonce annonces;


    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("Criteres_idCriteres")
    //@JoinColumn(name="CRITERES_IDCRITERES",referencedColumnName = "IDCRITERES",nullable = true)
    private Critere criteres;

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
        this.annonces = annonce;
        this.criteres = critere;
        this.id = new AnnoncesHasCriteresId(annonce.getIdAnnonces(), critere.getIdCriteres());
        this.valeurInt = valeurInt;
        this.valeurText = valeurText;
        this.valeurDate = valeurDate;
    }

    public AnnoncesHasCriteres(Annonce annonce, Critere critere, String valeurText) {
        this.annonces = annonce;
        this.criteres = critere;
        this.id = new AnnoncesHasCriteresId(annonce.getIdAnnonces(), critere.getIdCriteres());
        this.valeurInt = valeurInt;
        this.valeurText = valeurText;
        this.valeurDate = valeurDate;
    }

    public AnnoncesHasCriteres(Annonce annonce, Critere critere,Date valeurDate) {
        this.annonces = annonce;
        this.criteres = critere;
        this.id = new AnnoncesHasCriteresId(annonce.getIdAnnonces(), critere.getIdCriteres());
        this.valeurInt = valeurInt;
        this.valeurText = valeurText;
        this.valeurDate = valeurDate;
    }

    public Annonce getAnnonces() {
        return annonces;
    }

    public Critere getCriteres() {
        return criteres;
    }

    public Float getValeurInt() {
        return valeurInt;
    }

    public String getValeurText() {
        return valeurText;
    }

    public Date getValeurDate() {
        return valeurDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnnoncesHasCriteres that = (AnnoncesHasCriteres) o;
        return Objects.equals(annonces, that.annonces) &&
                Objects.equals(criteres, that.criteres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(annonces, criteres);
    }
}
