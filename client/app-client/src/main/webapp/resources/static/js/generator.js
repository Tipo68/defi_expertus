
$(document).ready(function(){
	$("#generateText").click(function(){
		$.ajax({
			type: "GET",
			dataType: "json",
			url: "http://localhost:8080/service-rest/rest/generator?name=tipo",
			success: function(msg){
				$(".text-zone").empty();
				$(".id-text").empty();
				$(".id-text").append(msg.id);
				$(".text-zone").append(msg.content);
			}
		});
	});
});