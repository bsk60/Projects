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
<link href="style.css" rel="stylesheet">
<link href='https://fonts.googleapis.com/css?family=PT+Sans'
	rel='stylesheet' type='text/css'>
</head>

<body>
<%@ include file="Header.jsp"%>
<h1>Roles</h1>
<form action="controller?action=addrole" method="post">
	<table class="table table-bordered">
		<tr>
			<td>Role Name:</td>
			<td><input type="text" name="rolename"></td>
		</tr>
		<tr>
			<td>Role Description</td>
			<td><input type="text" name="roledesc"></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Submit"></td>
		</tr>
	</table>
</form>

<br>

<table class="table table-bordered">
	<tr>
		<th>Role ID</th>
		<th>Role Name</th>
		<th>Role Description</th>
	</tr>
	<c:forEach var="user" items="${roleList}">
		<tr>
			<td><c:out value="${user.roleID}" /></td>
			<td><c:out value="${user.name}" /></td>
			<td><c:out value="${user.roleDesc}" /></td>
			<td><a href="controller?action=updaterole&name=${user.name}">update</a></td>
			<td><a href="controller?action=deleterole&name=${user.name}">delete</a></td>
		</tr>
	</c:forEach>
</table>
<!--  
<script type="text/javascript">
if(status == false){

	alert("This role is in use");
}
</script>
-->




</body>
</html>