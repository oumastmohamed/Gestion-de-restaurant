<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="/WEB-INF/include/css.jsp"%>
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
				<h1 class="page-head-line">Tableau des produits</h1>
				
            </div>
         </div>
         <br>
	<!--Search Section Start--> 
        <div class="row ">
        <div class="form-group input-group col-md-6 col-md-offset-3">
        	<form action="ProduitRechercher">
        		<div class="input-group">	
      				<input type="text" name="mcRechProd" class="form-control" value="${mcProd}"/>
                		<span class="form-group input-group-btn">
        					<input class="btn btn-default" type="submit" value="Rechercher"/>
     	 				</span>
    			</div>
    		</form>
        </div>
        </div>
         <br>
        <!--Search Section end-->
        
        <div class="row text-center pad-row">
        <c:forEach items="${produits}" var="p">
                <div class="col-md-3">
                    <div class="panel panel-success">
                        <div class="panel-heading">
                        	<input type="hidden" value="${p.idProduit}"/>
                            <h4>${p.nomProduit}</h4>
                        </div>
                        <div class="panel-body">
                            <div class="round-body">
                                <img src="photoProd?idProd=${p.idProduit}"/>
                            </div>
                            <div class="plan-two">
                            <br>
                                <p><strong>Description</strong> ${p.description}</p>
                                <p><strong>Catégorie</strong> ${p.categorie.nomCategorie}</p>
                                <p><strong>Prix</strong> ${p.prix} DH</p>
                            </div>
                            <div>
                            <a href="editProd?idProd=${p.idProduit}" class="btn btn-success btn-lg btn-block">Modifier</a>
                             <a href="javascript:confirmer('suppProd?idProd=${p.idProduit}')" class="btn btn-success btn-lg btn-block">Supprimer</a>
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