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
        	<form action="CuisinierRechercher">
        		<div class="input-group">
     		
      				<input type="text" name="mcRechCu" class="form-control" value="${mcCu}"/>
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
                            Liste des cuisiniers
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
                                            <th>Grade</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${cuisiniers}" var="cu">
											<tr>
												<td>${cu.idCuisinier}</td>
												<td>${cu.nomCuisinier} ${cu.prenomCuisinier}</td>
												<td>${cu.adresse}</td>
												<td>${cu.tel}</td>
												<td>${cu.email}</td>
												<td>${cu.sexe}</td>
												<td>${cu.salaire}</td>
												<td>${cu.grade}</td>
												<td><a href="javascript:confirmer('suppCu?idCu=${cu.idCuisinier}')">Supp</a></td>
												<td><a href="editCu?idCu=${cu.idCuisinier}">Edit</a></td>
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