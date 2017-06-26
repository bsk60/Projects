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
   <%@ include file="Header.jsp" %>
<h1>Role Permissions</h1>

<form action="controller?action=addperm" method="post">
	<table class="table table-bordered">
		<tr>
			<th>Role Name:</th><th> Add customer</th><th>Change Pass</th><th>Admin Setings</th><th>Users</th><th>User Settings</th><th>Roles</th><th>Roles Perm</th>
		</tr>
		<tr>
			<td><select name="roleName">
					<c:forEach var="user" items="${roleList}">
						<option value="${user.name}">${user.name}</option>
					</c:forEach>

			</select></td>
			<td><input type="checkbox" name="addCustomer" /></td>
			<td><input type="checkbox" name="changePass" /></td>
			<td><input type="checkbox" name="adminSettings" /></td>
			<td><input type="checkbox" name="users" /></td>
			<td><input type="checkbox" name="userSettings" /></td>
			<td><input type="checkbox" name="roles" /></td>
			<td><input type="checkbox" name="rolesPermission" /></td>
			<td><input type="submit" value="Add"></td>
		</tr>
	</table>
</form>

<br>
<table class="table table-bordered">
	<tr>
		<th>Role Name</th>
		<th>Add Customer</th>
		<th>Change Password</th>
		<th>Admin Settings</th>
		<th>Users</th>
		<th>User Settings</th>
		<th>Roles</th>
		<th>Roles Permission</th>
	</tr>
	<c:forEach var="user" items="${permList}">
		<tr>
			<td><c:out value="${user.role.getName()}" /></td>
			<td><c:out value="${user.addCustomer}" /></td>
			<td><c:out value="${user.changePass}" /></td>
			<td><c:out value="${user.adminSettings}" /></td>
			<td><c:out value="${user.users}" /></td>
			<td><c:out value="${user.userSettings}" /></td>
			<td><c:out value="${user.roles}" /></td>
			<td><c:out value="${user.rolesPermission}" /></td>
			<td><a href="controller?action=updaterole&name=${user.role.getName()}">update</a></td>
			<td><a href="controller?action=deleterole&name=${user.role.getName()}">delete</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>