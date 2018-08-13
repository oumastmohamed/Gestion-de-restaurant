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
	<!--Search Section Start-->
        <div class="row ">
        <div class="form-group input-group col-md-6 col-md-offset-3">
        	<form action="ServeurRechercher">
        		<div class="input-group">
     		
      				<input type="text" name="mcRech" class="form-control" value="${mc}"/>
                		<span class="form-group input-group-btn">
        					<input class="btn btn-default" type="submit" value="Rechercher"/>
     	 				</span>
    			</div>
    		</form>
        </div>

        </div>
        <!--Search Section end-->
         
	<div class="row">
         	<div class="panel-body">
            	<!--   Kitchen Sink -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Liste des serveurs
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
                                        <c:forEach items="${serveurs}" var="s">
											<tr>
												<td>${s.idServeur}</td>
												<td>${s.nomServeur} ${s.prenomServeur}</td>
												<td>${s.adresse}</td>
												<td>${s.tel}</td>
												<td>${s.email}</td>
												<td>${s.sexe}</td>
												<td>${s.salaire}</td>
												<td><a href="javascript:confirmer('suppSe?idSe=${s.idServeur}')">Supp</a></td>
												<td><a href="editSe?idSe=${s.idServeur}">Edit</a></td>
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
<%@ include file="/WEB-INF/include/footer.jsp"%>
<%@ include file="/WEB-INF/include/js.jsp"%>
</div>
</body>
</html>