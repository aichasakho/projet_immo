package entities;

import javax.persistence.*;

@Entity
@Table(name = "contrat_location", schema = "bd_immo", catalog = "")
public class ContratLocation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "immeuble_id")
    private int immeubleId;
    @Basic
    @Column(name = "unite_location_id")
    private int uniteLocationId;
    @Basic
    @Column(name = "locataire_id")
    private int locataireId;
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

    public int getImmeubleId() {
        return immeubleId;
    }

    public void setImmeubleId(int immeubleId) {
        this.immeubleId = immeubleId;
    }

    public int getUniteLocationId() {
        return uniteLocationId;
    }

    public void setUniteLocationId(int uniteLocationId) {
        this.uniteLocationId = uniteLocationId;
    }

    public int getLocataireId() {
        return locataireId;
    }

    public void setLocataireId(int locataireId) {
        this.locataireId = locataireId;
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
        if (immeubleId != that.immeubleId) return false;
        if (uniteLocationId != that.uniteLocationId) return false;
        if (locataireId != that.locataireId) return false;
        if (dateDebut != null ? !dateDebut.equals(that.dateDebut) : that.dateDebut != null) return false;
        if (dateFin != null ? !dateFin.equals(that.dateFin) : that.dateFin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + immeubleId;
        result = 31 * result + uniteLocationId;
        result = 31 * result + locataireId;
        result = 31 * result + (dateDebut != null ? dateDebut.hashCode() : 0);
        result = 31 * result + (dateFin != null ? dateFin.hashCode() : 0);
        return result;
    }
}
