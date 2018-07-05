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
	$(".show-comments-btn").click(function() {
		$(this).parent().next().toggle();
	})
	
	$(".add-comment-btn").click(function(){
		$(this).parent().next().next().toggle();
	})
	//Poniższa metoda ma wysyłać nowy komentarz do Rest
	$(".new-comment-form").submit(function(event){
		event.preventDefault();
		var content = $(this).find("input[name='content']").val();
		var userId = $(this).find("input[name='userId']").val();
		var adId = $(this).find("input[name='adId']").val();
		var userJson = null;
		var adJson = null;
		var nowJson = null;
		//Pobranie aktualnego czasu
		$.ajax({
			url: 'http://localhost:8080/Adboard/rest/now',
			type: 'GET',
			dataType: 'json'})
		.done(function(now){
			nowJson = now;
		})
		.fail(function(){})
		.always(function(){})
		//Pobranie użytkownika (autora komentarza)
		$.ajax({
			url: 'http://localhost:8080/Adboard/rest/users/' + userId,
			type: 'GET',
			dataType: 'json'})
		.done(function(user){
			userJson = user;
		})
		.fail(function(){})
		.always(function(){})
		//Pobranie komentowanego ogłoszenia
		$.ajax({
			url: 'http://localhost:8080/Adboard/rest/ads/' + adId,
			type: 'GET',
			dataType: 'json'})
		.done(function(ad){
			adJson = ad
		})
		.fail(function(){})
		.always(function(){})
		
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		//wysłanie komentarza do Rest w celu zapisania
		$.ajax({
			url: 'http://localhost:8080/Adboard/rest/comments',
			type: 'POST',
			headers: {
				'Accept': 'application/json',
				'Content-Type' : 'application/json'
			},
			beforeSend: function(xhr){
				xhr.setRequestHeader(header, token);
			},
			data : JSON.stringify({
				"content" : content,
				"creationTimestamp" : nowJson,
				"user" : userJson,
				"ad" : adJson
				}),
			dataType: 'json'
			})
		.done(function(){
			
			})
		.fail(function(){console.log('failed to add comment')})
		.always(function(){console.log('finished')});
		});
	
})