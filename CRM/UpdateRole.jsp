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
 <%@ include file="Header.jsp" %>
 
 <h1>Update Role</h1>
<form action="controller?action=doupdaterole&roleID=${roleObject.roleID}" method="post">
<table>
<tr><td>Role ID</td><td><c:out value="${roleObject.roleID}" /></td></tr>
<tr><td>Role Name:</td><td><input type="text" name="roleName" placeholder="${roleObject.name}"></td></tr>
<tr><td>Role Description:</td><td><input type="text" name="roledesc" placeholder="${roleObject.roleDesc}"></td></tr>
<tr><td><input type="submit" value="Update"></td></tr>
</table>
</form>
</body>
</html>