package web;

import DAO.ProduitDAO;
import Metier.Produit;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProduitServlet", value = "*.do")
public class ProduitServlet extends HttpServlet {
    // attributes
    ProduitModel produitModel;
    ProduitDAO metier ;
    public void init(){
        produitModel=new ProduitModel();
        metier=new ProduitDAO();

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if(path.equals("/index.do")){
            request.setAttribute("model",produitModel);
            request.getRequestDispatcher("/Vues/produit.jsp").forward(request,response);

        }
        else if(path.equals("/chercher.do")){
            String motCle = request.getParameter("mc");
            produitModel.setMC(motCle);
            ArrayList<Produit>produits=metier.getProduitParMC(motCle);
            produitModel.setProduits(produits);
            request.setAttribute("model",produitModel);
            request.getRequestDispatcher("/Vues/produit.jsp").forward(request,response);


        }
        else if(path.equals("/ajouter.do")){
            Produit produit = new Produit();
            request.setAttribute("produit",produit);
            request.getRequestDispatcher("/Vues/saisieProduit.jsp").forward(request,response);
        }
        else if(path.equals("/supprimer.do")){
            Long id = Long.parseLong(request.getParameter("id"));
            metier.deleteProduit(id);
            response.sendRedirect("chercher.do?mc=");
        }
        else if(path.equals("/modifier.do")){
            Long id =Long.parseLong(request.getParameter("id"));
            Produit produit = metier.getProduitParId(id);
            produit.toString();
            request.setAttribute("produitMd",produit);
            request.getRequestDispatcher("/Vues/modifierProduit.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path =request.getServletPath();
        if(path.equals("/save.do")){
            String designation = request.getParameter("designation");
            double prix = Double.parseDouble(request.getParameter("prix"));
            int quantite = Integer.parseInt(request.getParameter("quantite"));
            Produit produit = metier.save(new Produit(designation,prix,quantite));
            request.setAttribute("produitSave",produit);
            request.getRequestDispatcher("/Vues/confirmation.jsp").forward(request,response);

        }else if(path.equals("/saveModifier.do")){
            Long id =Long.parseLong(request.getParameter("id"));
            String designation = request.getParameter("designation");
            double prix = Double.parseDouble(request.getParameter("prix"));
            int quantite = Integer.parseInt(request.getParameter("quantite"));
            Produit produit = metier.updateProduit(new Produit(id,designation,prix,quantite));
            request.setAttribute("produitSave",produit);
            request.getRequestDispatcher("/Vues/confirmation.jsp").forward(request,response);


        }




    }
}
