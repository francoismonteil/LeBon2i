package modele;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Villes", schema = "LeBon2i", catalog = "")
public class VillesE {
    private int idVilles;
    private String codePostal;
    private String nomVille;

    @Id
    @Column(name = "idVilles")
    public int getIdVilles() {
        return idVilles;
    }

    public void setIdVilles(int idVilles) {
        this.idVilles = idVilles;
    }

    @Basic
    @Column(name = "codePostal")
    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    @Basic
    @Column(name = "nomVille")
    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VillesE villesE = (VillesE) o;
        return idVilles == villesE.idVilles &&
                Objects.equals(codePostal, villesE.codePostal) &&
                Objects.equals(nomVille, villesE.nomVille);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVilles, codePostal, nomVille);
    }
}
