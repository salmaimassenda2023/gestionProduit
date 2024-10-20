package DAO;


import Metier.Produit;

import java.util.ArrayList;

class ProduitDAOTest {

    public static void main(String[] args) {
        ProduitDAO produitDAO = new ProduitDAO();
        Produit p1= produitDAO.save(new Produit("HP 65",900,45));
        Produit p2=produitDAO.save(new Produit("tablette",1000,15));
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        ///
        ArrayList<Produit>list= produitDAO.getProduitParMC("H");
        for (Produit p : list){
            System.out.println(p.toString());
        }



    }
}