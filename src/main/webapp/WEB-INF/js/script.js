$(function() {
	//wyświetlanie komentarzy według kategorii
	$(".category-list-item").click(function() {
		var category = $(this).text();
		if(category.indexOf("Wszystkie") >= 0){
			$(".ad-list-item").show();
		}
		else{
			$(".ad-list-item").hide();
			$(".ad-list-item").each(function(index, element){
				if($(element).find("div").text().indexOf(category) >= 0){
					$(element).show();
				}
			})
		}
	})
	
	
	//wyswietlenie komentarzy
//	$(".show-comments-btn").click(function(event) {
//		var commentBox = $(this).parent().next();
//		var token = $("meta[name='_csrf']").attr("content");
//		var header = $("meta[name='_csrf_header']").attr("content");
//		var adId = $(this).parent().find("input[name='adId']").val();
//		var username = $(this).parent().find("input[name='username']").val();
//		var password = $(this).parent().find("input[name='password']").val();
//		commentBox.empty();
//		$.ajax({
//			url: 'http://localhost:8080/Adboard/rest/comments/' + adId,
//			type: 'GET',
//			headers: {
//				'Accept': 'application/json',
//				'Content-Type' : 'application/json',
//				'Authorization' : 'Basic ' + btoa(username + ':' + password)
//			},
//			beforeSend: function(xhr){
//				xhr.setRequestHeader(header, token);
//			},
//			dataType: 'json'
//			})
//		.done(function(comments){
//			$(comments).each(function(index, comment){
//				var text = comment.content;
//				var username = comment.user.username;
//				var time = formatTimestamp(comment.creationTimestamp);
//				commentBox.append(username + " - " + time).append("<br>").append(text).append("<hr>");
//			});
//			commentBox.append("<button class='hide-comments'>Ukryj</button>");
//			$(".hide-comments").click(function(){
//				commentBox.hide();
//			})
//			commentBox.show();
//		})
//		.fail(function(){console.log('failed to get comments')})
//		.always(function(){console.log('finished')});
//	})
	$(".show-comments-btn").click(function(){
		$(this).parent().next().toggle();
	})
	//wlaczenie formularza dla komentarza
	$(".add-comment-btn").click(function(){
		$(this).parent().prev().show();
	})
	//Poniższa metoda ma wysyłać nowy komentarz do Rest
	$(".new-comment-form").submit(function(event){
		event.preventDefault();
		var commentBox = $(this).parent().next().next();
		var newCommentForm = $(this).parent();
		var content = $(this).find("input[name='content']").val();
		var userId = $(this).find("input[name='userId']").val();
		var adId = $(this).find("input[name='adId']").val();
		var username = $(this).find("input[name='username']").val();
		var password = $(this).find("input[name='password']").val();
		
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		$.ajax({
			url: 'http://localhost:8080/Adboard/rest/comments',
			type: 'POST',
			headers: {
				'Accept': 'application/json',
				'Content-Type' : 'application/json',
				'Authorization' : 'Basic ' + btoa(username + ':' + password)
			},
			beforeSend: function(xhr){
				xhr.setRequestHeader(header, token);
			},
			data : JSON.stringify({
				"content" : content ,
				"username" : username,
				"adId" : adId,
				"userId" : userId
				}),
			dataType: 'json'
			})
		.done(function(comment){
			var username = comment.username;
			var content = comment.content;
			var time = new Date().toLocaleString();
			var newDiv = $("<div class='comment-item'>" + username + " - " + time +  "<br>" + content + "</div>");
			commentBox.prepend(newDiv);
			newCommentForm.hide();
			commentBox.show();
			
		})
		.fail(function(){console.log('failed to add comment')})
		.always(function(){console.log('finished')});
		});
})