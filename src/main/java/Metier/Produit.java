package Metier;

import java.io.Serializable;

public class Produit implements Serializable {

    //attributes
    private long ID ;
    private String designation;
    private double prix;
    private int quantite ;

    // constructors

    public Produit(){

    }
    public Produit(String designation, double prix, int quantite) {
        this.designation = designation;
        this.prix = prix;
        this.quantite = quantite;
    }

    public Produit(long ID, String designation, double prix, int quantite) {
        this.ID = ID;
        this.designation = designation;
        this.prix = prix;
        this.quantite = quantite;
    }

    //getters

    public long getID() {
        return ID;
    }

    public String getDesignation() {
        return designation;
    }

    public double getPrix() {
        return prix;
    }

    public int getQuantite() {
        return quantite;
    }
    // setters
    public void setID(long ID) {
        this.ID = ID;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    // methodes

    @Override
    public String toString() {
        return "Produit{" +
                "ID=" + ID +
                ", designation='" + designation + '\'' +
                ", prix=" + prix +
                ", quantite=" + quantite +
                '}';
    }
}
