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
		<h2>Witaj w Tablicy Ogłoszeń!</h2>
		<hr>
		<a href="${pageContext.request.contextPath}/user">Zaloguj się</a>
		<hr>
		<c:if test="${principal.username != null }">
			Witaj <sec:authentication property="principal.username"/>
		</c:if>
		<div id="ad-box">
			<c:forEach items="${ads}" var="ad">
				<div class="ad-item">
					<b style="line-height: 0.75em;"><c:out value="${ad.getTitle() }"/></b>
					<hr>
					opublikował: <c:out value="${ad.getUser().getUsername() }"/><br>
					telefon: <c:out value="${ad.getUser().getPhone() }"/><br>
					miejsce: <c:out value="${ad.getLocation() }"/><br>
					<c:set value="${ad.getExpiryTimestamp() }" var="expiry"/>
					ważne do: <fmt:formatDate value="${expiry }" type="date" pattern="dd-MM-yyyy"/><br>
					<hr>
					<c:out value="${ad.getDescription() }"/>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>