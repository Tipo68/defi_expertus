
$(document).ready(function(){
	$("#generateText").click(function(){
		$.ajax({
			type: "GET",
			dataType: "json",
			url: "http://localhost:8080/service-rest/rest/generator",
			success: function(msg){
				if(msg.content.length){
					$(".text-zone").empty();
					$(".id-text").empty();
					$(".id-text").append(msg.id);
					$(".text-zone").append(msg.content);
					if(!$("#sortUp").length){
						$(".generation-area").after('<button id="sortUp" class="btn btn-primary" type="button">Trier par taille</button>');
					}
				}
			}
		});
	});
	var order = "up";
	$(".container-fluid").on("click", "#sortUp", function(){
		order = order == "up" ? "down" : "up";
		$.ajax({
			type: "POST",
			dataType: "json",
			url: "http://localhost:8080/service-rest/rest/generator",
			data: {
				content : $(".text-zone").text(),
				order : order
			},
			success: function(msg){
				if(msg.content.length){
					$(".text-zone").empty();
					$(".text-zone").append(msg.content);
					if(!$("#sortUp").length){
						$(".generation-area").after('<button id="sortUp" class="btn btn-primary" type="button">Trier par taille</button>');
					}
				}
			}
		});
	});
});