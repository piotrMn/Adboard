<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
	
	<style><%@include file="/WEB-INF/css/style.css"%></style>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
	<meta name="_csrf" content="${_csrf.token}"/>
	<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<h4>Nowe ogłoszenie</h4>
		<hr>
		<table>
			<form:form modelAttribute="newAd" method="POST" action="${pageContext.request.contextPath }/user/new-ad"  acceptCharset="UTF-8">
				<tr>
					<td>Tytuł</td>
					<td><form:input path="title" size="60"/></td>
					<td><form:errors path="title" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Opis</td>
					<td><form:textarea path="description" rows="7" cols="60" /></td>
					<td><form:errors path="description" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Miejsce</td>
					<td><form:input path="location" size="60"/></td>
					<td><form:errors path="location" cssClass="error"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="Zatwierdź" role="button" class="btn btn-secondary" aria-pressed="true"></td>
					<td><a href="${pageContext.request.contextPath}/user" role="button" class="btn btn-secondary" aria-pressed="true">Anuluj</a><td>
				</tr>
			</form:form>
		</table>
	</div>
</body>
</html>