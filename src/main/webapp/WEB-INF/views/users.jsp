<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
<div id="formUs" class="cadre">
	<f:form modelAttribute="user" action="saveUser" method="post" >
		<table>
			<tr>
				<td>ID User</td>
				<td><f:input path="idUser"/></td>
				<td><f:errors path="idUser" cssClass="errors"></f:errors></td>
			</tr>
			
			<tr>
				<td>Login </td>
				<td><f:input path="login"/></td>
				<td><f:errors path="login" cssClass="errors"></f:errors></td>
			</tr>
			
			<tr>
				<td>Mot de passe</td>
				<td><f:input path="password"/></td>
				<td><f:errors path="password" cssClass="errors"></f:errors></td>
			</tr>
			
			<tr>
				<td>Activer?</td>
				<td><f:checkbox path="actived"/></td>
				<td><f:errors path="actived" cssClass="errors"></f:errors></td>
			</tr>
			
			
			<tr>
				<td>Affecter a</td>
				
				<td><f:select path="emailUserUtil">
					<c:forEach items="${utilisateurs}" var="u">
					<f:option value="${u.idUtil}" label="${u.emailUtil}" />
					</c:forEach>
				</f:select>
				<td><f:errors path="emailUserUtil" cssClass="errors"></f:errors></td>
			</tr>
			
			<tr>
				<td>Role</td>
				<td><f:select path="nomroleUtil">
					<f:option value="ROLE_ADMIN_GERER" label="ROLE_ADMIN_GERER" />
					<f:option value="ROLE_ADMIN_CAISSIER" label="ROLE_ADMIN_CAISSIER" />
					<f:option value="ROLE_ADMIN_SERVEUR" label="ROLE_ADMIN_SERVEUR" />
					<f:option value="ROLE_ADMIN_CUISINIER" label="ROLE_ADMIN_CUISINIER" />
				</f:select>
				</td>
				<td><f:errors path="nomroleUtil" cssClass="errors"></f:errors></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
	</f:form>
</div>