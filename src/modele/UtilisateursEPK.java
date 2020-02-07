package modele;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class UtilisateursEPK implements Serializable {
    private int idUtilisateurs;
    private int villesIdVilles;

    @Column(name = "idUtilisateurs")
    @Id
    public int getIdUtilisateurs() {
        return idUtilisateurs;
    }

    public void setIdUtilisateurs(int idUtilisateurs) {
        this.idUtilisateurs = idUtilisateurs;
    }

    @Column(name = "Villes_idVilles")
    @Id
    public int getVillesIdVilles() {
        return villesIdVilles;
    }

    public void setVillesIdVilles(int villesIdVilles) {
        this.villesIdVilles = villesIdVilles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UtilisateursEPK that = (UtilisateursEPK) o;
        return idUtilisateurs == that.idUtilisateurs &&
                villesIdVilles == that.villesIdVilles;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUtilisateurs, villesIdVilles);
    }
}
