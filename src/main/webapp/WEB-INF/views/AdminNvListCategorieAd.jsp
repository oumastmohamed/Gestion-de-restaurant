<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="/WEB-INF/include/css.jsp"%>
<title>Catégorie</title>
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
				<h1 class="page-head-line">Formulaire des categorie</h1>
				
            </div>
         </div>
         <div class="row">
         <div class="panel-body">
               <div class="panel panel-primary">
                        <div class="panel-heading">
                            Nouveau categorie
                        </div>
                        <div class="panel-body">
                        <f:form modelAttribute="categorie" action="saveCatAd" method="post" 
								enctype="multipart/form-data">
                       
                                        <div class="form-group">
                                            <f:input type="hidden" path="idCategorie" cssClass="form-control"/>
                                            <p class="help-block"><f:errors path="idCategorie" cssClass="errors"></f:errors></p>
                                        </div>
                                        
										<div class="form-group">
                                            <label>Nom</label>
                                            <f:input path="nomCategorie" cssClass="form-control"/>
                                     		<p class="help-block"><f:errors path="nomCategorie" cssClass="errors"></f:errors></p>
                                 		</div>
                                 		
                                 		<div class="form-group">
                                         	<label>Description</label>
                                         	<f:textarea path="description" cssClass="form-control" rows="3"/>
                                         	<p class="help-block"><f:errors path="description" cssClass="errors"></f:errors></p>
                                 		</div>
                                        
                                        <input type="submit" class="btn btn-info" value="Enregistrer"/>

                              </f:form>
                         </div>
               </div>
         </div>
         </div>
         <div class="row">
         <div class="form-group input-group col-md-6 col-md-offset-3">
        	<form action="CategorieRechercherAd">
        		<div class="input-group">
     		
      				<input type="text" name="mcRechCat" class="form-control" value="${mcCat}"/>
                		<span class="form-group input-group-btn">
        					<input class="btn btn-default" type="submit" value="Rechercher"/>
     	 				</span>
    			</div>
    		</form>
        </div>
        </div>
         <div class="row">
         	<div class="panel-body">
            	<!--   Kitchen Sink -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Liste des categories
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>Numéro</th>
                                            <th>Nom </th>
                                            <th>Description</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${categories}" var="cat">
											<tr>
												<td>${cat.idCategorie}</td>
												<td>${cat.nomCategorie}</td>
												<td>${cat.description}</td>
												<td><a href="javascript:confirmer('suppCatAd?idCat=${cat.idCategorie}')">Supp</a></td>
												<td><a href="editCatAd?idCat=${cat.idCategorie}">Edit</a></td>
											</tr>
										</c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                     <!-- End  Kitchen Sink -->   
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