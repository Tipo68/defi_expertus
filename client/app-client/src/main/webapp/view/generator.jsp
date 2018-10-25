<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" />

</head>
<head>
<title>${personne}</title>
</head>
<body>
	<div class="container">

		<button id="generateText">Générer un texte</button>

		<div class="generation-area row">

			<div class="col-sm">
				<div class="id-text"></div>
			</div>
			<div class="col-sm">
				<div class="text-zone"></div>
			</div>
		</div>
	</div>
	
	<spring:url value="/resources/js/generator.js" var="generator" />
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${generator}"></script>

</body>
</html>
