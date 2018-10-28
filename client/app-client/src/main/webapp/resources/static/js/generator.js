
$(document).ready(function(){
	$("#generateText").click(function(){
		$.ajax({
			type: "POST",
			dataType: "json",
			data: {
				size : $("#text-size").val()
				},
			url: "http://localhost:8080/service-rest/rest/generator",
			beforeSend: function(){
				$("#generateText").empty();
				$("#generateText").append("<span class='loader'><div class='lds-ring'><div></div><div></div><div></div><div></div></div></span>");
			},
			success: function(msg){
				$(".loader").remove();
				$("#generateText").html("G&#233;n&#233;rer une liste");
				if(msg.content.length){
					$(".text-zone").empty();
					$(".id-text").empty();
					$(".id-text").append("Requ&#234;te n&#176;" + msg.id);
					$(".text-zone").append(msg.content);
					$(".generation-area").addClass("bg-white shadow-sm rounded");
					if(!$("#sortUp").length){
						$(".generation-area").after('<button id="sortAlph" class="btn btn-primary float-right" type="button">Trier par ordre alphab&#233;tique</button>');
						$(".generation-area").after('<button id="sortUp" class="btn btn-primary float-right" type="button">Trier par taille</button>');
					}
				}else{
					$(".text-zone").empty();
					$(".text-zone").append("Probleme de communication avec le serveur");
				}
			}
		});
	});
	var order = "up";
	$("body").on("click", "#sortUp", function(){
		order = order == "up" ? "down" : "up";
		$.ajax({
			type: "POST",
			dataType: "json",
			url: "http://localhost:8080/service-rest/rest/sort",
			data: {
				content : $(".text-zone").text(),
				order : order
			},
			beforeSend: function(){
				$("#sortUp").empty();
				$("#sortUp").append("<span class='loader'><div class='lds-ring'><div></div><div></div><div></div><div></div></div></span>");
			},
			success: function(msg){
				$(".loader").remove();
				$("#sortUp").html("Trier par taille");
				if(msg.content.length){
					$(".text-zone").empty();
					$(".text-zone").append(msg.content);
				}else{
					$(".text-zone").empty();
					$(".text-zone").append("Probleme de communication avec le serveur");
				}
			}
		});
	});
	$("body").on("click", "#sortAlph", function(){
		$.ajax({
			type: "POST",
			dataType: "json",
			url: "http://localhost:8080/service-rest/rest/sortAlph",
			data: {
				content : $(".text-zone").text()
			},
			beforeSend: function(){
				$("#sortAlph").empty();
				$("#sortAlph").append("<span class='loader'><div class='lds-ring'><div></div><div></div><div></div><div></div></div></span>");
			},
			success: function(msg){
				$(".loader").remove();
				$("#sortAlph").html("Trier par ordre alphab&#233;tique");
				if(msg.content.length){
					$(".text-zone").empty();
					$(".text-zone").append(msg.content);
				}else{
					$(".text-zone").empty();
					$(".text-zone").append("Probleme de communication avec le serveur");
				}
			}
		});
	});
	$("body").on("click", "#getFullText", function(){
		$.ajax({
			type: "GET",
			dataType: "json",
			url: "http://localhost:8080/service-rest/rest/get-text",
			beforeSend: function(){
				$("#getFullText").empty();
				$("#getFullText").append("<span class='loader'><div class='lds-ring'><div></div><div></div><div></div><div></div></div></span>");
			},
			success: function(msg){
				$(".loader").remove();
				$("#getFullText").html("Voir le texte original");
				if(msg.content.length){
					$(".text-zone").empty();
					$(".id-text").empty();
					$(".id-text").append("Requ&#234;te n&#176;" + msg.id);
					$(".text-zone").append(msg.content);
					$(".generation-area").addClass("bg-white shadow-sm rounded");
					if(!$("#sortUp").length){
						$(".generation-area").after('<button id="sortAlph" class="btn btn-primary float-right" type="button">Trier par ordre alphab&#233;tique</button>');
						$(".generation-area").after('<button id="sortUp" class="btn btn-primary float-right" type="button">Trier par taille</button>');
					}
				}else{
					$(".text-zone").empty();
					$(".text-zone").append("Probleme de communication avec le serveur");
				}
			}
		});
	});
});