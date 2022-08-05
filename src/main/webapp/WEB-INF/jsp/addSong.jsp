<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page import="ch.pouet.rms.model.Song,java.util.List"%>
<%@ page isELIgnored="false" %>


<!DOCTYPE html>
<html>
<head>
<title>Songs.</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->

<spring:url value="/css/bootstrap.min.css" var="bootstrapStyle" />
<spring:url value="/css/font-awesome.css" var="fontAweSomeStyle" />
<spring:url value="/css/main.css" var="mainCss" />

<link href="${bootstrapStyle}" rel="stylesheet" media="screen">
<link href="${fontAweSomeStyle}" rel="stylesheet" media="screen">
<link href="${mainCss}" rel="stylesheet" media="screen">

<script>
	function validateForm() {
		var form = document.forms["addSong"];
		var name = form["url"].value;
		if (url.trim() === "") {
			alert("Pas d'url");
			console.log("no name");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<header class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<a class="navbar-brand" href="page"> Titre </a>
		</div>
	</header>
	<section id="main">
		<div class="container">
			<div class="row">
				<div class="col-xs-8 col-xs-offset-2 box">
					<h1>Add Song</h1>
					<form name="add" action="add" method="POST"
						onsubmit="return validateForm()">
						<fieldset>
							<div class="form-group">
								<label for="url">url</label> <input
									type="text" class="form-control" id="url"
									name="url" placeholder="url">
							</div>
							<div class="form-group">
                                <label for="submittedBy"> submittedBy </label>
                                <input
                                    type="text" class="form-control" id="submittedBy"
                                    name="submittedBy" placeholder="submittedBy">
                            </div>
                             <div class="form-group">
							    <label for="name"> name </label>
							    <input
                                    type="text" class="form-control" id="name"
    						        name="name" placeholder="name">
    						</div>
						</fieldset>
						<div class="actions pull-right">
							<input type="submit" value="add" class="btn btn-primary">
							or <a href="page" class="btn btn-default">Cancel</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
</body>
</html>