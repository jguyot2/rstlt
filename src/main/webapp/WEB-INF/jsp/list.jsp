
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page
	import="java.util.List,ch.pouet.rms.model.Song"%>
<%
    List<Song> songs = (List<Song>) request.getAttribute("songs");
    String message =(String) request.getAttribute("message");
%>
<html>
<head>
<title>...</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">F
<!-- Bootstrap -->
<link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="/css/font-awesome.css" rel="stylesheet" media="screen">
<link href="/css/main.css" rel="stylesheet" media="screen">
</head>
<body>
	<header class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<a class="navbar-brand" href="page"> Message = <%=message %>  </a>
		</div>
	</header>

	</section>
	<div class="container">
		<div id="actions" class="form-horizontal">
			<div class="pull-right">
				<a class="btn btn-success" id="addSong" href="/add">Add song</a>
			</div>
		</div>
	</div>
	<!-- Form de suppression  -->
	<form id="deleteForm" action="#" method="POST">
		<input type="hidden" name="selection" value="">
	</form>

	<div class="container" style="margin-top: 10px;">
		<table class="table table-striped table-bordered">
			<thead>
				<tr>

					</span></th>
					<th>Link</th>
					<th>Name</th>
					<th>Submission</th>
					<th>SubmittedBy</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<%
				    for (Song c : songs) {
				%>
				<tr>
					<td><a href="<%=c.getLink()%>">Lien</a> </td>
					<td><%=c.getName()%></td>
					<td><%=c.getSubmission()%></td>
					<td><%=c.getSubmittedBy()%></td>
					<td>pas implémenté :(</td>
					<%
					    }
					%>
				</tr>
			</tbody>
		</table>
	</div>

	<footer class="navbar-fixed-bottom">
		<div class="container text-center">
       	</div>
		<div class="btn-group btn-group-sm pull-right" role="group">
			<button type="button" class="btn btn-default">10</button>
			<button type="button" class="btn btn-default">50</button>
			<button type="button" class="btn btn-default">100</button>
		</div>

	</footer>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/dashboard.js"></script>

</body>
</html>