<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="/WEB-INF/include/css.jsp"%>
<title>Produit</title>
</head>
<body>
<%@ include file="/WEB-INF/include/Admin/AdminHeader.jsp"%>
<%@ include file="/WEB-INF/include/Admin/AdminMenu.jsp"%>
<div id="wrapper">
<!-- Debut section  -->
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
            <div class="col-md-12">
				<h1 class="page-head-line">Formulaire pour les produits</h1>
				
            </div>
         </div>
         <div class="row">
         <div class="panel-body">
               <div class="panel panel-default">
                        <div class="panel-heading">
                            Nouveau produit
                        </div>
                        <div class="panel-body">
                        <f:form modelAttribute="produit" action="saveProdAd" method="post" 
								enctype="multipart/form-data">
                       
                                        <div class="form-group">
                                            <f:input type="hidden" path="idProduit" cssClass="form-control"/>
                                            <p class="help-block"><f:errors path="idProduit" cssClass="errors"></f:errors></p>
                                        </div>
                                        
										<div class="form-group">
                                            <label>Nom</label>
                                            <f:input path="nomProduit" cssClass="form-control"/>
                                     		<p class="help-block"><f:errors path="nomProduit" cssClass="errors"></f:errors></p>
                                 		</div>
                                 		
                                 		<div class="form-group">
                                            <label>Catégorie</label>
                                            <f:select path="categorie.idCategorie" items="${categories}" itemValue="idCategorie" itemLabel="nomCategorie" cssClass="form-control"></f:select>
                                 		</div>
                                 		
                                 		<div class="form-group">
                                         	<label>Description</label>
                                         	<f:textarea path="description" cssClass="form-control" rows="3"/>
                                         	<p class="help-block"><f:errors path="description" cssClass="errors"></f:errors></p>
                                 		</div>
                                 		
                                 		<div class="form-group">
                                            <label>Prix</label>
                                            <f:input path="prix" cssClass="form-control"/>
                                     		<p class="help-block"><f:errors path="prix" cssClass="errors"></f:errors></p>
                                 		</div>
                                 		
                                 		<div class="form-group">
                                            <label>Selectionner?</label><br>
                                            <f:checkbox path="etatProduit"/>
                                     		<p class="help-block"><f:errors path="etatProduit" cssClass="errors"></f:errors></p>
                                 		</div>
                                 		
                                 		<div class="form-group">
                        					<label>Selectionner une image</label>
                            					<div >
                                    			<input type="file" name="file" class="btn-file btn-success" />
                            					</div>
                        					
                    					</div>
                                 		
                                        <input type="submit" class="btn btn-info" value="Enregistrer"/>

                              </f:form>
                         </div>
               </div>
         </div>
         </div>
	</div>
</div>
<!-- Fin section  -->
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
<%@ include file="/WEB-INF/include/js.jsp"%>
</body>
</html>