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
		<h2>Tablica Ogłoszeń</h2>
		<hr>
		Witaj <sec:authentication property="principal.username"/><br>
		<hr>
		<div id="navbar">
			<div class="row">
				<div class="col-2">
					<a href="${pageContext.request.contextPath}/user/my-ads/${loggedUserId}" role="button" class="btn btn-secondary" aria-pressed="true">Moje ogłoszenia</a>		
				</div>
				<div class="col-2">
					<a href="${pageContext.request.contextPath}/user/new-ad" role="button" class="btn btn-secondary" aria-pressed="true">Nowe ogłoszenie</a>
				</div>
				<div class="col-2">
					<form:form action="${pageContext.request.contextPath}/logout" method="POST">
						<input type="submit" value="Wyloguj się" role="button" class="btn btn-secondary" aria-pressed="true">
					</form:form>
				</div>
				<div class="col-2">
					<a href="${pageConext.request.contextPath}/Adboard/user/delete-user" role="button" class="btn btn-secondary" aria-pressed="true" 
					onclick="return confirm('Na pewno usunąć konto?')">Usuń konto</a>
				</div>
				<div class="col-4"></div>
			</div>
		</div>
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
				<%int i = 1; %>
				<c:forEach items="${currentAds}" var="ad">
					<c:set value="${ad.getComments() }" var="comments"/>
					<div class="ad-list-item" data-row="<%=i %>"><%i++; %>
						<c:if test="${not empty comments }">
							<button class="show-comments-btn" style="float: right;">Zobacz komentarze</button>
						</c:if>
						<button class="add-comment-btn" style="float: right;">Dodaj komentarz</button>
						<b style="line-height: 150%;"><c:out value="${ad.getTitle() }"/></b>
						<br>
						opublikował: <c:out value="${ad.getUser().getFullname() }"/><br>
						telefon: <c:out value="${ad.getUser().getPhone() }"/><br>
						miejsce: <c:out value="${ad.getLocation() }"/><br>
						<c:set value="${ad.getExpiryTimestamp() }" var="expiry"/>
						ważne do: <fmt:formatDate value="${expiry }" type="date" pattern="dd-MM-yyyy"/>
						<br>
						<c:out value="${ad.getDescription() }"/>
						<c:set value="${ad.getCategories() }" var="categories"></c:set>
						<c:if test="${not empty categories }">
							<div>Kategorie: <c:forEach items="${categories }" var="cat"><c:out value="${cat.getName() }"/>&nbsp&nbsp&nbsp</c:forEach></div>
						</c:if>
					</div>
					<c:if test="${not empty comments }">
						<div class="comment-box hide">
							<c:forEach items="${comments }" var="comment">
								<div class="comment-item">
									<b><c:out value="${comment.getUser().getUsername() }"/></b>
									<c:out value="${comment.getContent() }"/>
								</div>
							</c:forEach>							
						</div>
					</c:if>
					<!-- Tu jest formularz dodania komentarza -->
					<div class="new-comment-box hide">
						<form class="new-comment-form">
							<input name="content" type="text" size="120">
							<input name="adId" type="hidden" value="${ad.getId() }">
							<input name="userId" type="hidden" value="${loggedUserId }">
							<input type="submit" value="Wyślij">
						</form>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>