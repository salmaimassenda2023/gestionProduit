<%--
  Created by IntelliJ IDEA.
  User: AdMin
  Date: 22/10/2024
  Time: 19:45
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
  <div class="container p-2 mt-5 ">
      <div class="card border-success">
          <div class="card-header bg-success text-white">Insertion Du Produit Avec Succes</div>
          <div class="card-body">
              <form method="get" action="index.do">
                  <%--  1--%>
                  <div class="mb-2">
                      <strong>ID :</strong>

                      <label>${produitSave.getID()}</label>
                  </div>
                  <%--  2--%>
                  <div class="mb-2">
                      <strong>Designation :</strong>
                      <label>${produitSave.getDesignation()}</label>
                  </div>
                  <%--  3--%>
                  <div class="mb-2">
                      <strong>Prix :</strong>
                      <label>${produitSave.getPrix()}</label>
                      <label>DH</label>
                  </div>
                  <%--  4--%>
                  <div class="mb-2">
                      <strong>Quantité :</strong>
                      <label>${produitSave.getQuantite()}</label>
                  </div>
                      <div class="d-flex justify-content-center mt-1">
                          <button type="submit" class="btn btn-success">OK</button>
                      </div>

              </form>

          </div>

      </div>

  </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
