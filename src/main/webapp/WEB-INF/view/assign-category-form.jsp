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
		<h4>Dodaj kategorie</h4>
		<hr>
		<div class="row">
			<div class="col-9">
				<div class="ad-list-item">
					<b style="line-height: 0.75em;"><c:out value="${thisAd.getTitle() }"/></b>
					<hr>
					opublikował: <c:out value="${thisAd.getUser().getFullname() }"/><br>
					telefon: <c:out value="${thisAd.getUser().getPhone() }"/><br>
					miejsce: <c:out value="${thisAd.getLocation() }"/><br>
					<c:set value="${thisAd.getExpiryTimestamp() }" var="expiry"/>
					ważne do: <fmt:formatDate value="${expiry }" type="date" pattern="dd-MM-yyyy"/><br>
					<hr>
					<c:out value="${thisAd.getDescription() }"/>
				</div>
			</div>
			<div class="col-3">
				<form action="${pageContext.request.contextPath}/admin/assign-category/${thisAd.getId() }" method="post">
					<select multiple="multiple" name="categories">
						<c:forEach items="${allCategories }" var="category">
							<option value="${category.getId() }" label="${category.getName() }">
						</c:forEach>
					</select>
					<input type="submit" value="Zatwierdź">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				</form>
				<div>
					<c:if test="${error eq 'toomany' }">Maksymalnie 3</c:if>
				</div>
			</div>
		</div>
		<div>
			<a href="${pageContext.request.contextPath}/admin/manage" role="button" class="btn btn-secondary" aria-pressed="true">Powrót</a>
		</div>
	</div>
</body>
</html>