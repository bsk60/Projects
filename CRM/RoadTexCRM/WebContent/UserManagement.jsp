<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<%
        if(session.getAttribute("user")==null)
            {
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
</head>

<body>
<%@ include file="Header.jsp"%>
<h1>User Management</h1>
<form action="controller?action=adduser" method="post">
	<table  class="table table-bordered">
		<tr>
			<td>First Name:</td>
			<td><input type="text" name="fname"></td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td><input type="text" name="lname"></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input type="text" name="email"></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="text" name="pass"></td>
		</tr>
		<tr>
			<td>Role:</td>
			<td><select name="roleName">
					<c:forEach var="user" items="${roleList}">
						<option value="${user.name}">${user.name}</option>
					</c:forEach>

			</select></td>
			<td><input type="submit" value="Add"></td>
		</tr>
	</table>
</form>
<br>
<table  class="table table-bordered">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th></th>
		<th>Email</th>
		<th>Role Name</th>
		<th>Role Description</th>
	</tr>
	<c:forEach var="user" items="${empList}">
		<tr>
			<td><c:out value="${user.empID}" /></td>
			<td><c:out value="${user.fname}" /></td>
			<td><c:out value="${user.lname}" /></td>
			<td><c:out value="${user.email}" /></td>
			<td><c:out value="${user.role.name}" /></td>
			<td><c:out value="${user.role.roleDesc}" /></td>
			<td><a href="controller?action=updateuser&email=${user.email}">update</a></td>
			<td><a href="controller?action=deleteuser&email=${user.email}">delete</a></td>
		</tr>
	</c:forEach>
</table>
<br>
<br>
<!-- <script type="text/javascript">
if(status == false){

	alert("This role is in use");
}
</script>

-->
</body>
</html>