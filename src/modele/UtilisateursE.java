package modele;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Utilisateurs", schema = "LeBon2i")
@IdClass(UtilisateursEPK.class)
public class UtilisateursE {
    private int idUtilisateurs;
    private String prenom;
    private String nom;
    private Date dateNaissance;
    private String adresse;
    private String tel;
    private String mail;
    private String motdeapsse;
    private byte admin;
    private int villesIdVilles;

    @Id
    @Column(name = "idUtilisateurs")
    public int getIdUtilisateurs() {
        return idUtilisateurs;
    }

    public void setIdUtilisateurs(int idUtilisateurs) {
        this.idUtilisateurs = idUtilisateurs;
    }

    @Basic
    @Column(name = "prenom")
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "dateNaissance")
    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Basic
    @Column(name = "adresse")
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Basic
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "mail")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "motdeapsse")
    public String getMotdeapsse() {
        return motdeapsse;
    }

    public void setMotdeapsse(String motdeapsse) {
        this.motdeapsse = motdeapsse;
    }

    @Basic
    @Column(name = "admin")
    public byte getAdmin() {
        return admin;
    }

    public void setAdmin(byte admin) {
        this.admin = admin;
    }

    @Id
    @Column(name = "Villes_idVilles")
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
        UtilisateursE that = (UtilisateursE) o;
        return idUtilisateurs == that.idUtilisateurs &&
                admin == that.admin &&
                villesIdVilles == that.villesIdVilles &&
                Objects.equals(prenom, that.prenom) &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(dateNaissance, that.dateNaissance) &&
                Objects.equals(adresse, that.adresse) &&
                Objects.equals(tel, that.tel) &&
                Objects.equals(mail, that.mail) &&
                Objects.equals(motdeapsse, that.motdeapsse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUtilisateurs, prenom, nom, dateNaissance, adresse, tel, mail, motdeapsse, admin, villesIdVilles);
    }
}
