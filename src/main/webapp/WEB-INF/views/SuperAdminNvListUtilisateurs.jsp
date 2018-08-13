<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/include/css.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
				<h1 class="page-head-line">Formulaire pour les utilisateurs</h1>
				
            </div>
         </div>
         <div class="row">
         <div class="panel-body">
               <div class="panel panel-default">
                        <div class="panel-heading">
                            Nouveau compte d'utilisateur
                        </div>
                        <div class="panel-body">
                        <f:form modelAttribute="user" action="saveUs" method="post" 
								enctype="multipart/form-data">
                       
                                        <div class="form-group">
                                            <f:input type="hidden" path="idUser" cssClass="form-control"/>
                                            <p class="help-block"><f:errors path="idUser" cssClass="errors"></f:errors></p>
                                        </div>
                                        
										<div class="form-group">
                                            <label>Nom d'utilisateur</label>
                                            <f:input path="login" cssClass="form-control"/>
                                     		<p class="help-block"><f:errors path="login" cssClass="errors"></f:errors></p>
                                 		</div>
                                 		
                                 		<div class="form-group">
                                            <label>Mot de passe</label>
                                            <f:input path="password" cssClass="form-control"/>
                                     		<p class="help-block"><f:errors path="password" cssClass="errors"></f:errors></p>
                                 		</div>
                                 		
                                 		<div class="form-group">
                                            <label>Activer?</label><br>
                                            <f:checkbox path="actived"/>
                                     		<p class="help-block"><f:errors path="actived" cssClass="errors"></f:errors></p>
                                 		</div>
                                 		
                                 		
                                 		
                                 		<div class="form-group">
                                            <label>affecté à l'utilisateur du mail </label>
                                            <f:select path="emailUserUtil" cssClass="form-control">
												<c:forEach items="${utilisateurs}" var="u">
													<f:option value="${u.idUtil}" label="${u.emailUtil}" />
												</c:forEach>
											</f:select>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Role</label>
                                            <f:select path="nomroleUtil" cssClass="form-control">
                                            	<f:option value="ROLE_ADMIN_GERER" label="ROLE_SUPER_ADMIN" />
												<f:option value="ROLE_ADMIN_GERER" label="ROLE_ADMIN_GERER" />
												<f:option value="ROLE_ADMIN_CAISSIER" label="ROLE_ADMIN_CAISSIER" />
												<f:option value="ROLE_ADMIN_SERVEUR" label="ROLE_ADMIN_SERVEUR" />
												<f:option value="ROLE_ADMIN_CUISINIER" label="ROLE_ADMIN_CUISINIER" />
											</f:select>
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
                            Liste des compte des utilisateurs
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Nom d'utilisateur</th>
                                            <th>Mot de passe</th>
                                            <th>Activer</th>
                                            <th>Email d'utilisateur</th>
                                            <th>Role</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${listUtilisateurs}" var="u">
											<tr>
												<td>${u.idUser}</td>
												<td>${u.login}</td>
												<td>${u.password}</td>
												<td>${u.actived}</td>
												<td>${u.nomPrenomUtil}</td>
												<td>${u.nomroleUtil}</td>
												<td><a href="javascript:confirmer('suppUs?idUs=${u.idUser}')">Supp</a></td>
												<td><a href="editUs?idUs=${u.idUser}">Edit</a></td>
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
</body>
</html>