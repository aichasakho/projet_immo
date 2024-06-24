package entities;

import javax.persistence.*;

@Entity
public class Paiement {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "contrat_location_id")
    private int contratLocationId;
    @Basic
    @Column(name = "montant")
    private String montant;
    @Basic
    @Column(name = "datePaiement")
    private String datePaiement;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContratLocationId() {
        return contratLocationId;
    }

    public void setContratLocationId(int contratLocationId) {
        this.contratLocationId = contratLocationId;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public String getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(String datePaiement) {
        this.datePaiement = datePaiement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paiement paiement = (Paiement) o;

        if (id != paiement.id) return false;
        if (contratLocationId != paiement.contratLocationId) return false;
        if (montant != null ? !montant.equals(paiement.montant) : paiement.montant != null) return false;
        if (datePaiement != null ? !datePaiement.equals(paiement.datePaiement) : paiement.datePaiement != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + contratLocationId;
        result = 31 * result + (montant != null ? montant.hashCode() : 0);
        result = 31 * result + (datePaiement != null ? datePaiement.hashCode() : 0);
        return result;
    }
}
