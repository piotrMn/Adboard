<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
	<style><%@include file="/WEB-INF/css/style.css"%></style>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<h3>Wprowadź dane do rejestracji</h3>
		<hr>
		<form:form  modelAttribute="user" action="${pageContext.request.contextPath}/signup" method="POST">
			<table>
				<tr>
					<td>Imię i nazwisko:</td>
					<td><form:input path="fullname" type="text"/></td>
					<td><form:errors path="fullname" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Nazwa użytkownika:</td>
					<td><form:input path="username" type="text"/></td>
					<td><form:errors path="username" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Adres email:</td>
					<td><form:input path="email" type="text"/></td>
					<td><form:errors path="email" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Numer telefonu:</td>
					<td><form:input path="phone" type="text"/></td>
					<td><form:errors path="phone" type="text"/></td>
				</tr>
				<tr>
					<td>Hasło:</td>
					<td><form:input path="password" type="password"/></td>
					<td><form:errors path="password" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Powtórz hasło:</td>
					<td><input name="password2" type="password"></td>
					<td><c:if test="${error eq 'mismatch' }">Hasła nie zgadzają się</c:if></td>
				</tr>
				<tr><td colspan="3" height="20px;"></td></tr>
				<tr>
					<td colspan="2"><input type="submit" value="Wyślij" role="button" class="btn btn-secondary" aria-pressed="true"></td>
					<td>
						<a href="${pageContext.request.contextPath}/" role="button" class="btn btn-secondary" aria-pressed="true">Strona główna</a>
					</td>
				</tr>			
			</table>
		</form:form>
	</div>
</body>
</html>