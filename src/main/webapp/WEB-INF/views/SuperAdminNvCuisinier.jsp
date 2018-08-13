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
				<h1 class="page-head-line">Formulaire pour le cuisinier</h1>
				
            </div>
         </div>
         <div class="row">
         <div class="panel-body">
               <div class="panel panel-info">
                        <div class="panel-heading">
                            Nouveau Cuisinier
                        </div>
                        <div class="panel-body">
                        <f:form modelAttribute="cuisinier" action="saveCu" method="post" 
								enctype="multipart/form-data">
                       
                                        <div class="form-group">
                                            <f:input type="hidden" path="idCuisinier" cssClass="form-control"/>
                                            <p class="help-block"><f:errors path="idCuisinier" cssClass="errors"></f:errors></p>
                                        </div>
                                        
										<div class="form-group">
                                            <label>Nom</label>
                                            <f:input path="nomCuisinier" cssClass="form-control"/>
                                     		<p class="help-block"><f:errors path="nomCuisinier" cssClass="errors"></f:errors></p>
                                 		</div>
                                 		
                                 		<div class="form-group">
                                            <label>Prenom</label>
                                            <f:input path="prenomCuisinier" cssClass="form-control"/>
                                     		<p class="help-block"><f:errors path="prenomCuisinier" cssClass="errors"></f:errors></p>
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
                                 		
                                 		<div class="form-group">
                                            <label>Grade</label>
                                            <f:select path="grade" cssClass="form-control">
												<f:option value="Chef" label="Chef" />
												<f:option value="Ouvrier" label="Ouvrier" />
											</f:select>
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
<%@ include file="/WEB-INF/include/footer.jsp"%>
<%@ include file="/WEB-INF/include/js.jsp"%>
</div>
</body>
</html>