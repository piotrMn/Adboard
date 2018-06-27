<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		<a href="${pageContext.request.contextPath}/" role="button" class="btn btn-secondary" aria-pressed="true">Powrót do strony głównej</a>	
	</div>
</body>
</html>