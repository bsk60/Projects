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
<title>Update Customer</title>
</head>

<body>
	<%@ include file="Header.jsp"%>
	<h1>Update Customer</h1>
	<br>
	<form action="controller?action=doupdatecus&id=${cusObject.id }"
		name="updateC" method="post">
		<table>
			<tr>
				<td>Client ID:</td>
				<td><c:out value="${cusObject.id}" /></td>
			</tr>
			<tr>
				<td>Client Name:</td>
				<td><input type="text" name="clientName"
					placeholder="<c:out value="${cusObject.clientName}"/>" required></td>
			</tr>
			<tr>
				<td>Contact Person:</td>
				<td><input type="text" name="contactPerson"
					placeholder="<c:out value="${cusObject.contactName}"/>" required></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><input type="text" name="phone"
					placeholder="<c:out value="${cusObject.phone}"/>" required></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email"
					placeholder="<c:out value="${cusObject.email}"/>" required></td>
			</tr>
			<tr>
				<td>Address</td>
				<td></td>
			</tr>
			<tr>
				<td>Street:</td>
				<td><input type="text" name="street"
					placeholder="<c:out value="${cusObject.address.street}"/>" required></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><input type="text" name="city"
					placeholder="<c:out value="${cusObject.address.city}"/>" required></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><input type="text" name="state"
					placeholder="<c:out value="${cusObject.address.state}"/>" required></td>
			</tr>
			<tr>
				<td>Zip:</td>
				<td><input type="text" name="zip"
					placeholder="<c:out value="${cusObject.address.zip}"/>" required></td>
			</tr>
			<tr>
				<td>Is Customer?:</td>
				<td><select name="isCustomer">
						<option value="No">No</option>
						<option value="Yes">Yes</option>
				</select></td>
			</tr>
			<tr>
				<td>Offer:</td>
				<td><input type="text" name="offer"
					placeholder="<c:out value="${cusObject.offer}"/>" required></td>
			</tr>
			<tr>
				<td><button type="submit" class="btn btn-default">Update
						Client</button></td>
			</tr>
		</table>
	</form>

</body>
</html>