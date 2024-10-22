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

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}
