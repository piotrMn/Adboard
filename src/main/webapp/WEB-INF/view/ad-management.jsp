<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<h2>Edycja ogłoszeń</h2>
		<hr>
		<div id="navbar">
			<a href="${pageContext.request.contextPath}/admin" role="button" class="btn btn-secondary" aria-pressed="true">Powrót do Administracji</a>
		</div>
		<c:if test="${not empty allAds }">
			<c:forEach items="${allAds}" var="ad">
				<div class="ad-list-item">
					<div>
						<b style="line-height: 0.75em;"><c:out value="${ad.getTitle() }"/></b>
						<a href="${pageContext.request.contextPath }/admin/delete-ad/${ad.getId()}" class="btn floating-btn" onclick="return confirm('Na pewno usunąć?')">Usuń</a>
						<a href="${pageContext.request.contextPath }/admin/edit-ad/${ad.getId()}" class="btn floating-btn">Edytuj</a>
						<a href="${pageContext.request.contextPath }/admin/assign-category/${ad.getId()}" class="btn floating-btn">Przypisz kategorie</a>						
					</div>
					<hr>
					Opublikował: <c:out value="${ad.getUser().getFullname() }"/>   (<c:out value="${ad.getUser().getUsername() }"/>)<br>
					<c:set value="${ad.getCategories() }" var="categories"></c:set>
					Kategorie: <c:forEach items="${categories }" var="cat"><c:out value="${cat.getName() }"/>  </c:forEach><br>
					<c:set value="${ad.getExpiryTimestamp() }" var="expiry"/>
					ważne do: <fmt:formatDate value="${expiry }" type="date" pattern="dd-MM-yyyy"/><br>
					<hr>
					<c:out value="${ad.getDescription() }"/>
				</div>
			</c:forEach>
		</c:if>
	</div>
</body>
</html>