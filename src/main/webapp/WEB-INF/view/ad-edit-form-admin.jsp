<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
		<h4>Edycja ogłoszenia</h4>
		<hr>
		<form:form modelAttribute="thisAd" method="POST" action="${pageContext.request.contextPath }/admin/edit-ad }"  acceptCharset="UTF-8">
			<form:hidden path="id" value="${thisAd.getId() }" />
			<form:hidden path="creationTimestamp" value="${thisAd.getCreationTimestamp() }"/>
			<form:hidden path="expiryTimestamp" value="${thisAd.getExpiryTimestamp() }"/>
			<form:hidden path="user.id" value="${thisAd.getUser().getId()}"/>
			<table>
				<tr>
					<td>Tytuł</td>
					<td><form:input path="title" value="${thisAd.getTitle() }" size="60"/></td>
				</tr>
				<tr>
					<td>Opis</td>
					<td><form:textarea path="description" value="${thisAd.getDescription() }" rows="7" cols="60" /></td>
				</tr>
				<tr>
					<td>Miejsce</td>
					<td><form:input path="location" value="${thisAd.getLocation() }" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Zatwierdź" role="button" class="btn btn-secondary" aria-pressed="true"></td>
					<td style="text-align: center;"><a href="${pageContext.request.contextPath}/admin/manage" role="button" class="btn btn-secondary" aria-pressed="true">Anuluj</a><td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>