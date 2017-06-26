<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<%
	if (session.getAttribute("user") == null) {
		response.sendRedirect("index.jsp"); // GO TO LOGIN PAGE
	}
%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link href='https://fonts.googleapis.com/css?family=PT+Sans'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="style.css">
<script src="validate.js" type="text/javascript"></script>
</head>

<body>
	<%@ include file="Header.jsp"%>


	<!--Table of client data and modal button below it (or vice versa)  -->
	<h1>Clients</h1>
	<br>

	<button class="btn btn-primary btn-lg" data-toggle="modal"
		data-target="#myModalHorizontal">Add Client</button>

	<div class="modal fade" id="myModalHorizontal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Client Information</h4>
				</div>

				<div class="modal-body">

					<form action="controller?action=addcus" class="form-horizontal"
						role="form" method="post">
						<div class="form-group">
							<label class="col-sm-2 control-label" for="inputEmail3">Client
								Name</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="clientName"
									placeholder="Name" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="inputPassword3">Contact
								Person</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="contactName"
									placeholder="Name" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="inputPassword3">Phone</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="phone"
									placeholder="Phone #" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="inputPassword3">Email</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" name="email"
									placeholder="Email" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="inputPassword3">Address</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="street"
									placeholder="Street" /> <input type="text"
									class="form-control" name="city" placeholder="City" /> <input
									type="text" class="form-control" name="state"
									placeholder="State" /> <input type="text" class="form-control"
									name="zip" placeholder="Zip" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label" for="inputPassword3">Is
								Customer?</label>
							<div class="col-sm-10">
								<select name="isCustomer">
									<option value="No">No</option>
									<option value="Yes">Yes</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="inputPassword3">Offer</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="offer"
									placeholder="$0.00" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">Add
									Client</button>
							</div>
						</div>
					</form>

				</div>

			</div>
		</div>
	</div>

	<table class="table table-bordered">
		<tr>
			<th>Client Name</th>
			<th>Contact Person</th>
			<th>Phone</th>
			<th>Offer</th>
		</tr>
		<c:forEach var="user" items="${clientList}">
			<tr>
				<td><c:out value="${user.clientName}" /></td>
				<td><c:out value="${user.contactName}" /></td>
				<td><c:out value="${user.phone}" /></td>
				<td><c:out value="${user.offer}" /></td>
				<td>
				<a href="controller?action=updatecus&id=${user.id }"><button
							class="btn btn-default">update</button></a></td>
				<td><a href="controller?action=deletecus&id=${user.id }"><button
							class="btn btn-default">delete</button></a></td>

			</tr>
		</c:forEach>
	</table>

</body>
</html>