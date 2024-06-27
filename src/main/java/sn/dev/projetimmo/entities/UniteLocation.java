package sn.dev.projetimmo.entities;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "unite_location", schema = "bd_immo", catalog = "")
public class UniteLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "numUnite")
    private int numUnite;

    @Column(name = "nbPieces")
    private String nbPieces;

    @Column(name = "superficie")
    private String superficie;

    @Column(name = "loyer")
    private String loyer;

    @ManyToOne
    @JoinColumn(name = "immeuble_id", referencedColumnName = "id", nullable = false)
    private Immeuble immeuble;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Immeuble getImmeuble() {
        return immeuble;
    }

    public void setImmeuble(Immeuble immeuble) {
        this.immeuble = immeuble;
    }
}