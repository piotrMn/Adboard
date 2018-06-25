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
		<form:form modelAttribute="ad" method="POST" action="${pageContext.request.contextPath }/ad/edit}" >
			<form:hidden path="id" value="${thisad.getId() }" />
			<form:hidden path="creationTimestamp" value="${thisad.getCreationTimestamp() }"/>
			<form:hidden path="expiryTimestamp" value="${thisad.getExpiryTimestamp() }"/>
			<table>
				<tr>
					<td>Tytuł</td>
					<td><form:input path="title" value="${thisad.getTitle() }" size="60"/></td>
				</tr>
				<tr>
					<td>Opis</td>
					<td><form:textarea path="description" value="${thisad.getDescription() }" rows="7" cols="60" /></td>
				</tr>
				<tr>
					<td>Miejsce</td>
					<td><form:input path="location" value="${thisad.getLocation() }" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Zatwierdź"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>