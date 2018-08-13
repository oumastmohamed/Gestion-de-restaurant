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
<!-- Debut section  -->
<div id="wrapper">
<!-- Debut section  -->
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
            <div class="col-md-12">
				<h1 class="page-head-line">Formulaire pour le caissier</h1>
				
            </div>
         </div>
         <div class="row">
         <div class="panel-body">
               <div class="panel panel-default">
                        <div class="panel-heading">
                            Nouveau caissier
                        </div>
                        <div class="panel-body">
                        <f:form modelAttribute="cassier" action="saveCa" method="post" 
								enctype="multipart/form-data">
                       
                                        <div class="form-group">
                                            <f:input type="hidden" path="idCassier" cssClass="form-control"/>
                                            <p class="help-block"><f:errors path="idCassier" cssClass="errors"></f:errors></p>
                                        </div>
                                        
										<div class="form-group">
                                            <label>Nom</label>
                                            <f:input path="nomCassier" cssClass="form-control"/>
                                     		<p class="help-block"><f:errors path="nomCassier" cssClass="errors"></f:errors></p>
                                 		</div>
                                 		
                                 		<div class="form-group">
                                            <label>Prenom</label>
                                            <f:input path="prenomCassier" cssClass="form-control"/>
                                     		<p class="help-block"><f:errors path="prenomCassier" cssClass="errors"></f:errors></p>
                                 		</div>
                                 		
                                 		<div class="form-group">
                                         	<label>Adresse</label>
                                         	<f:textarea path="adresse" cssClass="form-control" rows="3"/>
                                         	<p class="help-block"><f:errors path="adresse" cssClass="errors"></f:errors></p>
                                 		</div>
                                 		
                                 		<div class="form-group">
                                            <label>Telephone</label>
                                            <f:input path="tel" cssClass="form-control"/>
                                     		<p class="help-block"><f:errors path="tel" cssClass="errors"></f:errors></p>
                                 		</div>
                                 		
                                 		<div class="form-group">
                                            <label>Email</label>
                                            <f:input path="email" cssClass="form-control"/>
                                     		<p class="help-block"><f:errors path="email" cssClass="errors"></f:errors></p>
                                 		</div>
                                 		
                                 		<div class="form-group">
                                            <label>Sexe</label>
                                            <f:select path="sexe" cssClass="form-control">
												<f:option value="Homme" label="Homme" />
												<f:option value="Femme" label="Femme" />
											</f:select>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Salaire</label>
                                            <f:input path="salaire" cssClass="form-control"/>
                                     		<p class="help-block"><f:errors path="salaire" cssClass="errors"></f:errors></p>
                                 		</div>
                                        
                                        <input type="submit" class="btn btn-info" value="Enregistrer"/>

                              </f:form>
                         </div>
               </div>
         </div>
         </div>
         <div class="row">
         	<div class="panel-body">
            	<!--   Kitchen Sink -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Liste des administrateurs
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Nom complet</th>
                                            <th>Adresse</th>
                                            <th>Telephone</th>
                                            <th>Email</th>
                                            <th>Sexe</th>
                                            <th>Salaire</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${cassiers}" var="ca">
											<tr>
												<td>${ca.idCassier}</td>
												<td>${ca.nomCassier} ${ca.prenomCassier}</td>
												<td>${ca.adresse}</td>
												<td>${ca.tel}</td>
												<td>${ca.email}</td>
												<td>${ca.sexe}</td>
												<td>${ca.salaire}</td>
												<td><a href="javascript:confirmer('suppCa?idCa=${ca.idCassier}')">Supp</a></td>
												<td><a href="editCa?idCa=${ca.idCassier}">Edit</a></td>
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
</div>
<!-- Fin section  -->
<%@ include file="/WEB-INF/include/footer.jsp"%>
<%@ include file="/WEB-INF/include/js.jsp"%>
</body>
</html>