<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="/WEB-INF/include/css.jsp"%>
<title>Serveur</title>
</head>
<body>
<%@ include file="/WEB-INF/include/Serveur/ServeurHeader.jsp"%>
<%@ include file="/WEB-INF/include/Serveur/ServeurMenu.jsp"%>
<div id="wrapper">
<!-- Debut section  -->
<div id="page-wrapper">
	<div id="page-inner">
	<div class="row">
            <div class="col-md-12">
				<h1 class="page-head-line">Formulaire pour le client</h1>
				
            </div>
         </div>
         <div class="row">
         <div class="panel-body">
               <div class="panel panel-info">
                        <div class="panel-heading">
                            Nouveau Client
                        </div>
                        <div class="panel-body">
                        <f:form modelAttribute="client" action="saveClSer" method="post" 
								enctype="multipart/form-data">
                       
                                        <div class="form-group">
                                            <f:input type="hidden" path="idClient" cssClass="form-control"/>
                                            <p class="help-block"><f:errors path="idClient" cssClass="errors"></f:errors></p>
                                        </div>
                                        
										<div class="form-group">
                                            <label>Nom</label>
                                            <f:input path="nomClient" cssClass="form-control"/>
                                     		<p class="help-block"><f:errors path="nomClient" cssClass="errors"></f:errors></p>
                                 		</div>
                                 		
                                 		<div class="form-group">
                                            <label>Prenom</label>
                                            <f:input path="prenomClient" cssClass="form-control"/>
                                     		<p class="help-block"><f:errors path="prenomClient" cssClass="errors"></f:errors></p>
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
