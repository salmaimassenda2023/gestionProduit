<%@ page import="web.ProduitModel" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Metier.Produit" %><%--
  Created by IntelliJ IDEA.
  User: AdMin
  Date: 21/10/2024
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
   <%@include file="header.jsp"%>

   <div class="container">
       <div class="card border-primary mt-3">
           <div class="card-header text-white bg-primary">Liste des produits</div>
                 <div class="card-body">
                        <form action="chercher.do" method="get" >
                            <label> <b>Mot clé </b></label>
                            <input type="text" name="mc" value="${model.getMC()}">
                            <button type="submit" class="btn btn-primary">Chercher</button>
                        </form>
                       <table class="table table table-striped">
                           <tr>
                               <th>ID</th>
                               <th>Designation</th>
                               <th>Prix</th>
                               <th>Quantite</th>
                           </tr>
                           <c:forEach items="${model.getProduits()}" var="p">
                               <tr>
                                   <td>${p.getID()}</td>
                                   <td>${p.getDesignation()}</td>
                                   <td>${p.getPrix()}</td>
                                   <td>${p.getQuantite()}</td>
                               </tr>
                           </c:forEach>
                       </table>
                 </div>
           </div>
       </div>
   </div>

   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
