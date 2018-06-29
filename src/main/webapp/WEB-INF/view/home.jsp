<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
	<script	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js"></script>
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
	<script type="text/javascript" charset="UTF-8"><%@include file="/WEB-INF/js/script.js"%></script>
	<style><%@include file="/WEB-INF/css/style.css"%></style>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<h2>Tablica Ogłoszeń</h2>
		<hr>
		<a href="${pageContext.request.contextPath}/user" role="button" class="btn btn-secondary" aria-pressed="true">Zaloguj się</a>
		<a href="${pageContext.request.contextPath}/signup" role="button" class="btn btn-secondary" aria-pressed="true">Zarejestruj się</a>
		<hr>
		<div class="row">
			<div class="col-2">
				<c:if test="${not empty allCategories }">
					<div id="category-box">
						<b>Kategorie:</b>
						<div class="category-list-item">Wszystkie</div>
						<c:forEach items="${allCategories }" var="category">
							<div class="category-list-item"><c:out value="${category.getName() }"/></div>
						</c:forEach>
					</div>
				</c:if>
			</div>
			<div class="col-10">
				<div id="ad-box">
				<%int i = 1; %>
				<c:forEach items="${currentAds}" var="ad">
					<div class="ad-list-item" data-row="<%=i %>">
						<b style="line-height: 0.75em;"><c:out value="${ad.getTitle() }"/></b>
						<hr>
						opublikował: <c:out value="${ad.getUser().getFullname() }"/><br>
						telefon: <c:out value="${ad.getUser().getPhone() }"/><br>
						miejsce: <c:out value="${ad.getLocation() }"/><br>
						<c:set value="${ad.getExpiryTimestamp() }" var="expiry"/>
						ważne do: <fmt:formatDate value="${expiry }" type="date" pattern="dd-MM-yyyy"/><br>
						<hr>
						<c:out value="${ad.getDescription() }"/>
						<c:set value="${ad.getCategories() }" var="categories"></c:set>
						<c:if test="${not empty categories }">
						Kategorie: <div><c:forEach items="${categories }" var="cat"><c:out value="${cat.getName() }"/>&nbsp&nbsp&nbsp</c:forEach></div><br>
						</c:if>
						</div>
						<%i++; %>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>
</html>