package modele;
import javax.persistence.*;

@Entity
@Table(name = "Valeurs_possibles", schema = "lebon2i", catalog = "")
public class ValeurPossible {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "IDVALEURS_POSSIBLES", nullable = false,insertable = false,updatable = false)
    private int idValeursPossibles;

    @Basic
    @Column(name = "VALEURINT")
    private Float valeurInt;

    @Basic
    @Column(name = "VALEURTEXT")
    private String valeurText;

    @ManyToOne
    @JoinColumn(name="CRITERES_IDCRITERES",referencedColumnName = "IDCRITERES",nullable = true)
    private Critere critere;

    public ValeurPossible() {
    }

    public ValeurPossible(int idValeursPossibles, float valeurInt, String valeurText, Critere critere) {
        this.idValeursPossibles = idValeursPossibles;
        this.valeurInt = valeurInt;
        this.valeurText = valeurText;
        this.critere = critere;
    }

    public ValeurPossible(float valeurInt, String valeurText, Critere critere) {
        this.valeurInt = valeurInt;
        this.valeurText = valeurText;
        this.critere = critere;
    }

    @Override
    public String toString() {
        return "ValeurPossible{" +
                "idValeursPossibles=" + idValeursPossibles +
                ", valeurInt=" + valeurInt +
                ", valeurText='" + valeurText + '\'' +
                ", critere=" + critere +
                '}';
    }
}
