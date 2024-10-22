package DAO;

import Metier.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProduitDAO implements IProduitDAO{

    public  void  ProduitDAO(){

    }
    @Override
    public Produit save(Produit produit) {

         Connection connection = SingletonConnection.getConnection();
         try {
                 String query1 = "insert into Produit(designation,prix,quantite) values(?,?,?)";
                 PreparedStatement pst = connection.prepareStatement(query1);
                 pst.setString(1, produit.getDesignation());
                 pst.setDouble(2,produit.getPrix());
                 pst.setInt(3,produit.getQuantite());
                 pst.executeUpdate();
                 // recuperer l id du produit qu'on a vient d inserer
                 String query2 = "select MAX(idProduit) as maxID from produit ";
                 PreparedStatement pst2= connection.prepareStatement(query2);
                 ResultSet resultSet = pst2.executeQuery();
                 while (resultSet.next()){
                     produit.setID(resultSet.getLong("maxID"));
                 }
         }catch (Exception e){
             e.printStackTrace();
         }

         return produit;
    }

    @Override
    public ArrayList<Produit> getProduitParMC(String mot) {
        ArrayList<Produit> produits = new ArrayList<>();
        Connection connection = SingletonConnection.getConnection();
        try {
            String query = "select * from produit where designation like ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1,"%"+mot+"%");
            ResultSet resultSet = pst.executeQuery();

            while (resultSet.next()){
                Produit produit = new Produit();
                // recuperer les colones de la bd
                Long ID = resultSet.getLong("idProduit");
                String designation=resultSet.getString("designation");
                double prix=resultSet.getDouble("prix");
                int quantite=resultSet.getInt("quantite");
                // remplir le produit
                produit.setID(ID);
                produit.setDesignation(designation);
                produit.setPrix(prix);
                produit.setQuantite(quantite);
                // add to liste
                produits.add(produit);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return produits;
    }

    @Override
    public Produit getProduitParId(Long id) {
        return null;
    }

    @Override
    public Produit updateProduit(Long id) {
        return null;
    }

    @Override
    public void deleteProduit(long id) {
        Connection connection = SingletonConnection.getConnection();
        try {
            String req ="delete from produit where idProduit=?";
            PreparedStatement pst = connection.prepareStatement(req);
            pst.setLong(1,id);
            pst.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
