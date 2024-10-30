package DAO;

import Metier.Produit;

import java.util.ArrayList;

public interface IProduitDAO {
    public Produit save(Produit produit); // creer produit
    public ArrayList<Produit>getProduitParMC(String mot);
    public Produit getProduitParId(Long id);  //consulter produit
    public Produit updateProduit(Produit produit);
    public void deleteProduit(long id);

}
