<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
	<style><%@include file="/WEB-INF/css/style.css"%></style>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Access denied!</title>
</head>
<body>
	<div id="container">
		<h3>Strefa zastrzeżona!</h3>
		<p>Musisz być zalogowany jako administrator, aby wejść na ten adres.</p>
		<hr>
		<br>
		
		<a href="${path}" role="button" class="btn btn-secondary" aria-pressed="true">Powrót</a>	
		<a href="${pageContext.request.contextPath}/showLoginPage" role="button" class="btn btn-secondary" aria-pressed="true">Zaloguj się</a>
	</div>
</body>
</html>