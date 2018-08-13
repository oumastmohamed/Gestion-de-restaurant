<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<div class="errors">
${exception}
</div>
<a href="<c:url value="/j_spring_security_logout" />" > Logout</a>

<div id="formAd" class="cadre">
	<f:form modelAttribute="admin" action="saveAd" method="post" 
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>Numéro d'identité</td>
				<td><f:input path="idAdmin"/></td>
				<td><f:errors path="idAdmin" cssClass="errors"></f:errors></td>
			</tr>
			
			<tr>
				<td>Nom </td>
				<td><f:input path="nomAdmin"/></td>
				<td><f:errors path="nomAdmin" cssClass="errors"></f:errors></td>
			</tr>
			
			<tr>
				<td>prenom</td>
				<td><f:input path="prenomAdmin"/></td>
				<td><f:errors path="prenomAdmin" cssClass="errors"></f:errors></td>
			</tr>
			
			<tr>
				<td>Adresse</td>
				<td><f:textarea path="adresse"/></td>
				<td><f:errors path="adresse" cssClass="errors"></f:errors></td>
			</tr>
			
			<tr>
				<td>Telephone</td>
				<td><f:input path="tel"/></td>
				<td><f:errors path="tel" cssClass="errors"></f:errors></td>
			</tr>
			
			<tr>
				<td>Email</td>
				<td><f:input path="email"/></td>
				<td><f:errors path="email" cssClass="errors"></f:errors></td>
			</tr>
			
			<tr>
				<td>Sexe</td>
				<td><f:select path="sexe">
					<f:option value="Homme" label="Homme" />
					<f:option value="Femme" label="Femme" />
				</f:select>
				</td>
				<td><f:errors path="sexe" cssClass="errors"></f:errors></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
	</f:form>
</div>


<div id="tabAdmins" class="cadre">
	<table class="tab1">
		<tr>
			<th>ID</th> <th>NOM</th> <th>PRENOM</th> <th>ADRESSE</th> <th>TELEPHONE</th> <th>EMAIL</th> <th>SEXE</th>
		</tr>
		<c:forEach items="${admins}" var="ad">
		<tr>
			<td>${ad.idAdmin}</td>
			<td>${ad.nomAdmin}</td>
			<td>${ad.prenomAdmin}</td>
			<td>${ad.adresse}</td>
			<td>${ad.tel}</td>
			<td>${ad.email}</td>
			<td>${ad.sexe}</td>
			<td><a href="suppAd?idAd=${ad.idAdmin}">Supp</a></td>
			<td><a href="editAd?idAd=${ad.idAdmin}">Edit</a></td>
		</tr>
		</c:forEach>
	</table>
</div>