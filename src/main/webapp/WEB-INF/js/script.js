$(function() {
	
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
})