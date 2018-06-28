<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<h2>Administracja</h2>
		<hr>
		<div id="navbar">
			<a href="${pageContext.request.contextPath}/category/new" role="button" class="btn btn-secondary" aria-pressed="true">Dodaj kategorię</a>
			<a href="${pageContext.request.contextPath}/admin/manage" role="button" class="btn btn-secondary" aria-pressed="true">Edycja ogłoszeń</a>
		</div>
		<c:if test="${not empty categories }">
		<b>Kategorie:</b>
			<div id="category-box">
				<c:forEach items="${categories }" var="category">
					<div class="list-item">
						<b><c:out value="${category.getName() }"></c:out></b><br>
						<a href="${pageContext.request.contextPath}/category/delete/${category.getId()}" class="action-links" onclick="return confirm('Na pewno usunąć?')">Usuń</a>
						<a href="${pageContext.request.contextPath}/category/edit/${category.getId()}" class="action-links">Edytuj</a>
						${category.getDescription() }
					</div>
				</c:forEach>
			</div>		
		</c:if>

	</div>
</body>
</html>