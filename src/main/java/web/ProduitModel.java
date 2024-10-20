package web;

import Metier.Produit;

import java.util.ArrayList;

public class ProduitModel {
    //attributes
    private String MC="";
    private ArrayList<Produit>produits=new ArrayList<>();

    //constructors
    public ProduitModel(){

    }

    public ProduitModel(String MC, ArrayList<Produit> produits) {
        this.MC = MC;
        this.produits = produits;
    }

    //getters and setters

    public String getMC() {
        return MC;
    }

    public void setMC(String MC) {
        this.MC = MC;
    }

    public ArrayList<Produit> getProduits() {
        return produits;
    }

    public void setProduits(ArrayList<Produit> produits) {
        this.produits = produits;
    }
}
