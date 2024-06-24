package entities;

import javax.persistence.*;

@Entity
@Table(name = "unite_location", schema = "bd_immo", catalog = "")
public class UniteLocation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "immeuble_id")
    private int immeubleId;
    @Basic
    @Column(name = "numUnite")
    private int numUnite;
    @Basic
    @Column(name = "nbPieces")
    private String nbPieces;
    @Basic
    @Column(name = "superficie")
    private String superficie;
    @Basic
    @Column(name = "loyer")
    private String loyer;

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

    public int getNumUnite() {
        return numUnite;
    }

    public void setNumUnite(int numUnite) {
        this.numUnite = numUnite;
    }

    public String getNbPieces() {
        return nbPieces;
    }

    public void setNbPieces(String nbPieces) {
        this.nbPieces = nbPieces;
    }

    public String getSuperficie() {
        return superficie;
    }

    public void setSuperficie(String superficie) {
        this.superficie = superficie;
    }

    public String getLoyer() {
        return loyer;
    }

    public void setLoyer(String loyer) {
        this.loyer = loyer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UniteLocation that = (UniteLocation) o;

        if (id != that.id) return false;
        if (immeubleId != that.immeubleId) return false;
        if (numUnite != that.numUnite) return false;
        if (nbPieces != null ? !nbPieces.equals(that.nbPieces) : that.nbPieces != null) return false;
        if (superficie != null ? !superficie.equals(that.superficie) : that.superficie != null) return false;
        if (loyer != null ? !loyer.equals(that.loyer) : that.loyer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + immeubleId;
        result = 31 * result + numUnite;
        result = 31 * result + (nbPieces != null ? nbPieces.hashCode() : 0);
        result = 31 * result + (superficie != null ? superficie.hashCode() : 0);
        result = 31 * result + (loyer != null ? loyer.hashCode() : 0);
        return result;
    }
}
