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
					<a href="${pageContext.request.contextPath}/ad/new" role="button" class="btn btn-secondary" aria-pressed="true">Nowe ogłoszenie</a>
				</div>
				<div class="col-8"></div>
			</div>
		</div>
		<c:if test="${not empty ads }">
			<div id="ad-box">
				<b>Twoje ogłoszenia</b>
				<c:forEach items="${ads}" var="ad">
					<div class="ad-item">
						<div>
							<b style="line-height: 0.75em;"><c:out value="${ad.getTitle() }"/></b>
							<a href="${pageContext.request.contextPath }/ad/edit/${ad.getId()}" class="btn floating-btn">Edytuj</a>
							<a href="${pageContext.request.contextPath }/ad/delete/${ad.getId()}" class="btn floating-btn" onclick="return confirm('Na pewno usunąć?')">Usuń</a>						
						</div>
						<hr>
						<c:set value="${ad.getExpiryTimestamp() }" var="expiry"/>
						ważne do: <fmt:formatDate value="${expiry }" type="date" pattern="dd-MM-yyyy"/><br>
						<hr>
						<c:out value="${ad.getDescription() }"/>
					</div>
				</c:forEach>
			</div>
		</c:if>
	</div>
</body>
</html>