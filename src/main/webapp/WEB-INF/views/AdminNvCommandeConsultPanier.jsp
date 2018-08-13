<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="/WEB-INF/include/css.jsp"%>
<style type="text/css">
  #pourA{
   	float: right;
   	}
  </style>
<title>Super-administrateur</title>
</head>
<body>
<%@ include file="/WEB-INF/include/SuperAdmin/SuperAdHeader.jsp"%>
<%@ include file="/WEB-INF/include/SuperAdmin/SuperAdminMenu.jsp"%>
<div id="wrapper">
<!-- Debut section  -->
<div id="page-wrapper">
	<div id="page-inner">
	<div class="row">
            <div class="col-md-12">
				<h1 class="page-head-line">Bonjour ${NomClient}, voila votre panier</h1>
				<h1 class="page-subhead-line"><strong>${total}</strong></h1>
				<div>
            	<a href="RouteurPanier" class="btn btn-primary">Routeur</a>
				<a id="pourA" href="confirmerEnregistrerPanier" class="btn btn-primary">Confirmer et Enregistrer</a>
            	</div>
            </div>
         </div>
         <br>
        <div class="row text-center pad-row">
        <c:forEach items="${ligneCommande}" var="lc">
                <div class="col-md-3">
                    <div class="panel panel-success">
                        <div class="panel-heading">
                        	<input type="hidden" value="${lc.produit.idProduit}"/>
                            <h4>${lc.produit.nomProduit}</h4>
                        </div>
                        <div class="panel-body">
                            <div class="round-body">
                                <img src="photoProd?idProd=${lc.produit.idProduit}"/>
                            </div>
                            <div class="plan-two">
                            <br>
                                <p><strong>Description</strong> ${lc.produit.description} </p>
                                <p><strong>Catégorie</strong> ${lc.produit.categorie.nomCategorie}</p>
                                <p><strong>Quantité</strong> ${lc.quantite}</p>
                            </div>
                            <div>
                             <a href="suppProdPanier?idProd=${lc.produit.idProduit}" class="btn btn-success btn-lg btn-block">Supprimer</a>
                             </div>
                        </div>
                    </div>
               </div>
        </c:forEach>
    </div>            
	</div>
</div>
<!-- Fin section  -->
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
<%@ include file="/WEB-INF/include/js.jsp"%>
</body>
</html>