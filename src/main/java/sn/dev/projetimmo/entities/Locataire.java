package entities;

import javax.persistence.*;

@Entity
public class Locataire {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nom")
    private String nom;
    @Basic
    @Column(name = "prenom")
    private String prenom;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "telephone")
    private String telephone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Locataire locataire = (Locataire) o;

        if (id != locataire.id) return false;
        if (nom != null ? !nom.equals(locataire.nom) : locataire.nom != null) return false;
        if (prenom != null ? !prenom.equals(locataire.prenom) : locataire.prenom != null) return false;
        if (email != null ? !email.equals(locataire.email) : locataire.email != null) return false;
        if (telephone != null ? !telephone.equals(locataire.telephone) : locataire.telephone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        return result;
    }
}
