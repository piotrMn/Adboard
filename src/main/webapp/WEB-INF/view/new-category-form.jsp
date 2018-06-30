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
		<h4>Nowa kategoria</h4>
		<hr>
		<form:form modelAttribute="category" method="POST" action="${pageContext.request.contextPath }/admin/new-category"  acceptCharset="UTF-8">
			<table>
				<tr>
					<td>Nazwa</td>
					<td><form:input path="name" size="60"/></td>
					<td><form:errors path="name" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Opis</td>
					<td><form:textarea path="description" rows="2" cols="60" /></td>
					<td></td>
				</tr>
				<tr><td colspan="2" style="height: 20px;"></td></tr>
				<tr>
					<td><input type="submit" value="Zatwierdź" role="button" class="btn btn-secondary" aria-pressed="true"></td>
					<td style="text-align: center"><a href="${pageContext.request.contextPath}/admin" role="button" class="btn btn-secondary" aria-pressed="true" >Anuluj</a><td>
					<td></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>