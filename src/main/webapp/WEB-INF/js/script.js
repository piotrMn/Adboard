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
		var fullname = $(this).find("input[name='fullname']").val();
		
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
				"fullname" : fullname,
				"adId" : adId,
				"userId" : userId
				}),
			dataType: 'json'
			})
		.done(function(comment){
			var username = comment.username;
			var content = comment.content;
			var d = new Date();
			var dateFormatted = d.getFullYear().toString()+"-"+((d.getMonth()+1).toString().length==2?(d.getMonth()+1).toString():"0"+(d.getMonth()+1).toString())+"-"+(d.getDate().toString().length==2?d.getDate().toString():"0"+d.getDate().toString())+" "+(d.getHours().toString().length==2?d.getHours().toString():"0"+d.getHours().toString())+":"+((parseInt(d.getMinutes()/5)*5).toString().length==2?(parseInt(d.getMinutes()/5)*5).toString():"0"+(parseInt(d.getMinutes()/5)*5).toString())+":00";
			console.log(dateFormatted);

			var newDiv = $("<div class='comment-item'>" + fullname + " (" + dateFormatted +  ")<br>" + content + "</div>");
			commentBox.prepend(newDiv);
			commentBox.find("p.no-comments").empty();
			newCommentForm.hide();
			commentBox.show();
			
		})
		.fail(function(){console.log('failed to add comment')})
		.always(function(){console.log('finished')});
		});
})