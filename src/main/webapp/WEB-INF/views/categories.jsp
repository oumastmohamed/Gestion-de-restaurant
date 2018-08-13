<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<div class="errors">
${exception}
</div>
<a href="<c:url value="/j_spring_security_logout" />" > Logout</a>

<div id="formCat" class="cadre">
	<f:form modelAttribute="categorie" action="saveCat" method="post" 
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>ID Catégorie</td>
				<td><f:input path="idCategorie"/></td>
				<td><f:errors path="idCategorie" cssClass="errors"></f:errors></td>
			</tr>
			
			<tr>
				<td>Nom Catégorie</td>
				<td><f:input path="nomCategorie"/></td>
				<td><f:errors path="nomCategorie" cssClass="errors"></f:errors></td>
			</tr>
			
			<tr>
				<td>Description</td>
				<td><f:textarea path="description"/></td>
				<td><f:errors path="description" cssClass="errors"></f:errors></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
	</f:form>
</div>


<div id="tabCategories" class="cadre">
	<table class="tab1">
		<tr>
			<th>ID</th> <th>NOM CAT</th> <th>DESCRIPTION</th>
		</tr>
		<c:forEach items="${categories}" var="cat">
		<tr>
			<td>${cat.idCategorie}</td>
			<td>${cat.nomCategorie}</td>
			<td>${cat.description}</td>
			<td><a href="suppCat?idCat=${cat.idCategorie}">Supp</a></td>
			<td><a href="editCat?idCat=${cat.idCategorie}">Edit</a></td>
		</tr>
		</c:forEach>
	</table>
</div>