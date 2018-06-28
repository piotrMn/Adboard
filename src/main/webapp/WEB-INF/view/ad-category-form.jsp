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
		<h4>Dodaj kategorie</h4>
		<hr>
		<div class="list-item">
			<b style="line-height: 0.75em;"><c:out value="${ad.getTitle() }"/></b>
			<hr>
			opublikował: <c:out value="${ad.getUser().getFullname() }"/><br>
			telefon: <c:out value="${ad.getUser().getPhone() }"/><br>
			miejsce: <c:out value="${ad.getLocation() }"/><br>
			<c:set value="${ad.getExpiryTimestamp() }" var="expiry"/>
			ważne do: <fmt:formatDate value="${expiry }" type="date" pattern="dd-MM-yyyy"/><br>
			<hr>
			<c:out value="${ad.getDescription() }"/>
		</div>
		
		<form action="${pageContext.request.contextPath }/admin/addcat/${ad.getId() }" method="POST" accept-charset="UTF-8">
			<select name="categories" multiple="multiple">
				<c:forEach items="${categories }" var="category">
					<option value="${category }"></option>
				</c:forEach>
			</select>
			<input type="submit" value="Prześlij">
		</form>
	</div>
</body>
</html>