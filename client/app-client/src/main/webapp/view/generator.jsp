<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<spring:url value="/resources/css/generator.css" var="style" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="${style}" />

</head>
<head>
<title>${title}</title>
</head>
<body>
	<div class="container-fluid">
		<div class="header row">
			<h1 class="display-1 expertus-title">Hello Expertus !</h1>
		</div>
		<div class="row">
			<div class="col">
				<div class="alert alert-primary" role="alert">
					<span class="ico">?</span>Cliquez sur "Générer une liste" pour générer une liste de mots à
					partir d'un texte. <br>Vous pouvez voir ce texte grâce au
					bouton "Voir le texte original" ci-dessous !
				</div>
			</div>
		</div>
		<button id="getFullText" type="button" class="btn btn-secondary float-sm-right">Voir le texte original</button>
		<div class="form-row">
			<div class="col-auto">
				<button id="generateText" type="button" class="btn btn-primary">Générer	une liste</button>
			</div>	
			<div class="col-auto">
				<select id="text-size" class="form-control">
					<option value="200" selected>Nombre de mots ?</option>
					<option value="100">100 mots</option>
					<option value="200">200 mots</option>
					<option value="300">300 mots</option>
					<option value="400">400 mots</option>
					<option value="500">500 mots</option>
				</select>
			</div>
		</div>

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
