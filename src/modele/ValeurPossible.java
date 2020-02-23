package modele;
import javax.persistence.*;

@Entity
@Table(name = "valeurs_possibles", schema = "lebon2i", catalog = "")
public class ValeurPossible {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "IDVALEURS_POSSIBLES", nullable = false,insertable = false,updatable = false)
    private int idValeursPossibles;

    @Basic
    @Column(name = "VALEURINT")
    private Float valeurInt;

    @Basic
    @Column(name = "TYPE")
    private String type;

    @ManyToOne
    @JoinColumn(name="CRITERES_IDCRITERES",referencedColumnName = "IDCRITERES",nullable = true)
    private Critere critere;

    public ValeurPossible() {
    }
}
