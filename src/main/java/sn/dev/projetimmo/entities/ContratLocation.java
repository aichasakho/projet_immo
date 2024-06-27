package sn.dev.projetimmo.entities;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "contrat_location", schema = "bd_immo", catalog = "")
public class ContratLocation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "immeuble_id")
    private Immeuble immeuble;

    @ManyToOne
    @JoinColumn(name = "locataire_id", referencedColumnName = "id")
    private Locataire locataire;

    @Basic
    @Column(name = "unite_location_id")
    private int uniteLocationId;

    @Basic
    @Column(name = "dateDebut")
    private String dateDebut;

    @Basic
    @Column(name = "dateFin")
    private String dateFin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Immeuble getImmeuble() {
        return immeuble;
    }

    public void setImmeuble(Immeuble immeuble) {
        this.immeuble = immeuble;
    }
    public Locataire getLocataire() {
        return locataire;
    }

    public void setLocataire(Locataire locataire) {
        this.locataire = locataire;
    }

    public int getUniteLocationId() {
        return uniteLocationId;
    }

    public void setUniteLocationId(int uniteLocationId) {
        this.uniteLocationId = uniteLocationId;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContratLocation that = (ContratLocation) o;

        if (id != that.id) return false;
        if (immeuble != that.immeuble) return false;
        if (locataire != that.locataire) return false;
        if (uniteLocationId != that.uniteLocationId) return false;
        if (dateDebut != null ? !dateDebut.equals(that.dateDebut) : that.dateDebut != null) return false;
        if (dateFin != null ? !dateFin.equals(that.dateFin) : that.dateFin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (immeuble != null ? immeuble.getId() : 0);
        result = 31 * result + (locataire != null ? locataire.getId() : 0);
        result = 31 * result + uniteLocationId;
        result = 31 * result + (dateDebut != null ? dateDebut.hashCode() : 0);
        result = 31 * result + (dateFin != null ? dateFin.hashCode() : 0);
        return result;
    }
}
