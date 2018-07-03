<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
	<style><%@include file="/WEB-INF/css/style.css"%></style>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<div id="container">
	
		<h3>Wprowadź dane do logowania</h3>
		<hr>
		<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
			<c:if test="${param.error != null }">
				<p class="error">Nieporawna nazwa użytkownika lub hasło.</p>			
			</c:if>
			<table>
				<tr>
					<td>Nazwa użytkownika:</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>Hasło:</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr><td colspan="2" height="20px;"></td></tr>
				<tr>
					<td><input type="submit" value="Zaloguj" role="button" class="btn btn-secondary" aria-pressed="true"></td>
					<td>
						<a href="${pageContext.request.contextPath}/" role="button" class="btn btn-secondary" aria-pressed="true">Strona główna</a>
					</td>
				</tr>			
			</table>
		</form:form>
	</div>
</body>
</html>