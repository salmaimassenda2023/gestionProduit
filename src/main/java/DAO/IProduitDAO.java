package DAO;

import Metier.Produit;

import java.util.ArrayList;

public interface IProduitDAO {
    public Produit save(Produit produit);
    public ArrayList<Produit>getProduitParMC(String mot);
}
