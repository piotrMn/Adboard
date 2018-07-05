<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
	<script	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js"></script>
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
	<script type="text/javascript" charset="UTF-8"><%@include file="/WEB-INF/js/script.js"%></script>
	<style><%@include file="/WEB-INF/css/style.css"%></style>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
	<meta name="_csrf" content="${_csrf.token}"/>
	<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<h2>Tablica ogłoszeń <small style="font-size: 0.5em">wersja gamma</small></h2>
		<hr>
		Witaj <sec:authentication property="principal.username"/><br>
		<hr>
		<div id="navbar">
			<div class="row">
				<div class="col-2">
					<form:form action="${pageContext.request.contextPath}/logout" method="POST">
						<input type="submit" value="Wyloguj się" role="button" class="btn btn-secondary" aria-pressed="true">
					</form:form>
				</div>
				<div class="col-2">
					<a href="${pageContext.request.contextPath}/user" role="button" class="btn btn-secondary" aria-pressed="true">Powrót</a>
				</div>
				<div class="col-2">
					<a href="${pageContext.request.contextPath}/user/new-ad" role="button" class="btn btn-secondary" aria-pressed="true">Nowe ogłoszenie</a>
				</div>
				<div class="col-2">
					<a href="${pageConext.request.contextPath}/Adboard/user/delete-user" role="button" class="btn btn-secondary" aria-pressed="true" 
					onclick="return confirm('Na pewno usunąć konto?')">Usuń konto</a>
				</div>
				<div class="col-4"></div>
			</div>
		</div>
		<c:if test="${not empty ads }">
			<b>Twoje ogłoszenia</b>
			<c:forEach items="${ads}" var="ad">
				<div class="ad-list-item">
					<div>
						<b style="line-height: 0.75em;"><c:out value="${ad.getTitle() }"/></b>
						<a href="${pageContext.request.contextPath }/user/edit-ad/${ad.getId()}" class="btn floating-btn">Edytuj</a>
						<a href="${pageContext.request.contextPath }/user/delete-ad/${ad.getId()}" class="btn floating-btn" onclick="return confirm('Na pewno usunąć?')">Usuń</a>						
					</div>
					<hr>
					<c:set value="${ad.getExpiryTimestamp() }" var="expiry"/>
					ważne do: <fmt:formatDate value="${expiry }" type="date" pattern="dd-MM-yyyy"/><br>
					<hr>
					<c:out value="${ad.getDescription() }"/>
				</div>
			</c:forEach>
		</c:if>
		<c:if test="${empty ads }">
			<b>Nie opublikowaleś jeszcze ogłoszeń.</b>
		</c:if>
	</div>
</body>
</html>