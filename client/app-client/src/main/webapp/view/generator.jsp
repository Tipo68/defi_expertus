<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<spring:url value="/resources/css/generator.css" var="style" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${style}" />

</head>
<head>
<title>${title}</title>
</head>
<body>
	<div class="container-fluid">
		<div class="header row">
			<h1 class="display-1 expertus-title">Hello Expertus</h1>
		</div>
		<button id="generateText" type="button" class="btn btn-primary">Générer un texte</button>
		<div class="generation-area row">

			<div class="col-sm-2">
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
